package com.dawidkotarba.playground.dao;

import com.dawidkotarba.playground.integration.dto.UserInDto;
import com.dawidkotarba.playground.integration.dto.UserOutDto;
import com.dawidkotarba.playground.model.entities.User;
import com.google.common.base.Preconditions;
import com.mysema.query.jpa.impl.JPAQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.dawidkotarba.playground.model.entities.QUser.user;

/**
 * Created by Dawid Kotarba on 15.11.2015.
 */

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class UserDao extends AbstractDao {

    public List<UserOutDto> getAll() {
        List<User> users = new JPAQuery(entityManager).from(user).fetchAll().list(user);
        return copyProperties(users, UserOutDto.class);
    }

    public List<UserOutDto> getByName(String name) {
        Preconditions.checkArgument(StringUtils.isNotBlank(name), "Name cannot be blank");

        List<User> result = new JPAQuery(entityManager).from(user).where(user.username.containsIgnoreCase(name)).list(user);
        return copyProperties(result, UserOutDto.class);
    }

    public void add(UserInDto userInDto) {
        Preconditions.checkNotNull(userInDto, "userInDto cannot be null");

        User user = new User();
        BeanUtils.copyProperties(userInDto, user);
        entityManager.persist(user);
    }

}
