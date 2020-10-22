package demo.model;

import java.io.Serializable;

/**
 * @author Neo
 * @since 10/17/2020-7:33 PM
 */
public class Account implements Serializable {

  private long id;
  private String email;
  private String username;
  private String password;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "Account{"
        + "id="
        + id
        + ", email='"
        + email
        + '\''
        + ", userName='"
        + username
        + '\''
        + ", password='"
        + password
        + '\''
        + '}';
  }
}
