package demo.controller.common;

import java.io.Serializable;

public class PurchaseRequest implements Serializable {
  private Long courseId;
  private Long accountId;

  public Long getCourseId() {
    return courseId;
  }

  public void setCourseId(Long courseId) {
    this.courseId = courseId;
  }

  public Long getAccountId() {
    return accountId;
  }

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  @Override
  public String toString() {
    return "PurchaseRequest{" + "courseId=" + courseId + ", accountId=" + accountId + '}';
  }
}
