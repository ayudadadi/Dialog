package com.ayu.ayu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private ArrayList<Student> studentArrayList;
    private Context context;
    public MyAdapter(Context context, ArrayList<Student> studentArrayList){
        this.context = context;
        this.studentArrayList =studentArrayList;
    }
    @Override
    public int getCount() {
        return studentArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.my_list_item,parent,false);
        ImageView imageView = convertView.findViewById(R.id.imgView);
        imageView.setImageResource(studentArrayList.get(position).getImgid());
        TextView nameView = convertView.findViewById(R.id.nameView);
        nameView.setText(studentArrayList.get(position).getName());
        TextView ageView = convertView.findViewById(R.id.ageView);
        ageView.setText(String.valueOf(studentArrayList.get(position).getAge()));


        return convertView;
    }
}
