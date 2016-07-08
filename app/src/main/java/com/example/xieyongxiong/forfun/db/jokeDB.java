package com.example.xieyongxiong.forfun.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by xieyongxiong on 16-7-7.
 */
public class jokeDB extends SQLiteOpenHelper {

    public jokeDB(Context context) {
        super(context, "joke", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table joke("
                +"_id integer primary key autoincrement,"
                +"content text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
