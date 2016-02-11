package com.dawidkotarba.playground.integration;

import com.dawidkotarba.playground.model.entities.Country;
import com.dawidkotarba.playground.repository.CountryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dawid Kotarba on 11.02.2016.
 */

@Service
@Slf4j
public class ReportingService {

    @Autowired
    private CountryRepository countryRepository;

    @ServiceActivator(inputChannel = "reportingServiceChannel", outputChannel = "responseChannel")
    public String generateReport(Message<String> message) {
        List<Country> byName = countryRepository.findByName(message.getPayload());
        StringBuilder result = new StringBuilder("Result:");
        byName.forEach(country -> result.append(country.getName()).append(", "));
        return result.toString();
    }

    @ServiceActivator(inputChannel = "responseChannel")
    public void soutResponse(Message<String> message) {
        System.out.println(message);
        log.info("Response message: {}", message);
    }
}
