package bootcamp.com.bc_yahoo_finance.infra.yahoo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import bootcamp.com.bc_yahoo_finance.model.TStockDTO;

@Service
public class YHRestClient {

  @Autowired
  private RedisTemplate<String, String> redisTemplate;


  // Method to get stock quotes for a list of symbols
  public HttpResponse<String> getQuote(String symbol) throws IOException, InterruptedException {

    String cookie = redisTemplate.opsForValue().get("cookieAndCrumb").split(",")[0];
    String crumb = redisTemplate.opsForValue().get("cookieAndCrumb").split(",")[1];

    String url = String.format("https://query1.finance.yahoo.com/v7/finance/quote?symbols=%s&crumb=%s",
        symbol, crumb);

    // Create HTTP client
    HttpClient client = HttpClient.newBuilder()
        .followRedirects(HttpClient.Redirect.ALWAYS)
        .build();

    // Build HTTP request
    HttpRequest request = HttpRequest.newBuilder()//
        .uri(URI.create(url))
        .header("User-Agent", "Mozilla/5.0")
        .header("Accept", "*/*")
        .header("Cookie", cookie)
        .GET()
        .build();

    HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

    // Return the parsed TStockDTO object
    return httpResponse;
  }

  public List<String> fetchStockListResponse(List<String> symbols) {
    List<String> result = new ArrayList<>();
    symbols.forEach(symbol -> {
      String data;
      try {
        data = this.getQuote(symbol).body();
        result.add(data);
      } catch (IOException | InterruptedException e) {
        e.printStackTrace();
      }
    });

    return result;

  }
}
// https://query1.finance.yahoo.com/v7/finance/quote?symbols=0388.HK,0700.HK,0005.HK&crumb=9qPTsGjz0O.
// https://query1.finance.yahoo.com/v7/finance/quote?symbols=0388.HK&crumb=9qPTsGjz0O.