package com.example.demo1.response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Connection.Response;

import java.util.NoSuchElementException;

public class OptionalResponse {

    private static final Gson GSON = new GsonBuilder().create();
    
    private final ResponseModel response;
    private final String rawResponse;
    
    private final int statusCode;
    private final String statusMessage;
    
    private OptionalResponse(ResponseModel response, String rawResponse, int statusCode, String statusMessage) {
        this.response = response;
        this.rawResponse = rawResponse;
        
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public ResponseModel get() {
        if(response == null)
            throw new NoSuchElementException("No value present");
        
        return response;
    }
    public boolean isPresent() {
        return response != null;
    }

    public String getRaw() {
        return rawResponse;
    }

    public int statusCode() {
        return statusCode;
    }

    public String statusMessage() {
        return statusMessage;
    }
    
    @Override
    public String toString() {
        return "OptionalResponse{"
                + "present=" + isPresent() + ", "
                + "response=" + response + ", "
                + "rawResponse=" + rawResponse + ", "
                + "statusCode=" + statusCode
                + ", statusMessage=" + statusMessage + "}";
    }
    

    public static OptionalResponse of(Response jsoupResponse) {
        int status = jsoupResponse.statusCode();
        String statusMessage = jsoupResponse.statusMessage();
        
        String body = jsoupResponse.body();
        
        if(status != 200)
            return new OptionalResponse(null, body, status, statusMessage);
        
        ResponseModel model = GSON.fromJson(body, ResponseModel.class);
        return new OptionalResponse(model, body, status, statusMessage);
    }
    
}
