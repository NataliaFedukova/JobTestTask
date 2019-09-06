package com.fedukova.testtask.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static       NetworkService mInstance;
    private static final String         URL_MAIN = "http://kot3.com/xim/";
    private              Retrofit       mRetrofit;

    private NetworkService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(URL_MAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkService getNetworkInstance() {
        if (mInstance == null) {
            mInstance = new NetworkService();
        }
        return mInstance;
    }

    public GetData getData(){
        return mRetrofit.create(GetData.class);
    }
}
