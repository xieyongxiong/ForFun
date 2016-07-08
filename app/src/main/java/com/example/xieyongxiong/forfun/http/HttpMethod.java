package com.example.xieyongxiong.forfun.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xieyongxiong on 16-7-6.
 */
public class HttpMethod {
    private static final String BASE_URL = "http://v.juhe.cn/";

    private static final int TIMEOUT = 5;

    private apiService service;

    private Retrofit retrofit;

    public HttpMethod() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(TIMEOUT, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(builder.build())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(apiService.class);
    }

    private static class Singleton{
        private static final HttpMethod INSTANCE = new HttpMethod();
    }

    public static HttpMethod getInstance(){
        return Singleton.INSTANCE;
    }

    public void getNewJoke(Subscriber subscriber){
        service.getNewJoke()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getNewImg(Subscriber subscriber){
        service.getNewImg()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
