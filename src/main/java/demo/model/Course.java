package demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Course implements Serializable {
  private Long id;
  private String description;
  private Boolean isFree;
  private String name;
  private Double price;
  private Boolean isPurchased;

  private List<Lesson> lessons;

  public List<Lesson> getLessons() {
    return lessons;
  }

  public void setLessons(List<Lesson> lessons) {
    this.lessons = lessons;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Boolean isFree() {
    return isFree;
  }

  public void setFree(Boolean free) {
    isFree = free;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Boolean isPurchased() {
    return isPurchased;
  }

  public void setPurchased(Boolean purchased) {
    isPurchased = purchased;
  }

  @Override
  public String toString() {
    return "Course{"
        + "id="
        + id
        + ", description='"
        + description
        + '\''
        + ", isFree="
        + isFree
        + ", name='"
        + name
        + '\''
        + ", price="
        + price
        + ", isPurchased="
        + isPurchased
        + ", lessons="
        + lessons
        + '}';
  }
}
