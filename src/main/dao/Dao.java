package main.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface  Dao <F, T>{


    List<T> findAll();

    Optional<T> findById(Integer id);

    boolean delete(F id);

    void update(T entity);

    T save(T entity) throws SQLException;

}