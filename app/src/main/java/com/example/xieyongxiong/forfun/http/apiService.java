package com.example.xieyongxiong.forfun.http;

import com.example.xieyongxiong.forfun.info.img;
import com.example.xieyongxiong.forfun.info.joke;

import retrofit2.Response;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by xieyongxiong on 16-7-6.
 */
public interface apiService {
    @GET("joke/randJoke.php?key=9c3a63f05f53c7a02e1abc8f683e53ad")
    Observable<Response<joke>> getNewJoke();

    @GET("joke/randJoke.php?key=9c3a63f05f53c7a02e1abc8f683e53ad&type=pic")
    Observable<Response<img>> getNewImg();
}
