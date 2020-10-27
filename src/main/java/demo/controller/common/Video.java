package demo.controller.common;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Video implements Serializable {
  private String key;
  private String title;
  private String url;

  private Video() {}

  public String getKey() {
    return key;
  }

  public String getTitle() {
    return title;
  }

  public String getUrl() {
    return url;
  }

  private void setKey(String key) {
    this.key = key;
  }

  private void setTitle(String title) {
    this.title = title;
  }

  private void setUrl(String url) {
    this.url = url;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String key;
    private String title;
    private String url;

    private Builder() {}

    public Builder setKey(String key) {
      this.key = key;
      return this;
    }

    public Builder setTitle(String title) {
      this.title = title;
      return this;
    }

    public Builder setUrl(String url) {
      this.url = url;
      return this;
    }

    public Video build() {
      Video video = new Video();
      video.setKey(key);
      video.setTitle(title);
      video.setUrl(url);
      return video;
    }
  }

  @Override
  public String toString() {
    return "Video{"
        + "key='"
        + key
        + '\''
        + ", title='"
        + title
        + '\''
        + ", url='"
        + url
        + '\''
        + '}';
  }
}
