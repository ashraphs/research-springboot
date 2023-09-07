package com.tcj.wealth.msdashboardaggregator.controllers;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping
public class DummyController {

    @GetMapping(value = "/service1", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getService1() {
        return new Student();
    }

    @GetMapping(value = "/service2", produces = MediaType.APPLICATION_JSON_VALUE)
    public School getService2() {
        return new School();
    }

    @Data
    public static class Student {
        private String name = "Amir";
        private Integer age = 22;
        private String schoolName = "SMK Teluk Chempedak";
    }

    @Data
    public static class School {
        private String name = "School 1";
        private Integer age = 22;
        private String address = "Pasir gudang";
    }


}
