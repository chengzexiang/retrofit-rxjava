package com.bwei.czx.czx1102study2;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by czx on 2017/11/2.
 */
//Service中又封装的类
public class BaseService {
    private Retrofit mRetrofit;
    public BaseService(){
        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://169.254.181.49:8080/WebSample/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();
    }
    public Retrofit getmRetrofit(){
        return mRetrofit;
    }

}
