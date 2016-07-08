package com.example.xieyongxiong.forfun;


import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        manager  = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.container,new JokeFragment())
                .commit();
    }

    @OnClick(R.id.btn_joke)
    public void btn_joke(){
        manager.beginTransaction()
                .replace(R.id.container,new JokeFragment())
                .commit();
    }

    @OnClick(R.id.btn_img)
    public void btn_img(){
        manager.beginTransaction()
                .replace(R.id.container,new ImgFragment())
                .commit();
    }

    @OnClick(R.id.btn_save)
    public void btn_save(){
        manager.beginTransaction()
                .replace(R.id.container,new SaveFragment())
                .commit();
    }

}
