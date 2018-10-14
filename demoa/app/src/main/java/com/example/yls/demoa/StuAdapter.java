package com.example.yls.demoa;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yls on 2018/10/8.
 */

public class StuAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Student> studentArrayList;

    public StuAdapter(Context context, ArrayList<Student> studentArrayList){
        this.context = context;
        this.studentArrayList = studentArrayList;
    }

    @Override
    public int getCount() {
        return studentArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return studentArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    int count = 0;
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Log.e("StuAdapter", "getview " + i + " count = " + count);

        // 先判断view是不是空 非空可以复用 不需要重新构建 节省内存
        if(view == null) {
            count++;
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.list_item,
                    viewGroup, false);

            // 使用Holder保存子组件 避免每次使用时重复find
            StuViewHolder holder = new StuViewHolder();
            holder.headImg = view.findViewById(R.id.stu_img);
            holder.nameView = view.findViewById(R.id.stu_name);
            holder.ageView = view.findViewById(R.id.stu_age);

            view.setTag(holder);
        }

        Student stu = studentArrayList.get(i);

        StuViewHolder holder = (StuViewHolder) view.getTag();

        holder.headImg.setImageResource(stu.getImgId());
        holder.ageView.setText(String.valueOf(stu.getAge()));
        holder.nameView.setText(stu.getName());

        return view;
    }
}
