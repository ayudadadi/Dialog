package com.ayu.ayu;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Student> studentArrayList = new ArrayList<>();
    private MyAdapter adapter;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initStulist();
        listView = findViewById(R.id.l1);
        adapter = new MyAdapter(MainActivity.this,studentArrayList);
        listView.setAdapter(adapter);
    }

    private void initStulist() {
        Student s1 = new Student(R.drawable.dog1,"Mike",16);
        Student s2 = new Student(R.drawable.dog2,"Nike",17);
        Student s3 = new Student(R.drawable.dog3,"Dick",18);
        Student s4 = new Student(R.drawable.dog4,"Mack",19);
        Student s5 = new Student(R.drawable.dog5,"John",20);
        Student s6 = new Student(R.drawable.dog6,"Mike",21);
        studentArrayList.add(s1);
        studentArrayList.add(s2);
        studentArrayList.add(s3);
        studentArrayList.add(s4);
        studentArrayList.add(s5);
        studentArrayList.add(s6);
        studentArrayList.add(s1);
        studentArrayList.add(s2);
        studentArrayList.add(s3);
        studentArrayList.add(s4);
        studentArrayList.add(s5);
        studentArrayList.add(s6);
        studentArrayList.add(s1);
        studentArrayList.add(s2);
        studentArrayList.add(s3);
        studentArrayList.add(s4);
        studentArrayList.add(s5);
        studentArrayList.add(s6);
        studentArrayList.add(s1);
        studentArrayList.add(s2);
        studentArrayList.add(s3);
        studentArrayList.add(s4);
        studentArrayList.add(s5);
        studentArrayList.add(s6);


    }


}
