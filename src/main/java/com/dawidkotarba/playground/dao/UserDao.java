package com.dawidkotarba.playground.dao;

import com.dawidkotarba.playground.annotations.TransactionalRepository;
import com.dawidkotarba.playground.exceptions.NotFoundException;
import com.dawidkotarba.playground.integration.assembler.UserAssembler;
import com.dawidkotarba.playground.integration.dto.UserInDto;
import com.dawidkotarba.playground.integration.dto.UserOutDto;
import com.dawidkotarba.playground.model.entities.User;
import com.dawidkotarba.playground.repository.UserRepository;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Dawid Kotarba on 15.11.2015.
 */

@TransactionalRepository
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Resource
    private UserRepository userRepository;

    @Autowired
    private UserAssembler userAssembler;

    public List<UserOutDto> getAll() {
        return userRepository.findAll().stream().map(userAssembler.convert()).collect(Collectors.toList());
    }

    public List<UserOutDto> getByName(String name) {
        Preconditions.checkArgument(StringUtils.isNotBlank(name), "Name cannot be blank");
        return userRepository.findByUsername(name).stream().map(userAssembler.convert()).collect(Collectors.toList());
    }

    public void add(UserInDto userInDto) {
        Preconditions.checkNotNull(userInDto, "userInDto cannot be null");

        User user = new User();
        BeanUtils.copyProperties(userInDto, user);
        entityManager.persist(user);
    }

    public void delete(String name) {
        Preconditions.checkArgument(StringUtils.isNotBlank(name), "Name cannot be blank");
        List<User> result = userRepository.findByUsername(name);

        if (result.isEmpty()) {
            throw new NotFoundException("Cannot find a country with name " + name);
        }

        User country = result.get(0);
        entityManager.remove(country);
    }

}
