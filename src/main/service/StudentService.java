package main.service;

import main.dao.StudentDao;
import main.dto.CreateStudentDto;
import main.dto.StudentDto;
import main.entity.Group;
import main.entity.Student;
import main.mapper.CreateStudentDtoMapper;
import main.mapper.CreateStudentMapper;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;


public class StudentService {

    private static final StudentService INSTANCE = new StudentService();

    private final StudentDao studentDao = StudentDao.getInstance();
    private final CreateStudentMapper createStudentMapper = CreateStudentMapper.getInstance();
    private final CreateStudentDtoMapper createStudentDtoMapper = CreateStudentDtoMapper.getInstance();


    public Integer create(CreateStudentDto studentDto) throws SQLException {

        var studentEntity = createStudentMapper.mapFrom(studentDto);
        studentDao.save(studentEntity);
        return studentEntity.getId();
    }



    public StudentDto findStudentById(int id) throws SQLException {
        StudentDto studentDto;
        Student entity = studentDao.findById(id);
        if (entity == null)
            return null;

        studentDto = createStudentDtoMapper.mapFrom(entity);
        return studentDto;
    }



    public List<StudentDto> findAllByGroupId(Integer GroupId) throws SQLException {



        return studentDao.findAllByGroupId(GroupId).stream().
                map(createStudentDtoMapper::mapFrom).collect(Collectors.toList());
    }



    public static StudentService getInstance() {
        return INSTANCE;
    }



    private StudentService() {
    }
}