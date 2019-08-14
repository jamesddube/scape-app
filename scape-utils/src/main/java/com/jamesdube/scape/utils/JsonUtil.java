package com.jamesdube.scape.utils;

import com.google.gson.GsonBuilder;

import java.util.HashMap;

public class JsonUtil {

    public static String toJson(Object o){

        return new GsonBuilder().create().toJson(o);
    }

    public static GsonBuilder gsonBuilder(){
        return new GsonBuilder();
    }

    public static <T> T toObject(HashMap hashMap,Class<T> tClass){
        return gsonBuilder().create().fromJson(toJson(hashMap),tClass);
    }
}
