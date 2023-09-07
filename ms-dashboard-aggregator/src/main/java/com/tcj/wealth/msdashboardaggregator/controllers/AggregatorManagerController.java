package com.tcj.wealth.msdashboardaggregator.controllers;

import com.tcj.wealth.msdashboardaggregator.models.Microservice;
import com.tcj.wealth.msdashboardaggregator.models.base.MasterObject;
import com.tcj.wealth.msdashboardaggregator.utils.MasterResponseObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = {"/aggregator-manager"})
public class AggregatorManagerController {
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public MasterResponseObject<Object> get() {
        return getConfigurationData();
    }

    private MasterResponseObject<Object> getConfigurationData() {
        MasterResponseObject<Object> response = new MasterResponseObject<>();
        List<Microservice> microservices = new ArrayList<>();

        Microservice service1 = new Microservice();
        service1.setId(UUID.randomUUID().toString());
        service1.setServiceSequenceOrder(1);
        service1.setName("service-1");
        service1.setMethod("GET");
        service1.setApi("http://localhost:8001/service1");
        service1.setHeader(null);
        service1.setRequestBody(null);
        microservices.add(service1);

        Microservice service2 = new Microservice();
        service2.setId(UUID.randomUUID().toString());
        service2.setServiceSequenceOrder(2);
        service2.setName("service-2");
        service2.setMethod("GET");
        service2.setApi("http://localhost:8001/service2");
        service2.setHeader(null);
        service2.setRequestBody(null);
        microservices.add(service2);

        MasterObject master = new MasterObject();
        master.setTotalService(2);
        master.setData(microservices);

        response.setT(master);

        return response;
    }

}
