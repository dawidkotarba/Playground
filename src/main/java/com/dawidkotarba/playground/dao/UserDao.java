package com.dawidkotarba.playground.dao;

import com.dawidkotarba.playground.exceptions.NotFoundException;
import com.dawidkotarba.playground.integration.dto.UserInDto;
import com.dawidkotarba.playground.integration.dto.UserOutDto;
import com.dawidkotarba.playground.integration.util.IntegrationHelper;
import com.dawidkotarba.playground.model.entities.User;
import com.dawidkotarba.playground.repository.UserRepository;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Dawid Kotarba on 15.11.2015.
 */

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Resource
    private UserRepository userRepository;

    public List<UserOutDto> getAll() {
        List<User> users = (List<User>) userRepository.findAll();
        return IntegrationHelper.copyProperties(users, UserOutDto.class);
    }

    public List<UserOutDto> getByName(String name) {
        Preconditions.checkArgument(StringUtils.isNotBlank(name), "Name cannot be blank");
        List<User> result = userRepository.findByUsername(name);
        return IntegrationHelper.copyProperties(result, UserOutDto.class);
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
