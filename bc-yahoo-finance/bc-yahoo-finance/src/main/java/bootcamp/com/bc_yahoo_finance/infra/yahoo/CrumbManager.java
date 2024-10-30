package bootcamp.com.bc_yahoo_finance.infra.yahoo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


@Service
public class CrumbManager {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private CookieManager cookieManager;

    public String getCrumb() throws IOException, InterruptedException {
        // Get cookies first
         String cookies = cookieManager.getResponse();
     //   System.out.println("cookies : " + cookies);

        // Now make a request to get the crumb
        String crumbUrl = "https://query1.finance.yahoo.com/v1/test/getcrumb";

        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(crumbUrl))
                .header("User-Agent", "Mozilla/5.0")
                .header("Accept", "*/*")
                .header("Cookie", cookies) // Pass cookies in the request
                .GET()
                .build();

        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        // The crumb is typically in the body of the response
        String crumb = httpResponse.body();
        String cookieAndCrumb = cookies.concat(",").concat(crumb);
        this.redisTemplate.opsForValue().set("cookieAndCrumb", cookieAndCrumb);
        System.out.println("Crumb: " + crumb);

        return crumb;
    }

    private String extractCookies(Map<String, List<String>> headers) {
        List<String> setCookieHeader = headers.get("Set-Cookie");
        if (setCookieHeader != null && !setCookieHeader.isEmpty()) {
            StringBuilder cookieBuilder = new StringBuilder();
            for (String cookie : setCookieHeader) {
                String singleCookie = cookie.split(";")[0];
                cookieBuilder.append(singleCookie).append("; ");
            }
            return cookieBuilder.toString();
        }
        return "";
    }
}