package com.dawidkotarba.playground.controllers;

import com.dawidkotarba.playground.integration.dto.UserInDto;
import com.dawidkotarba.playground.integration.dto.UserOutDto;
import com.dawidkotarba.playground.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Dawid Kotarba on 15.11.2015.
 */

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserOutDto> getAll() {
        return userService.getAll();
    }

    @RequestMapping(value = "/users/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserOutDto> getByName(@PathVariable String name) {
        return userService.getByName(name);
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void add(@RequestBody @Valid UserInDto userInDto) {
        userService.add(userInDto);
    }
}
