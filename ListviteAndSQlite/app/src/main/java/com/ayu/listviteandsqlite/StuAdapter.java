package com.ayu.listviteandsqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class StuAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<Student> StuArrayList;
    private IOnDataChangeListener listener;

    public StuAdapter(Context context, ArrayList<Student> stuArrayList,IOnDataChangeListener listener) {
        this.context = context;
        this.StuArrayList = stuArrayList;
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return StuArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return StuArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup ViewGroup) {
        if(view ==null){
            view = LayoutInflater.from(context).inflate(R.layout.stu_item,ViewGroup,false);

            StuViewHolder StuViewHolder = new StuViewHolder();
            StuViewHolder.tvStuno =view.findViewById(R.id.txt_stuno);
            StuViewHolder.tvName =view.findViewById(R.id.txt_name);
            StuViewHolder.tvAge =view.findViewById(R.id.txt_age);
            StuViewHolder.img_del = view.findViewById(R.id.img_del);

            view.setTag(StuViewHolder);
        }
        final Student student = StuArrayList.get(position);
        StuViewHolder viewHolder = (StuViewHolder) view.getTag();
        viewHolder.tvStuno.setText(student.getStuno());
        viewHolder.tvName.setText(student.getName());
        viewHolder.tvAge.setText(String.valueOf(student.getAge()));
        viewHolder.img_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.del(student);
            }
        });
        return view;
    }
}
