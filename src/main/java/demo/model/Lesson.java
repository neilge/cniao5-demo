package demo.model;

public class Lesson {
  private long id;
  private String name;
  private boolean isFree;
  private Long duration;
  private String url;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isFree() {
    return isFree;
  }

  public void setFree(boolean free) {
    isFree = free;
  }

  public Long getDuration() {
    return duration;
  }

  public void setDuration(Long duration) {
    this.duration = duration;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @Override
  public String toString() {
    return "Lesson{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", isFree="
        + isFree
        + ", duration="
        + duration
        + ", url='"
        + url
        + '\''
        + '}';
  }
}
