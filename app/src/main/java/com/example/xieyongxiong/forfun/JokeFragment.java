package com.example.xieyongxiong.forfun;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.xieyongxiong.forfun.db.jokeDao;
import com.example.xieyongxiong.forfun.http.HttpMethod;
import com.example.xieyongxiong.forfun.info.joke;
import com.example.xieyongxiong.forfun.subscribers.jokeListener;
import com.example.xieyongxiong.forfun.subscribers.jokeSubscriber;


public class JokeFragment extends Fragment {

    private Button button;
    private WebView webView;
    private jokeListener listener;
    private StringBuilder sb;
    private ImageButton ib_refresh;
    private jokeDao dao;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_joke, container, false);
        webView =(WebView) view.findViewById(R.id.jokeWeb);
        ib_refresh = (ImageButton) view.findViewById(R.id.ib_refresh);

        dao = new jokeDao(getContext());

        sb = new StringBuilder();

        webView.loadUrl("file:///android_asset/joke.html");
        webView.addJavascriptInterface(new JokeInterface(),"Android");
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);


        listener = new jokeListener() {
            @Override
            public void onNext(joke j) {

                for(int i=0;i<j.getResult().size();i++){
                    sb.append(j.getResult().get(i).getContent());
                    sb.append("^^");
                }
                webView.loadUrl("javascript:javaCallJs('"+sb.toString()+"')");
            }
        };


        ib_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sb = new StringBuilder();
                getNewJoke();

            }
        });

        getNewJoke();

        return view;
    }

    public void getNewJoke(){
        HttpMethod.getInstance().getNewJoke(new jokeSubscriber(getActivity(),listener));
    }

    public class JokeInterface{

        @JavascriptInterface
        public void saveJoke(String s){
            dao.add(s);
            Snackbar.make(getView(),"收藏成功",Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dao.close();
    }
}
