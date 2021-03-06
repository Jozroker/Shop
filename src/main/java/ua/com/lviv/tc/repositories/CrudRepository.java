package ua.com.lviv.tc.repositories;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, E> {

    T save(T t);

    void update(T t);

    List<T> findAll();

    Optional<T> findById(E e);

    void deleteById(E e);
}
