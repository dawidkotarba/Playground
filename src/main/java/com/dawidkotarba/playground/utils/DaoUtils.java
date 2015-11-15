package com.dawidkotarba.playground.utils;

import com.dawidkotarba.playground.exceptions.InternalErrorException;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dawid Kotarba on 15.11.2015.
 */
public class DaoUtils {

    private DaoUtils() {
        // intentionally left blank
    }

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
