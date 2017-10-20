package com.lizewen.hotfix;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {


    SwipeRefreshLayout swipeRefreshLayout;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            swipeRefreshLayout.setRefreshing(false);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btn = (Button) findViewById(R.id.btn);
        btn.setText("我是补丁包，嘿嘿");

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

              handler.postDelayed(new Runnable() {
                  @Override
                  public void run() {
                    handler.obtainMessage(0).sendToTarget();
                  }
              },3000);

            }
        });

    }
}
