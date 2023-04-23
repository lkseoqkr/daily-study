package jp.co.study.gsconsumingrest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyController {

  private final RestTemplate restTemplate;
  public MyController(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @GetMapping("/api/random")
  public Quote Random() {
    return restTemplate.getForObject("http://localhost:8080/api/random", Quote.class);
  }

  @GetMapping("/api/1")
  public Quote one() {
    return restTemplate.getForObject("http://localhost:8080/api", Quote.class);
  }

  @GetMapping("/api")
  public Quote api() {
    return restTemplate.getForObject("http://localhost:8080/api/1", Quote.class);
  }
}
