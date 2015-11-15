package com.dawidkotarba.playground.dao;

import com.dawidkotarba.playground.exceptions.InternalErrorException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dawid Kotarba on 15.11.2015.
 */

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public abstract class AbstractDao {

    @PersistenceContext
    protected EntityManager entityManager;

    public static <A, B> List<B> copyProperties(List<A> source, Class<B> targetClass) {
        List<B> result = new ArrayList<>();

        source.forEach(entity -> {
            B dto = null;

            try {
                dto = targetClass.newInstance();
            } catch (Exception e) {
                throw new InternalErrorException("Cannot create instance of " + targetClass);
            }

            BeanUtils.copyProperties(entity, dto);
            result.add(dto);
        });

        return result;
    }
}
