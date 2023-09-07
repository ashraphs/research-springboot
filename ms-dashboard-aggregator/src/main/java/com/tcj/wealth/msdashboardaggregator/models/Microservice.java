package com.tcj.wealth.msdashboardaggregator.models;

import lombok.Data;

@Data
public class Microservice {
    private String id;
    private Boolean deleted = false;
    private Boolean active = true;
    private Boolean restricted = false;
    private Integer serviceSequenceOrder;
    private Boolean concurrent = true;
    private String method;
    private String name;
    private String api;
    private String header;
    private String requestBody;
}
