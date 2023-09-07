package com.tcj.wealth.msdashboardaggregator.utils;


/**
 * @author Amir
 */
public class MasterException extends Exception {

    public MasterException() {
        super();
    }

    public MasterException(ErrorCode errorCode, String message) {
        super(message);
    }

    public MasterException(String message) {
        super(message);
    }

    public MasterException(String message, Throwable cause) {
        super(message, cause);
    }

    public MasterException(Throwable cause) {
        super(cause);
    }
}
