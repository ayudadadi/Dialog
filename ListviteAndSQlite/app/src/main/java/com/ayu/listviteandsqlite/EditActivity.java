package com.ayu.listviteandsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {
    private EditText ed_stuno;
    private EditText ed_name;
    private EditText ed_age;
    private Button save_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        findViews();
    }
    private void findViews() {
        ed_stuno = findViewById(R.id.ed_stuno);
        ed_name = findViewById(R.id.ed_name);
        ed_age = findViewById(R.id.ed_age);
        save_btn = findViewById(R.id.save_btn);

        String stuno = getIntent().getStringExtra("STUNO");
        String name = getIntent().getStringExtra("NAME");
        int age = getIntent().getIntExtra("AGE",0);

        ed_stuno.setText(stuno);
        ed_name.setText(name);
        ed_age.setText(String.valueOf(age));

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stuno =ed_stuno.getText().toString();
                String name =ed_name.getText().toString();
                int age =Integer.parseInt(ed_age.getText().toString());

                Intent intent = new Intent();
                intent.putExtra("STUNO",stuno);
                intent.putExtra("NAME",name);
                intent.putExtra("AGE",age);
                setResult(3001,intent);
                finish();
            }
        });
    }
}
