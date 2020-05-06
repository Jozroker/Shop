package ua.com.lviv.tc.repositories;

import ua.com.lviv.tc.entity.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}
