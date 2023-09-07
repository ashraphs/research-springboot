package com.tcj.wealth.msdashboardaggregator.utils;

/**
 * Created by Amir on 12/4/2019 2:01 PM
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MasterResponseObject<T> {

    private String error;
    private Integer status;
    private String message;
    private Date timestamp;
    private T t;

    public MasterResponseObject(HttpStatus httpStatus, String message, T t) {
        super();
        this.error = httpStatus.getReasonPhrase();
        this.status = httpStatus.value();
        this.message = message;
        this.timestamp = new Date();
        this.t = t;
    }

    public MasterResponseObject(HttpStatus httpStatus, String message) {
        super();
        this.status = httpStatus.value();
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp != null ? (Date) timestamp.clone() : null;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp != null ? (Date) timestamp.clone() : null;
    }

}
