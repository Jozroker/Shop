package ua.com.lviv.tc.service;

import ua.com.lviv.tc.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService extends CrudService<User, Long> {

    Optional<User> findByEmail(String email);
}
