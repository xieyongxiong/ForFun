package com.example.xieyongxiong.forfun.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xieyongxiong on 16-7-7.
 */
public class jokeDao {

    private Context context;
    private jokeDB jd;
    private SQLiteDatabase db;

    public jokeDao(Context context) {
        this.context = context;
        jd = new jokeDB(context);
        db = jd.getReadableDatabase();
    }

    public List<String> query(){
        db = jd.getReadableDatabase();
        Cursor cursor = db.query("joke",null,null,null,null,null,null);
        int jokeIndex = cursor.getColumnIndex("content");
        List<String> result = new ArrayList<>();
        while(cursor.moveToNext()){
            result.add(cursor.getString(jokeIndex));
        }
        return result;
    }

    public void add(String content){
        db = jd.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("content",content);
        db.insert("joke",null,values);
    }

    public void delete(String content){
        db = jd.getWritableDatabase();
        db.delete("joke","content=?",new String[]{content});
    }

    public void close(){
        if(db.isOpen())
            db.close();
    }


}
