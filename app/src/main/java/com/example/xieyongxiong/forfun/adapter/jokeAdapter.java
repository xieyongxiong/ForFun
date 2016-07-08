package com.example.xieyongxiong.forfun.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xieyongxiong.forfun.R;

import java.util.List;

/**
 * Created by xieyongxiong on 16-7-7.
 */
public class jokeAdapter extends RecyclerView.Adapter<jokeAdapter.myViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private OnItemClickListener onItemClickListener;
    private List<String> data;

    public jokeAdapter(Context context,List<String> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item,parent,false);
        myViewHolder holder = new myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final myViewHolder holder, int position) {

        int i=position+1;
        holder.textView.setText(i+": "+data.get(position));
        if(onItemClickListener!=null){
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            holder.textView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    onItemClickListener.onItemLongClick(holder.textView,pos);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public String AdpterData(int position){
        return data.get(position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        public myViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.text);
        }
    }
}
