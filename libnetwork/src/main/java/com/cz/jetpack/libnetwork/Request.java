package com.cz.jetpack.libnetwork;

import java.util.HashMap;

public abstract class Request<T,R> {
    private String mUrl;
    protected HashMap<String,String> headers = new HashMap<>();
    protected HashMap<String,Object> params = new HashMap<>();

    public static final int CACHE_ONLY = 1;
    public static final int CACHE_FIRST = 2;
    public static final int NET_ONLY = 3;
    public Request(String url) {
        this.mUrl = url;
    }

}
