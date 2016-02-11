package com.dawidkotarba.playground.integration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * Created by Dawid Kotarba on 11.02.2016.
 */
@Component
@Slf4j
public class ReportRequestBuilder {

    @Transformer(inputChannel = "requestChannel", outputChannel = "reportingServiceChannel")
    public String createRequestMessage(Message<String> message) {
        log.info("Received message: {}", message);
        return message.getPayload();
    }
}
