package io.yetti.learn.user;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.springframework.util.Assert;

public class Email {

  private String userEmail;

  protected Email() {
  }

  public Email(String email) {
    Assert.hasText(email, "email cannot be blank");
    Assert.isTrue(email.contains("@"), "email should contain an @ symbol");
    this.userEmail = email;
  }

  public String asString() {
    return userEmail;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Email email = (Email) o;
    return Objects.equal(userEmail, email.userEmail);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(userEmail);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("userEmail", userEmail)
        .toString();
  }
}
