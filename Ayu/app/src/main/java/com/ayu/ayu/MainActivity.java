package com.ayu.ayu;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button b1;
    private int [] dogimgs={R.drawable.dog1,R.drawable.dog2,R.drawable.dog3,R.drawable.dog4,R.drawable.dog5};
    private int index;
    private Handler handler;
    private final int MSG_CHANGE = 10086;
    private boolean isPause = true;
    @Override



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.i1);
        b1 = findViewById(R.id.b1);
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if(msg.what == MSG_CHANGE) {
                    index = (index + 1) % dogimgs.length;
                    imageView.setImageResource(dogimgs[index]);
                    return true;
                }
                return false;
            }
        });
        b1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                while (true){
                                    try{
                                        Thread.sleep(2000);
                                    }
                                    catch (InterruptedException e){
                                        e.printStackTrace();
                                    }
                                    if (!isPause){
                                    Message message = new Message();
                                    message.what = MSG_CHANGE;
                                    handler.sendMessage(message);
                                    Log.e("MainActivity","send ms");
                                        }
                                }
                            }
                        }).start();
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                isPause = !isPause;
                            }
                        });
                    }
                }
        );
    }
}
