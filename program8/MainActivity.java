package com.example.program8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bs,bh,del,save,call;
    EditText phno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b0=(Button)findViewById(R.id.b0);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);
        b6=(Button)findViewById(R.id.b6);
        b7=(Button)findViewById(R.id.b7);
        b8=(Button)findViewById(R.id.b8);
        b9=(Button)findViewById(R.id.b9);
        bs=(Button)findViewById(R.id.bs);
        bh=(Button)findViewById(R.id.bh);
        del=(Button)findViewById(R.id.del);
        save=(Button)findViewById(R.id.save);
        call=(Button)findViewById(R.id.call);
        phno=(EditText)findViewById(R.id.phno);

        b0.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        bs.setOnClickListener(this);
        bh.setOnClickListener(this);
        save.setOnClickListener(this);
        del.setOnClickListener(this);
        call.setOnClickListener(this);
        phno.setText("");
    }

    @Override
    public void onClick(View v) {
        if(v.equals(b0))
            phno.append("0");
        else if(v.equals(b1))
            phno.append("1");
        else if(v.equals(b2))
            phno.append("2");
        else if(v.equals(b3))
            phno.append("3");
        else if(v.equals(b4))
            phno.append("4");
        else if(v.equals(b5))
            phno.append("5");
        else if(v.equals(b6))
            phno.append("6");
        else if(v.equals(b7))
            phno.append("7");
        else if(v.equals(b8))
            phno.append("8");
        else if(v.equals(b9))
            phno.append("9");
        else if(v.equals(bs))
            phno.append("*");
        else if(v.equals(bh))
            phno.append("#");
        else if(v.equals(save)){
            Intent content = new Intent(ContactsContract.Intents.Insert.ACTION);
            content.setType(ContactsContract.RawContacts.CONTENT_TYPE);
            content.putExtra(ContactsContract.Intents.Insert.NAME,"Keerthana");
            content.putExtra(ContactsContract.Intents.Insert.PHONE,phno.getText().toString());
            startActivity(content);
        }
        else if(v.equals(del)){
            String data = phno.getText().toString();
            if(data.length()>0){
                phno.setText(data.substring(0,data.length()-1));
            }
            else{
                phno.setText("");
            }
        }
        else if(v.equals(call)){
            String data = phno.getText().toString();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:"+data));
            startActivity(intent);
        }

    }
}