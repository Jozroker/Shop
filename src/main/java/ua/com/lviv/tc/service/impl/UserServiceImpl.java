package ua.com.lviv.tc.service.impl;

import ua.com.lviv.tc.entity.User;
import ua.com.lviv.tc.repositories.UserRepository;
import ua.com.lviv.tc.repositories.impl.UserRepositoryImpl;
import ua.com.lviv.tc.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository = UserRepositoryImpl.getInstance();

    private static UserServiceImpl instance;

    private UserServiceImpl() {
        this.userRepository = userRepository;
    }

    public static UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        for (char c : email.toCharArray()) {
            if (c == '@') {
                return userRepository.findByEmail(email);
            }
        }
        return Optional.empty();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
