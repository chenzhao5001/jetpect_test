package com.cz.jetpack.libnetwork;

import java.util.Map;

public class UrlCreator {
    public static String createUrlFromParams(String url, Map<String,Object> params) {
        StringBuilder builder = new StringBuilder();
        builder.append(url);
        if(url.indexOf("?") > 0 || url.indexOf("&") > 0) {
            builder.append("&");
        } else {
            builder.append("?");
        }
        for (Map.Entry<String, Object> entry : params.entrySet()) {

        }
        return "";
    }
}
