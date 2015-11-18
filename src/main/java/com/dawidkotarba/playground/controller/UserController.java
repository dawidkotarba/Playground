package com.dawidkotarba.playground.controller;

import com.dawidkotarba.playground.integration.dto.UserInDto;
import com.dawidkotarba.playground.integration.dto.UserOutDto;
import com.dawidkotarba.playground.service.i18n.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Dawid Kotarba on 15.11.2015.
 */

@RestController
public class UserController {

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    private UserService userService;

    @RequestMapping(value = "/users/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserOutDto> getAll() {
        return userService.getAll();
    }

    @RequestMapping(value = "/users/name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserOutDto> getByName(@PathVariable String name) {
        return userService.getByName(name);
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void add(@RequestBody UserInDto userInDto) {
        userService.add(userInDto);
    }
}
