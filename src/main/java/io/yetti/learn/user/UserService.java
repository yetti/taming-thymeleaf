package io.yetti.learn.user;

import com.google.common.collect.ImmutableSet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

  User createUser(CreateUserParameters createUserParameters);

  Page<User> getUsers(Pageable pageable);
}
