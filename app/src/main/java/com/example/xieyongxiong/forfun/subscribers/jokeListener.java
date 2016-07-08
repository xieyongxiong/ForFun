package com.example.xieyongxiong.forfun.subscribers;

import com.example.xieyongxiong.forfun.info.joke;

/**
 * Created by xieyongxiong on 16-7-6.
 */
public interface jokeListener {
    void onNext(joke j);
}
