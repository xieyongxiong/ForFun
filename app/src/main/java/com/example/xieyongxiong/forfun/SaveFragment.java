package com.example.xieyongxiong.forfun;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xieyongxiong.forfun.adapter.jokeAdapter;
import com.example.xieyongxiong.forfun.db.jokeDao;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SaveFragment extends Fragment {

    private jokeDao dao;

    private List<String> data;

    private RecyclerView recyclerView;

    private jokeAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_save, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        dao = new jokeDao(getContext());
        data = dao.query();

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(manager);

        manager.setOrientation(OrientationHelper.VERTICAL);

        adapter = new jokeAdapter(getActivity(),data);

        recyclerView.setAdapter(adapter);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter.setOnItemClickListener(new jokeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
            }

            @Override
            public void onItemLongClick(View view, int position) {
                String number = adapter.AdpterData(position);
                delete(number,position);
            }
        });
        return v;
    }

    private void delete(final String number, final int position){

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());//先得到构造器
        builder.setTitle("提示"); //设置标题
        builder.setMessage("是否取消收藏 \""+number.substring(0,10)+"...\""+" ?"); //设置内容
        builder.setIcon(R.drawable.refresh);//设置图标，图片id即可

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dao.delete(number);
                data.remove(position);
                adapter.notifyItemRemoved(position);
                dialog.dismiss(); //关闭dialog
                Snackbar.make(getView(),"删除成功",Snackbar.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();

    }

}
