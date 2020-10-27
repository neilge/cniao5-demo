package demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Lesson implements Serializable {
  private long id;
  private String name;
  private boolean isFree;
  private Long duration;
  private String key;

  private Course course;

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

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

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
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
        + ", key='"
        + key
        + '\''
        + '}';
  }
}
