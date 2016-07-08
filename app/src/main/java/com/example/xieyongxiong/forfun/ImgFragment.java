package com.example.xieyongxiong.forfun;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;

import com.example.xieyongxiong.forfun.http.HttpMethod;
import com.example.xieyongxiong.forfun.info.img;
import com.example.xieyongxiong.forfun.subscribers.imgListener;
import com.example.xieyongxiong.forfun.subscribers.imgSubscriber;

public class ImgFragment extends Fragment {

    private imgListener listener;
    private WebView webView;
    private ImageButton ib_refresh;
    private StringBuilder sb;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_img, container, false);
        webView = (WebView)view.findViewById(R.id.imgWeb);
        ib_refresh = (ImageButton) view.findViewById(R.id.ib_refresh);
        sb = new StringBuilder();

        webView.loadUrl("file:///android_asset/img.html");

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);

        settings.setUseWideViewPort(true);

        //自适应屏幕
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setLoadWithOverviewMode(true);

        listener = new imgListener() {
            @Override
            public void onNext(img i) {
                for(int j=0;j<i.getResult().size();j++){
                    sb.append(i.getResult().get(j).getUrl());
                    sb.append("^^");
                    sb.append(i.getResult().get(j).getContent());
                    sb.append("^^");
                }
                Log.e("thg",sb.toString());
                webView.loadUrl("javascript:javaCallJs('"+sb.toString()+"')");
            }
        };

        ib_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sb = new StringBuilder();
                getNewImg();
            }
        });

        getNewImg();

        return view;
    }

    public void getNewImg(){
        HttpMethod.getInstance().getNewImg(new imgSubscriber(getContext(),listener));
    }


}
