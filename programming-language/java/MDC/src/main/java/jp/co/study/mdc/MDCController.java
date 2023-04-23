package jp.co.study.mdc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MDCController {

  @GetMapping("mdc")
  public String mdc() throws InterruptedException {
    var demo = new TransferDemo();

    demo.test();

    Thread.sleep(10000L);

    return "mdc";
  }
}
