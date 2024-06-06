package main.dao;

import main.entity.Gender;
import main.entity.Role;
import main.entity.Student;
import main.util.ConnectionManager;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;



public class StudentDao implements Dao<Integer, Student> {

    private static final StudentDao INSTANCE = new StudentDao();

    private static final String SAVE_SQL =
            "INSERT INTO students (name, birthday, email, password, role, gender)" +
                    " VALUES (?, ?, ?, ?, ?, ?)";

    private static final String FINDBYID_SQL =
    "SELECT name, birthday, email, password, role, gender FROM students WHERE id = (?)";

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
    public Student findById(Integer id) {
        Student entity = null;
        try (var connection = ConnectionManager.get();
             PreparedStatement ps = connection.prepareStatement(FINDBYID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    entity = new Student();
                    entity.setId(rs.getInt("id"));
                    entity.setName(rs.getString("name"));
                    entity.setBirthday((LocalDate) rs.getObject("birthday"));
                    entity.setEmail(rs.getString("email"));
                    entity.setPassword(rs.getString("password"));
                    entity.setGender(Gender.valueOf(rs.getString("gender")));
                    entity.setRole(Role.valueOf(rs.getString("role")));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entity;
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