package main.service;

import main.dao.GroupDao;
import main.dto.GroupDto;

import java.util.List;
import java.util.stream.Collectors;

public class GroupService {

    private static final GroupService INSTANCE = new GroupService();

    private final GroupDao groupDao = GroupDao.getInstance();

    public List<GroupDto> findAllGroups() {
        return groupDao.findAll().stream().
                map(group -> new GroupDto(
                      group.getId(),
                      group.getNumber()
                )).collect(Collectors.toList());
    }

    public static GroupService getInstance(){
        return INSTANCE;
    }

    private GroupService() {}
}
