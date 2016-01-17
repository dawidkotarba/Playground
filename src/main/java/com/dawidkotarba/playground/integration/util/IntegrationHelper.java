package com.dawidkotarba.playground.integration.util;

import com.dawidkotarba.playground.exceptions.InternalErrorException;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dawid Kotarba on 17.01.2016.
 */
public class IntegrationHelper {
    private IntegrationHelper() {
        // intentionally left blank
    }

    public static <A, B> List<B> copyProperties(List<A> source, Class<B> targetClass) {
        List<B> result = new ArrayList<>();

        source.forEach(entity -> {
                B dto = null;

                try {
                    dto = targetClass.newInstance();
                } catch (Exception e) {
                    throw new InternalErrorException("Cannot create instance of " + targetClass, e);
                }

                BeanUtils.copyProperties(entity, dto);
                result.add(dto);
            });

        return result;
    }
}
