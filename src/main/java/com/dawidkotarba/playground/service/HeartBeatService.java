package com.dawidkotarba.playground.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by Dawid Kotarba on 16.01.2016.
 */

@Service
public class HeartBeatService {

    @PersistenceContext
    private EntityManager entityManager;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Scheduled(fixedDelay = 60000)
    public void doHeartBeat() {
        Query heartBeatQuery = entityManager.createNativeQuery("SELECT 1 FROM DUAL");
        logger.info("Heartbeat result : " + heartBeatQuery.getSingleResult());
    }

}
