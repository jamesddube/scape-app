package com.jamesdube.scape.utils.api;

import java.util.HashMap;

public class ApiResponseBuilder<R> {

    private int statusCode;

    private String message;

    private HashMap<String,R> data = new HashMap<>();

    private boolean success;

    public static ApiResponseBuilder newApiResponseBuilder(){
        return new ApiResponseBuilder();
    }

    public ApiResponseBuilder<R> success(boolean success){
        this.success = success;
        return this;
    }

    public ApiResponseBuilder<R> statusCode(int statusCode){
        this.statusCode = statusCode;
        return this;
    }

    public ApiResponseBuilder<R> message(String message){
        this.message = message;
        return this;
    }

    public ApiResponseBuilder<R> data(String key, R value){
        this.data.put(key,value);
        return this;
    }

    public ApiResponse build(){
        ApiResponse<R> apiResponse = new ApiResponse<>();
        apiResponse.setStatusCode(statusCode);
        apiResponse.setSuccess(success);
        apiResponse.setMessage(message);
        apiResponse.setData(data);
        return apiResponse;
    }

}
