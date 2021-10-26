package com.example.program6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button xml,json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xml = (Button)findViewById(R.id.xml);
        json = (Button)findViewById(R.id.json);

        xml.setOnClickListener(this);
        json.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.equals(xml))
        {
            Intent it=new Intent(this,MainActivity2.class);
            it.putExtra("mode",1);
            startActivity(it);
        }
        else if (v.equals(json))
        {
            Intent it=new Intent(this,MainActivity2.class);
            it.putExtra("mode",2);
            startActivity(it);
        }
    }
}