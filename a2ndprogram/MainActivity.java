package com.example.a2ndprogram;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a2ndprogram.ui.login.LoginActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText etUsername;
    EditText etPassword;
    Button btnSignup;
    String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d@$!]{8,}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = (EditText)findViewById(R.id.editTextTextPersonName);
        etPassword = (EditText)findViewById(R.id.editTextTextPersonName2);
        btnSignup = (Button)findViewById(R.id.button);
        btnSignup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        if(validatePassword(password)) {
            Bundle bundle = new Bundle();
            bundle.putString("usn29",username);
            bundle.putString("Kmk@2410",password);
            Intent it = new Intent(this,LoginActivity.class);
            it.putExtra("data", bundle);
            startActivity(it);
        }
        else
        {
            Toast.makeText(getBaseContext(),"Invalid Password",Toast.LENGTH_LONG).show();
        }
    }
    public boolean validatePassword(String password){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}