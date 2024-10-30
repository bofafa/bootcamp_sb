package bootcamp.com.bc_yahoo_finance.infra.yahoo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class CookieManager {
    private Map<String, List<String>> headers;

    public String getResponse() throws IOException, InterruptedException {
        String urlString = "https://finance.yahoo.com/";

        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlString))
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                .header("Accept-Language", "en-US,en;q=0.5")
                .GET()
                .build();

        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        headers = httpResponse.headers().map();

        List<String> setCookieHeader = headers.get("Set-Cookie");
        if (setCookieHeader != null && !setCookieHeader.isEmpty()) {
            String setCookieValue = setCookieHeader.get(0).split(";")[0];
          //  System.out.println("Set-Cookie Header: " + setCookieValue);
            return setCookieValue;
        } else {
            return null;
        }
    }
}
