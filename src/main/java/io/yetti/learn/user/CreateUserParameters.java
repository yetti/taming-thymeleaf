package io.yetti.learn.user;

import java.time.LocalDate;

public record CreateUserParameters(UserName userName, Gender gender, LocalDate birthday, Email email, PhoneNumber phoneNumber) {}
