package main.service;

import main.dao.StudentDao;
import main.dto.CreateStudentDto;
import main.mapper.CreateStudentMapper;

import java.sql.SQLException;


public class StusentService {

    private static final StusentService INSTANCE = new StusentService();

    private final StudentDao studentDao = StudentDao.getInstance();
    private final CreateStudentMapper createStudentMapper = CreateStudentMapper.getInstance();

    public Integer create(CreateStudentDto userDto) throws SQLException {

        var userEntity = createStudentMapper.mapFrom(userDto);
        studentDao.save(userEntity);
        return userEntity.getId();
    }

    public static StusentService getInstance() {
        return INSTANCE;
    }

    private StusentService() {
    }
}