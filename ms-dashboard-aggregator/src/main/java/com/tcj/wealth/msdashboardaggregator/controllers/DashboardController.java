package com.tcj.wealth.msdashboardaggregator.controllers;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcj.wealth.msdashboardaggregator.clients.AggregatorManagerClient;
import com.tcj.wealth.msdashboardaggregator.models.Microservice;
import com.tcj.wealth.msdashboardaggregator.models.base.MasterObject;
import com.tcj.wealth.msdashboardaggregator.utils.MasterResponseObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping(value = {"/dashboard"})
public class DashboardController {

    @Autowired
    private AggregatorManagerClient managerClient;
    @Autowired
    private ObjectMapper objectMapper;


    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Object> get() throws RuntimeException {
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        MasterResponseObject<Object> managerClientResponse = managerClient.getManagerAggregator();
        MasterObject masterObject = objectMapper.convertValue(managerClientResponse.getT(), MasterObject.class);
        Microservice[] microserviceList = objectMapper.convertValue(masterObject.getData(), Microservice[].class);

        return getDashboardData(microserviceList);
    }

    private Flux<Object> getDashboardData(Microservice[] microserviceList) {
        RestTemplate restTemplate = new RestTemplate();

        return Flux.create(emitter -> {
            CompletableFuture<List<String>> future = CompletableFuture.supplyAsync(() -> {
                List<String> objectsResponse = new ArrayList<>();
                int count = 0;
                for (Microservice svc : microserviceList) {
                    // Mapping the HTTP method
                    HttpMethod method = null;
                    if (svc.getMethod().equals(HttpMethod.GET.name())) {
                        method = HttpMethod.GET;
                    }

                    // Remove this if not use, to test the behaviour by using thread sleep
                    count++;
                    if (count == 2) {
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    // Call API using rest template
                    ResponseEntity<String> response = restTemplate.exchange(svc.getApi(), method, null, String.class);
                    log.info("Response: {}", response.getBody());

                    objectsResponse.add(response.getBody());
                }
                return objectsResponse;
            });
            future.whenComplete((objectList, exception) -> {
                log.info("Object list: {}", objectList);
                if (exception == null) {
                    objectList.forEach(emitter::next);
                    emitter.complete();
                } else {
                    emitter.complete();
                }
            });
        });
    }

    @GetMapping(path = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Object> getEventStream() {
        return Flux.create(emitter -> emitter.next("hi").next("hi2"));
    }

}
