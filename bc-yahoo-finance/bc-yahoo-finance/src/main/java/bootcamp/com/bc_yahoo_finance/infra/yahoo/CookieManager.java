package bootcamp.com.bc_yahoo_finance.infra.yahoo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import bootcamp.com.bc_yahoo_finance.infra.web.UrlManager;

public class CookieManager {
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(new HttpComponentsClientHttpRequestFactory());
    }

    public CookieManager(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getCookie() {
        try {
            String cookitUrl = UrlManager.builder()
                    .domain(YahooFinance.DOMAIN_COOKIE)
                    .build()
                    .toUriString();
            System.out.println("cookitUrl :  " + cookitUrl);
            ResponseEntity<String> entity = restTemplate.getForEntity(cookitUrl, String.class);
            List<String> cookies = entity.getHeaders().get("Set-Cookie");
            return cookies != null ? cookies.get(0).split(",")[0] : null;
        } catch (RestClientException e) {

            if (e instanceof HttpStatusCodeException) {
                HttpHeaders headers = ((HttpStatusCodeException) e).getResponseHeaders();
                if (headers != null) {
                    List<String> cookies = headers.get("Set-Cookie");
                    return cookies != null ? cookies.get(0).split(",")[0] : null;
                }
            }
            return null;
        }
    }
}