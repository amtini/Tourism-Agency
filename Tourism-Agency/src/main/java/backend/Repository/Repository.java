package backend.Repository;

import java.util.List;

public interface Repository<T> {

    T create(T t);

    void delete(T t);

    T find(T t);

    T getById(Long id);

    List<T> search(String value);

    T update(T t);

    Iterable<T> findAll();
}