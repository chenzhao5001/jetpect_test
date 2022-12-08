package com.cz.jetpack.libnetwork;

import android.support.annotation.IntDef;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;


public abstract class Request<T,R extends Request> {
    private String mUrl;
    protected HashMap<String,String> headers = new HashMap<>();
    protected HashMap<String,Object> params = new HashMap<>();

    // 进访问本地
    public static final int CACHE_ONLY = 1;
    // 访问本地请求的同时发起网络请求
    public static final int CACHE_FIRST = 2;
    //仅访问网络
    public static final int NET_ONLY = 3;
    // 先网络网络，成功后缓存到本地
    public static final int NET_CACHE = 4;
    private String cacheKey;

    @IntDef({CACHE_ONLY,CACHE_FIRST,NET_ONLY,NET_CACHE})
    public @interface CacheStrategy {

    }
    public Request(String url) {
        this.mUrl = url;
    }

    public R addHeader(String key,String value) {
        headers.put(key,value);
        return (R) this;
    }

    public R addParam(String key,Object value) {
        try {
            Field field = value.getClass().getField("TYPE");
            Class claz = (Class)field.get(null);
            if(claz.isPrimitive()) {
                params.put(key,value);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (R) this;
    }

    public R cacheKey(String key) {
        this.cacheKey = key;
        return (R) this;
    }

    public void execute(JsonCallback<T> callback) {
        getCall();

    }

    private Call getCall() {
        okhttp3.Request.Builder builder = new okhttp3.Request.Builder();
        addHeaders(builder);
        okhttp3.Request request = generateRequest(builder);
        Call call = ApiService.okHttpClient.newCall(request);
        return call;
    }

    protected abstract okhttp3.Request generateRequest(okhttp3.Request.Builder builder);


    private void addHeaders(okhttp3.Request.Builder builder) {
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            builder.addHeader(entry.getKey(),entry.getValue());
        }
    }


}
