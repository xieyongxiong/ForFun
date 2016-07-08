package com.example.xieyongxiong.forfun.subscribers;

import android.content.Context;

import com.example.xieyongxiong.forfun.info.img;

import retrofit2.Response;
import rx.Subscriber;

/**
 * Created by xieyongxiong on 16-7-6.
 */
public class imgSubscriber extends Subscriber<Response<img>>{

    private Context context;
    private imgListener listener;

    public imgSubscriber(Context context,imgListener listener){
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
    public void onNext(Response<img> imgResponse) {

        img i = imgResponse.body();
        listener.onNext(i);
    }
}
