package com.example.yls.demoa;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by yls on 2018/10/9.
 */

public class AddMainActivity extends AppCompatActivity{
    private EditText ename;
    private EditText eage;
    private RadioButton r1;
    private RadioButton r2;
    private RadioButton r3;
    private RadioButton r4;
    private RadioButton r5;
    private Button b1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ename = findViewById(R.id.ename);
        eage = findViewById(R.id.eage);
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        r3 = findViewById(R.id.r3);
        r4 = findViewById(R.id.r4);
        r5 = findViewById(R.id.r5);
        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ename.getText().toString();
                int age = Integer.parseInt(eage.getText().toString());
                int imgid =R.drawable.dog1;
                if (r1.isChecked()){
                    imgid = R.drawable.dog1;
                }else if (r2.isChecked()){
                    imgid = R.drawable.dog2;
                }
                else if (r3.isChecked()){
                    imgid = R.drawable.dog3;
                }
                else if (r4.isChecked()){
                    imgid = R.drawable.dog4;
                }
                else if (r5.isChecked()){
                    imgid = R.drawable.dog5;
                }
                Intent intent = new Intent();
                intent.putExtra("NAME",name);
                intent.putExtra("AGE",age);
                intent.putExtra("IMG",imgid);
                setResult(2001,intent);

                finish();

            }
        });

    }
}
