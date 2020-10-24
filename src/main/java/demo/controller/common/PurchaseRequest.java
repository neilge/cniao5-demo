package demo.controller.common;

import java.io.Serializable;

public class PurchaseRequest implements Serializable {
  private long courseId;
  private long accountId;

  public long getCourseId() {
    return courseId;
  }

  public void setCourseId(long courseId) {
    this.courseId = courseId;
  }

  public long getAccountId() {
    return accountId;
  }

  public void setAccountId(long accountId) {
    this.accountId = accountId;
  }

  @Override
  public String toString() {
    return "PurchaseRequest{" + "courseId=" + courseId + ", accountId=" + accountId + '}';
  }
}
