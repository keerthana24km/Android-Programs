package com.example.program5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button start,stop;
    TextView counter;
    int count = 0;
    boolean running = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);
        counter = (TextView) findViewById(R.id.counter);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);

    }

        class MyCounter extends Thread {
            @Override
            public void run() {
                while (running) {
                    count++;
                    handler.sendEmptyMessage(count);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        Handler handler = new Handler(){
        public void handleMessage(Message m){
          counter.setText(String.valueOf(m.what));
        }
        };

    @Override
    public void onClick(View v) {
        if(v.equals(start)){
            count=0;
            running=true;
            new MyCounter().start();
        }
        else if(v.equals(stop)){
            running=false;
        }
    }
}