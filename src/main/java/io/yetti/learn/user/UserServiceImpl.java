package io.yetti.learn.user;

import com.google.common.collect.ImmutableSet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

  private final UserRepository repository;

  public UserServiceImpl(UserRepository repository) {
    this.repository = repository;
  }

  @Override
  public User createUser(CreateUserParameters createUserParameters) {
    UserId userId = repository.nextId();
    User user = new User(userId,
                         createUserParameters.userName(),
                         createUserParameters.gender(),
                         createUserParameters.birthday(),
                         createUserParameters.email(),
                         createUserParameters.phoneNumber());
    return repository.save(user);
  }

  @Override
  public Page<User> getUsers(Pageable pageable) {
    return repository.findAll(pageable);
  }
}
