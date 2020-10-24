package demo.model;

public class Course {
  private long id;
  private String description;
  private boolean isFree;
  private String name;
  private double price;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isFree() {
    return isFree;
  }

  public void setFree(boolean free) {
    isFree = free;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
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
        + '}';
  }
}
