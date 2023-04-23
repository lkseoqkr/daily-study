package jp.co.study.mdc;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

@Slf4j
public class Log4JRunnable implements Runnable {
  private Transfer tx;
  private static Log4JTransferService log4jBusinessService = new Log4JTransferService();

  public Log4JRunnable(Transfer tx) {
    this.tx = tx;
  }

  public void run() {
    MDC.put("transaction.id", tx.getTransactionId());
    MDC.put("transaction.owner", tx.getSender());
    log4jBusinessService.transfer(tx.getAmount());
    MDC.clear();
  }

}
