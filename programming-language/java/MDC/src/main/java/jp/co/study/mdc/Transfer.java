package jp.co.study.mdc;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transfer {
  private String transactionId;
  private String sender;
  private Long amount;

}
