package io.yetti.learn.utils;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import io.yetti.learn.user.CreateUserParameters;
import io.yetti.learn.user.Email;
import io.yetti.learn.user.Gender;
import io.yetti.learn.user.PhoneNumber;
import io.yetti.learn.user.UserName;
import io.yetti.learn.user.UserService;
import java.time.LocalDate;
import java.time.ZoneId;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("init-db")
public class DatabaseInitialiser implements CommandLineRunner {
  private final Faker faker = new Faker();

  private final UserService userService;

  public DatabaseInitialiser(UserService userService) {
    this.userService = userService;
  }

  @Override
  public void run(String... args) throws Exception {
    for (int i = 0; i < 20; i++) {
      CreateUserParameters parameters = newRandomUserParameters();
      userService.createUser(parameters);
    }
  }

  private CreateUserParameters newRandomUserParameters() {
    Name name = faker.name();
    UserName userName = new UserName(name.firstName(), name.lastName());
    Gender gender = faker.bool().bool() ? Gender.MALE : Gender.FEMALE;
    LocalDate birthday = LocalDate.ofInstant(faker.date().birthday(10, 40).toInstant(), ZoneId.systemDefault());
    Email email = new Email(faker.internet().emailAddress(generateEmailLocalPart(userName)));
    PhoneNumber phoneNumber = new PhoneNumber(faker.phoneNumber().phoneNumber());

    return new CreateUserParameters(userName, gender, birthday, email, phoneNumber);
  }

  private String generateEmailLocalPart(UserName userName) {
    return String.format("%s.%s", StringUtils.remove(userName.getFirstName().toLowerCase(), "'"), StringUtils.remove(userName.getLastName().toLowerCase(), "'"));
  }
}
