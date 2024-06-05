package main.mapper;

import main.dto.CreateStudentDto;
import main.entity.Gender;
import main.entity.Role;
import main.entity.Student;
import main.util.LocalDateFormatter;

public class CreateStudentMapper implements Mapper<CreateStudentDto, Student> {

    private CreateStudentMapper() {
    }

    private static final CreateStudentMapper INSTANCE = new CreateStudentMapper();

    @Override
    public Student mapFrom(CreateStudentDto object) {
        Student user = new Student();
        user.setName(object.getName());
        user.setBirthday(LocalDateFormatter.format(object.getBirthday()));
        user.setEmail(object.getEmail());
        user.setPassword(object.getPassword());
        user.setGender(Gender.valueOf(object.getGender()));
        user.setRole(Role.valueOf(object.getRole()));
        return user;
    }

    public static CreateStudentMapper getInstance() {
        return INSTANCE;
    }
}
