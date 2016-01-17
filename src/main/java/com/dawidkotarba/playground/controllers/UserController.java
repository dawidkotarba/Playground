package com.dawidkotarba.playground.controllers;

import com.dawidkotarba.playground.integration.dto.UserInDto;
import com.dawidkotarba.playground.integration.dto.UserOutDto;
import com.dawidkotarba.playground.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by Dawid Kotarba on 15.11.2015.
 */

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Resource<UserOutDto>> getAll() {
        List<Resource<UserOutDto>> result = new ArrayList<>();

        for (UserOutDto dto : userService.getAll()) {
            Resource resource = new Resource(dto);
            resource.add(linkTo(methodOn(UserController.class).getByName(dto.getUsername())).withSelfRel());
            result.add(resource);
        }

        return result;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Resource<UserOutDto>> getByName(@PathVariable String name) {

        List<Resource<UserOutDto>> result = new ArrayList<>();

        for (UserOutDto dto : userService.getByName(name)) {
            Resource resource = new Resource(dto);
            resource.add(linkTo(methodOn(UserController.class).getByName(dto.getUsername())).withSelfRel());
            result.add(resource);
        }

        return result;
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void add(@RequestBody @Valid UserInDto userInDto) {
        userService.add(userInDto);
    }
}
