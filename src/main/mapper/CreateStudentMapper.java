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
        Student student = new Student();
        student.setName(object.getName());
        student.setBirthday(LocalDateFormatter.format(object.getBirthday()));
        student.setEmail(object.getEmail());
        student.setPassword(object.getPassword());
        student.setGender(Gender.valueOf(object.getGender()));
        student.setRole(Role.valueOf(object.getRole()));
        return student;
    }



    public static CreateStudentMapper getInstance() {
        return INSTANCE;
    }
}
