package com.codesnippet.demo.entity;

import java.time.LocalDateTime;

public class ErrorResponse {
    
    
    String message;
    String details;
    LocalDateTime timeStamp;

    public ErrorResponse(LocalDateTime timeStamp,String message, String details) {
        this.message = message;
        this.details = details;
        this.timeStamp = timeStamp;
    }

    public ErrorResponse() {
    }

    @Override
    public String toString() {
        return "ErrorResponse [message=" + message + ", details=" + details + ", timeStamp=" + timeStamp
                + ", getMessage()=" + getMessage() + ", getDetails()=" + getDetails() + ", getTimeStamp()="
                + getTimeStamp() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

}
