package com.example.demo1.response;

public class Response {
    private boolean status;
    private String message;
    private Object data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Response (boolean status, String message){
        this.status = status;
        this.message = message;
    }
    public Response (boolean status){
        if (!status){
            this.status = false;
            this.message = "An exception occurred while executing.";
        }
        else {
            this.status = true;
            this.message = "Successfully executed.";
        }
    }
    public Response (Object data){
        this.status = true;
        this.message = "Successfully executed.";
        this.data = data;
    }
    public Response (boolean status, String message, Object data){
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
