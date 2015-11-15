package com.dawidkotarba.playground.service.i18n;

import com.dawidkotarba.playground.dao.UserDao;
import com.dawidkotarba.playground.integration.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Dawid Kotarba on 15.11.2015.
 */

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<UserDto> getAll() {
        return userDao.getAll();
    }

    public void add(UserDto userDto) {
        userDao.add(userDto);
    }

    public List<UserDto> getByName(String name) {
        return userDao.getByName(name);
    }
}
