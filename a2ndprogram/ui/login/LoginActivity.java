package com.example.a2ndprogram.ui.login;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.a2ndprogram.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText loginUsername;
    EditText loginPassword;
    Button btnLogin;

    String user,pass;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginUsername = (EditText) findViewById(R.id.editTextTextPersonName3);
        loginPassword = (EditText) findViewById(R.id.editTextTextPersonName4);
        btnLogin = (Button) findViewById(R.id.button2);

        btnLogin.setOnClickListener((View.OnClickListener) this);
        Bundle bundle=getIntent().getBundleExtra("data");
        user=bundle.getString("usn29");
        pass=bundle.getString("Kmk@2410");

        }

        public void onClick(View v)
        {
            String user1 = loginUsername.getText().toString();
            String pass1 = loginPassword.getText().toString();
            if (user.equals(user1) && pass.equals(pass1)) {
                Toast.makeText(this,"Successful Login",Toast.LENGTH_LONG).show();
            }
            else
            {
                count++;
                if(count==3)
                {
                    btnLogin.setEnabled(false);
                    Toast.makeText(this,"Failed Login Attempts",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(this,"Login Failed "+count+" time",Toast.LENGTH_LONG).show();
                }
            }
        }
}