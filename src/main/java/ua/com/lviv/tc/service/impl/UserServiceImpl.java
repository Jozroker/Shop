//package ua.com.lviv.tc.service.impl;
//
//import org.apache.log4j.Logger;
//import ua.com.lviv.tc.entity.User;
//import ua.com.lviv.tc.repositories.UserRepository;
//import ua.com.lviv.tc.repositories.impl.UserRepositoryImpl;
//import ua.com.lviv.tc.service.UserService;
//
//import java.util.List;
//import java.util.Optional;
//
//public class UserServiceImpl implements UserService {
//
//    private static Logger log = Logger.getLogger(UserServiceImpl.class);
//
//    private UserRepository userRepository = UserRepositoryImpl.getInstance();
//
//    private static UserServiceImpl instance;
//
//    private UserServiceImpl() {
//        this.userRepository = userRepository;
//    }
//
//    public static UserServiceImpl getInstance() {
//        if (instance == null) {
//            instance = new UserServiceImpl();
//        }
//        return instance;
//    }
//
//    @Override
//    public Optional<User> findByEmail(String email) {
//        log.debug("find user by email " + email);
//        for (char c : email.toCharArray()) {
//            if (c == '@') {
//                return userRepository.findByEmail(email);
//            }
//        }
//        log.error("text " + email + " is not email");
//        return Optional.empty();
//    }
//
//    @Override
//    public void save(User user) {
//        log.debug("save user " + user.toString());
//        userRepository.save(user);
//    }
//
//    @Override
//    public void update(User user) {
//        log.debug("update user " + user.toString());
//        userRepository.update(user);
//    }
//
//    @Override
//    public List<User> findAll() {
//        log.debug("find all users");
//        return userRepository.findAll();
//    }
//
//    @Override
//    public Optional<User> findById(Integer id) {
//        log.debug("find user by id " + id);
//        return userRepository.findById(id);
//    }
//
//    @Override
//    public void deleteById(Integer id) {
//        log.debug("delete user by id " + id);
//        userRepository.deleteById(id);
//    }
//}
