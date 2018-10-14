package com.example.yls.demoa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView stuListView;
    private ArrayList<Student> studentArrayList = new ArrayList<>();
    private StuAdapter adapter;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stuListView = findViewById(R.id.lv_stu);
        button = findViewById(R.id.b1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,
                        AddMainActivity.class);
                startActivityForResult(intent,1001);
            }
        });
        initStuArrayList();
        adapter = new StuAdapter(MainActivity.this, studentArrayList);

        stuListView.setAdapter(adapter);

        stuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,
                        "姓名"+studentArrayList.get(i).getName() + " 年龄"
                                +  studentArrayList.get(i).getAge(),
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (data == null){
            return;
        }
        String name = data.getStringExtra("NAME");
        int age = data.getIntExtra("AGE",0);
        int imgId = data.getIntExtra("IMG",R.drawable.dog1);
        Student s = new Student(name, age, imgId);
        studentArrayList.add(s);
        adapter.notifyDataSetChanged();
    }
    /**
     * 初始化学生列表的数据
     */
    private void initStuArrayList() {
        Student s1 = new Student("张一", 18, R.drawable.dog1);
        Student s2 = new Student("张二", 19, R.drawable.dog2);
        Student s3 = new Student("张三", 20, R.drawable.dog3);
        Student s4 = new Student("张四", 21, R.drawable.dog4);
        Student s5 = new Student("张五", 22, R.drawable.dog5);

        studentArrayList.add(s1);
        studentArrayList.add(s2);
        studentArrayList.add(s3);
        studentArrayList.add(s4);
        studentArrayList.add(s5);


    }
}
