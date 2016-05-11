package com.dawidkotarba.playground.repository;

import com.dawidkotarba.playground.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Dawid Kotarba on 17.01.2016.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUsername(String name);
}
