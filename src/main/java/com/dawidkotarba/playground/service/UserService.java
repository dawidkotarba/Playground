package com.dawidkotarba.playground.service;

import com.dawidkotarba.playground.dao.UserDao;
import com.dawidkotarba.playground.integration.dto.UserInDto;
import com.dawidkotarba.playground.integration.dto.UserOutDto;
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

    public List<UserOutDto> getAll() {
        return userDao.getAll();
    }

    public void add(UserInDto userInDto) {
        userDao.add(userInDto);
    }

    public void delete(String name) {
        userDao.delete(name);
    }

    public List<UserOutDto> getByName(String name) {
        return userDao.getByName(name);
    }
}
