package com.app.infideap.httprequest;

import android.content.Context;

import okhttp3.OkHttpClient;

/**
 * Created by Shiburagi on 20/10/2016.
 */

public class Atom {
    public static final String PUT_METHOD = "PUT";
    public static final String GET_METHOD = "GET";
    public static final String POST_METHOD = "POST";
    public static final String DELETE_METHOD = "DELETE";
    public static boolean LOG_BODY = false;

    public static A with(Context context) {
        A a = new A(context);
        return a;
    }

    public static OkHttpClient client() {
        return A.globalClient;
    }


}