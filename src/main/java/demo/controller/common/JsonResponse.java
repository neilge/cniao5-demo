package demo.controller.common;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonResponse implements Serializable {
  private long code;
  private String message;
  private Object data;

  private JsonResponse() {}

  public long getCode() {
    return code;
  }

  public void setCode(long code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private long code;
    private String message;
    private Object data;

    private Builder() {}

    public Builder setCode(long code) {
      this.code = code;
      return this;
    }

    public Builder setMessage(String message) {
      this.message = message;
      return this;
    }

    public Builder setData(Object data) {
      this.data = data;
      return this;
    }

    public JsonResponse build() {
      JsonResponse jsonResponse = new JsonResponse();
      jsonResponse.setCode(code);
      jsonResponse.setMessage(message);
      jsonResponse.setData(data);
      return jsonResponse;
    }
  }
}
