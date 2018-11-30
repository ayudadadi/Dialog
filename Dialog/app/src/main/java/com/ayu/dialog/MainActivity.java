package com.ayu.dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button dl1;
    private Button dl2;
    private Button dl3;
    private Button dl4;
    private Button dl5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        dl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSimpleDialog();
            }
        });
        dl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSelectDialog();
            }
        });
        dl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleDialog();
            }
        });
        dl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                duoxuanDialog();
            }
        });
        dl5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zdyDialog();
            }
        });
    }

    private void zdyDialog() {
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_input,null,false);
        final EditText nameEdit = view.findViewById(R.id.edt_name);
        final EditText psEdit = view.findViewById(R.id.edt_ps);
        new AlertDialog.Builder(MainActivity.this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("请输入你的用户名和密码")
                .setView(view)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = nameEdit.getText().toString();
                        String ps = psEdit.getText().toString();
                        Toast.makeText(MainActivity.this,"你的用户名是："+name+"，你的密码是"+ps,Toast.LENGTH_SHORT).show();

                    }
                })
                .create()
                .show();

    }

    private void duoxuanDialog() {
        final String[] sports = {"足球","篮球","网球","台球"};
        final boolean isCheck[] =new boolean[6];
        new AlertDialog.Builder(MainActivity.this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("请选择你的爱好")
                .setMultiChoiceItems(sports, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        isCheck[which] = isChecked;

                        if (isChecked) {
                            Toast.makeText(MainActivity.this, "你添加了" + sports[which], Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(MainActivity.this, "你取消了" + sports[which], Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuffer buffer = new StringBuffer();
                        for (int i = 0;i<isCheck.length;i++){
                            if (isCheck[i]){
                                buffer.append(sports[i]+"，");
                            }
                        }
                        Toast.makeText(MainActivity.this,"你的爱好有"+buffer,Toast.LENGTH_SHORT).show();
                    }
                })
                .create()
                .show();

    }

    private void singleDialog() {
        final String [] xingbie = {"男","女","未知"};
        new AlertDialog.Builder(MainActivity.this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("请选择你的性别")
                .setSingleChoiceItems(xingbie, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"你的性别是"+xingbie[which],Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create()
                .show();
    }

    private void showSelectDialog() {
        final String [] cities = {"北京","广州","上海","深圳","杭州"};
        new AlertDialog.Builder(MainActivity.this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("请选择你的城市")
                .setItems(cities, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"你居住在"+cities[which],Toast.LENGTH_SHORT).show();
                    }
                })
                .create()
                .show();
    }

    private void findViews() {
        dl1 = findViewById(R.id.dl1);
        dl2 = findViewById(R.id.dl2);
        dl3 = findViewById(R.id.dl3);
        dl4 = findViewById(R.id.dl4);
        dl5 = findViewById(R.id.dl5);
    }

    private void showSimpleDialog() {
        new AlertDialog.Builder(MainActivity.this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("提示")
                .setMessage("今天你的生日")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"谢谢",Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"知道了",Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("无所谓", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"无所谓",Toast.LENGTH_SHORT).show();
                    }
                })
                .create()
                .show();

    }
}
