package io.yetti.learn.user;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.springframework.util.Assert;

public class PhoneNumber {

  private String userPhoneNumber;

  protected PhoneNumber() {
  }

  public PhoneNumber(String phoneNumber) {
    Assert.hasText(phoneNumber, "phoneNumber cannot be blank");
    this.userPhoneNumber = phoneNumber;
  }

  public String asString() {
    return this.userPhoneNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PhoneNumber that = (PhoneNumber) o;
    return Objects.equal(userPhoneNumber, that.userPhoneNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(userPhoneNumber);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("userPhoneNumber", userPhoneNumber)
        .toString();
  }
}
