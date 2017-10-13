package com.example.ewan.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.ewan.myapplication.ui.activity.BaseActivity;

public class MainActivity extends BaseActivity {
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.ewan.myapplication.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });
    }
}
