package demo.controller.common;

import demo.model.Account;

import java.io.Serializable;

public class VerificationRequest implements Serializable {

  private String verificationCode;
  private Account account;

  public String getVerificationCode() {
    return verificationCode;
  }

  public void setVerificationCode(String verificationCode) {
    this.verificationCode = verificationCode;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  @Override
  public String toString() {
    return "VerificationRequest{"
        + "verificationCode='"
        + verificationCode
        + '\''
        + ", account="
        + account
        + '}';
  }
}
