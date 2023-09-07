package com.tcj.wealth.msdashboardaggregator.clients;

import com.tcj.wealth.msdashboardaggregator.utils.MasterResponseObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "AggregatorManager", url = "http://localhost:8001/aggregator-manager")
public interface AggregatorManagerClient {
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    MasterResponseObject<Object> getManagerAggregator();

}
