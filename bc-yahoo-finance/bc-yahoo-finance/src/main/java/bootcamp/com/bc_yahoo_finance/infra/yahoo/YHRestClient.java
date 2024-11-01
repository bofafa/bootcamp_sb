package bootcamp.com.bc_yahoo_finance.infra.yahoo;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.hc.client5.http.cookie.BasicCookieStore;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import bootcamp.com.bc_yahoo_finance.exception.StockQuoteYahooException;
import bootcamp.com.bc_yahoo_finance.infra.web.UrlManager;
import bootcamp.com.bc_yahoo_finance.model.dto.YahooQuoteDTO;
import bootcamp.com.bc_yahoo_finance.model.dto.YahooQuoteErrorDTO;

@Configuration
public class YHRestClient {

  private static final String USER_AGENT_STRING = "Mozilla/5.0";
  private final Object lock = new Object();

  private RestTemplate restTemplate;
  private CrumbManager crumbManager;
  private BasicCookieStore cookieStore; // BasicCookieStore from springboot

  // create an HttpCilent with a custo cookie store
  public YHRestClient() {
    this.cookieStore = new BasicCookieStore();
    CloseableHttpClient httpClient = HttpClients.custom()
        .setDefaultCookieStore(this.cookieStore)
        .build();

    HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
    factory.setHttpClient(httpClient);

    List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
    interceptors.add(new UserAgentInterceptor(USER_AGENT_STRING));

    // Set Connection and Read Timeout.
    this.restTemplate = new RestTemplateBuilder() //
        .setConnectTimeout(Duration.ofSeconds(5)) //
        .setReadTimeout(Duration.ofSeconds(5)) //
        .build();

    // set cooke store
    this.restTemplate.setRequestFactory(factory);
    // for user-agent (not a must for yahoo finance)
    this.restTemplate.setInterceptors(interceptors);
    this.crumbManager = new CrumbManager(this.restTemplate);
  }

  public YahooQuoteDTO getQuote(List<String> symbols)
      throws JsonProcessingException {
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    params.put("symbols", List.of(String.join(",", symbols)));
    params.put("crumb", List.of(""));
    String url = UrlManager.builder() //
        .domain(YahooFinance.DOMAIN) //
        .version(YahooFinance.VERSION_QUOTE) //
        .endpoint(YahooFinance.ENDPOINT_QUOTE) //
        .params(params) //
        .build() //
        .toUriString();
    // ! Not Thread-safe,
    // !because the BasicCookieStore will change the state in RestTemplate
    synchronized (lock) {
      // ! Clear the Cookie Store before refresh the cookie
      this.cookieStore.clear();
      String crumbKey = this.crumbManager.getCrumb();
      // System.out.println("crumb=" + crumbKey);
      url = url.concat(crumbKey);
      System.out.println("url=" + url);
      ResponseEntity<String> response = this.restTemplate.getForEntity(url, String.class);
      if (!response.getStatusCode().equals(HttpStatus.OK)) {
        YahooQuoteErrorDTO errorDto = new ObjectMapper()
            .readValue(response.getBody(), YahooQuoteErrorDTO.class);
        throw new StockQuoteYahooException(errorDto);
      }
      ObjectMapper objectMapper = new ObjectMapper();
      objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

      return objectMapper.readValue(response.getBody(),
          YahooQuoteDTO.class);
    }
  }

  private static class UserAgentInterceptor
      implements ClientHttpRequestInterceptor {
    private final String userAgent;

    public UserAgentInterceptor(String userAgent) {
      this.userAgent = userAgent;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body,
        ClientHttpRequestExecution execution) throws IOException {
      Objects.requireNonNull(request, "Request must not be null");
      Objects.requireNonNull(body, "Body must not be null");
      Objects.requireNonNull(execution, "Execution must not be null");
      request.getHeaders().set("User-Agent", userAgent);
      return execution.execute(request, body);
    }
  }

}
