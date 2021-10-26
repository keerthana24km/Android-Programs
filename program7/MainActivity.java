package com.example.program7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    EditText text;
    TextToSpeech texttosp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        text = (EditText)findViewById(R.id.text);
        button.setOnClickListener(this);
        texttosp = new TextToSpeech(getBaseContext(),
                status -> {
                    if(status!=TextToSpeech.ERROR){
                        Toast.makeText(getBaseContext(),"Success ...", Toast.LENGTH_LONG).show();
                        Log.i("Text to speech","******  Success ...");
                    }
                    else{
                        Toast.makeText(getBaseContext(),"Failure ...", Toast.LENGTH_LONG).show();
                        Log.i("Text to speech","******  Failure ...");
                    }
                });
        texttosp.setLanguage(Locale.UK);
    }
    @Override
    public void onClick(View v) {
        String data = (String)text.getText().toString();
        texttosp.speak(data,TextToSpeech.QUEUE_FLUSH,null);

        Toast.makeText(this,data, Toast.LENGTH_LONG).show();
        Log.i("TextToSpeech",data);
    }
}