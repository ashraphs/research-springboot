package com.tcj.wealth.msdashboardaggregator.models.base;

import lombok.Data;

import java.util.Date;

@Data
public class MasterObject {
    private String id;
    private Boolean deleted = false;
    private Boolean active = true;
    private Integer version = 0;
    private Boolean restricted = false;
    private Date createdDate;
    private String createdBy;
    private Date lastModifiedDate;
    private String lastModifiedBy;
    private Integer totalService;
    private Object data;
}
