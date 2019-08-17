package com.jamesdube.scape.utils.api;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class ApiResponse<R> {

    protected int statusCode;

    protected String message;

    protected boolean success;

    protected HashMap<String,R> data;

    protected List<ApiSubError> errors;

}
