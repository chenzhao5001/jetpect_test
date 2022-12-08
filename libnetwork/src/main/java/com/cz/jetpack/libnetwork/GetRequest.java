package com.cz.jetpack.libnetwork;

public class GetRequest<T> extends Request<T, GetRequest> {

    public GetRequest(String url) {
        super(url);
    }

    @Override
    protected okhttp3.Request generateRequest(okhttp3.Request.Builder builder) {
        return null;
    }
}
