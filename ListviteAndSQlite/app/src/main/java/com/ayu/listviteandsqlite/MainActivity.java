package com.ayu.listviteandsqlite;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IOnDataChangeListener{
    private ListView lv_stu;
    private Button add_btn;
    private ArrayList<Student> StuArrayList = new ArrayList<>();
    private StuAdapter adapter;
    private EditText ed_key;
    private ImageView img_search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        finViews();
//        initStuArrayList();
        adapter = new StuAdapter(MainActivity.this, StuArrayList,MainActivity.this);

        readDataFromDB();
        lv_stu.setAdapter(adapter);
        lv_stu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = StuArrayList.get(position);
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,EditActivity.class);
                intent.putExtra("STUNO",student.getStuno());
                intent.putExtra("NAME",student.getName());
                intent.putExtra("AGE",student.getAge());
                startActivityForResult(intent,1002);
            }
        });

    }

    private void readDataFromDB() {
        String path = getFilesDir().getAbsolutePath() + File.separator + "stu.db";
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(path, null);
        String sql = "create table if not exists student(stuno varchar(20),name varchar(20),age int)";
        db.execSQL(sql);
        StuArrayList.clear();
        Cursor cursor = db.query("student", null, null, null, null, null, null, null);
        if (cursor != null || cursor.getCount() > 0) {
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                String stuno = cursor.getString(0);
                String name = cursor.getString(1);
                int age = cursor.getInt(2);
                Student student = new Student(stuno, name, age);
                StuArrayList.add(student);
            }
        }


        adapter.notifyDataSetChanged();
        cursor.close();
        db.close();
    }

    private void initStuArrayList() {
        StuArrayList.add(new Student("1001", "Nick", 20));
        StuArrayList.add(new Student("1002", "Dick", 21));
        StuArrayList.add(new Student("1003", "Mike", 22));
        StuArrayList.add(new Student("1004", "Jack", 23));
    }

    private void finViews() {
        lv_stu = findViewById(R.id.lv_stu);
        add_btn = findViewById(R.id.add_btn);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, AddActivity.class);
                startActivityForResult(intent, 1001);
            }
        });
        ed_key = findViewById(R.id.ed_key);
        img_search =findViewById(R.id.img_search);
        img_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = ed_key.getText().toString();
                searchFromDB(key);
            }
        });
    }

    private void searchFromDB(String key) {
        String path = getFilesDir().getAbsolutePath() + File.separator + "stu.db";
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(path, null);
        String where = "name like'%"+key+"%' OR stuno like '%"+key+"%'"+ "OR age ="+key;
        StuArrayList.clear();
        Cursor cursor = db.query("student", null, where, null, null, null, null, null);
        if (cursor != null || cursor.getCount() > 0) {
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                String stuno = cursor.getString(0);
                String name = cursor.getString(1);
                int age = cursor.getInt(2);
                Student student = new Student(stuno, name, age);
                StuArrayList.add(student);
            }
        }


        adapter.notifyDataSetChanged();
        cursor.close();
        db.close();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == 2001) {
            String stuno = data.getStringExtra("STUNO");
            String name = data.getStringExtra("NAME");
            int age = data.getIntExtra("AGE", 0);
            Student student = new Student(stuno, name, age);
            addStuToDB(student);
        }
        else if (resultCode ==3001){
            String stuno = data.getStringExtra("STUNO");
            String name = data.getStringExtra("NAME");
            int age = data.getIntExtra("AGE", 0);
            Student student = new Student(stuno, name, age);
            updateStuToDB(student);
        }
    }

    private void updateStuToDB(Student student) {
        String path = getFilesDir().getAbsolutePath() + File.separator + "stu.db";
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(path, null);

//        第一种
//        String sql = "update student set name ='"+student.getName()+"',"+" age ="+student.getAge()+" where stuno ='"+student.getStuno()+"'";
//        db.execSQL(sql);
//        db.close();
//        readDataFromDB();

        //第二种接口
        ContentValues values = new ContentValues();
        values.put("name",student.getName());
        values.put("age",student.getAge());
        String where = "stuno ='"+student.getStuno()+"'";
        db.update("student",values,where,null);
        db.close();
        readDataFromDB();
    }

    private void addStuToDB(Student student) {
        String path = getFilesDir().getAbsolutePath() + File.separator + "stu.db";
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(path, null);
        ContentValues values = new ContentValues();
        values.put("stuno", student.getStuno());
        values.put("name", student.getName());
        values.put("age", student.getAge());
        db.insert("student", null, values);
        db.close();
        readDataFromDB();

    }

    @Override
    public void del(Student student) {
        String path = getFilesDir().getAbsolutePath() + File.separator + "stu.db";
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(path, null);

        //第二种使用delete接口
//        String where = "stuno ='"+student.getStuno()+"'";
//        db.delete("student",where,null);
//        db.close();
//        readDataFromDB();
        //第三种使用delete接口
        String where = "stuno =?";
        String [] argArray ={student.getStuno()};
        db.delete("student",where,argArray);
        db.close();
        readDataFromDB();
    }
}
