package com.example.xieyongxiong.forfun.subscribers;

import android.content.Context;

import com.example.xieyongxiong.forfun.info.joke;

import retrofit2.Response;
import rx.Subscriber;

/**
 * Created by xieyongxiong on 16-7-6.
 */
public class jokeSubscriber extends Subscriber<Response<joke>> {

    private Context context;
    private jokeListener listener;

    public jokeSubscriber(Context context,jokeListener listener){
        this.context = context;
        this.listener = listener;
    }
    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(Response<joke> jokeResponse) {

        joke j = jokeResponse.body();
        listener.onNext(j);
    }
}
