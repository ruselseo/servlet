package main.dao;

import main.entity.Student;
import main.util.ConnectionManager;


import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;



public class StudentDao implements Dao<Integer, Student> {

    private static final StudentDao INSTANCE = new StudentDao();

    private static final String SAVE_SQL =
            "INSERT INTO users (name, birthday, email, password, role, gender)" +
                    " VALUES (?, ?, ?, ?, ?, ?)";

    @Override
    public Student save(Student entity) throws SQLException {
        var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(SAVE_SQL, RETURN_GENERATED_KEYS); {
            preparedStatement.setObject(1, entity.getName());
            preparedStatement.setObject(2, entity.getBirthday());
            preparedStatement.setObject(3, entity.getEmail());
            preparedStatement.setObject(4, entity.getPassword());
            preparedStatement.setObject(5, entity.getRole().name());
            preparedStatement.setObject(6, entity.getGender().name());

            preparedStatement.executeUpdate();

            var generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setId(generatedKeys.getObject("id", Integer.class));

            return entity;
        }
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Optional<Student> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(Student entity) {

    }

    public static StudentDao getInstance() {
        return INSTANCE;
    }

    private StudentDao() {
    }

//User
}