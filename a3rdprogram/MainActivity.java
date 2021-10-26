package com.example.a3rdprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 = findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.append("1");
            }
        });
        Button b2 = findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.append("2");
            }
        });
        Button b3 = findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.append("3");
            }
        });
        Button b4 = findViewById(R.id.b4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.append("4");
            }
        });
        ;
        Button b5 = findViewById(R.id.b5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.append("5");
            }
        });
        Button b6 = findViewById(R.id.b6);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.append("6");
            }
        });
        ;
        Button b7 = findViewById(R.id.b7);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.append("7");
            }
        });
        ;
        Button b8 = findViewById(R.id.b8);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.append("8");
            }
        });
        ;
        Button b9 = findViewById(R.id.b9);
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.append("9");
            }
        });
        ;
        Button b0 = findViewById(R.id.b0);
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.append("0");
            }
        });
        Button div = findViewById(R.id.bd);
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.append("/");
            }
        });
        ;
        Button mul = findViewById(R.id.bm);
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.append("*");
            }
        });
        Button sub = findViewById(R.id.bs);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.append("-");
            }
        });
        ;
        Button add = findViewById(R.id.ba);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.append("+");
            }
        });
        Button dot = findViewById(R.id.bdot);
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.append(".");
            }
        });
        Button eq = findViewById(R.id.beq);
        Button clr = findViewById(R.id.bc);
        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.setText("");
            }
        });
        res = findViewById(R.id.resl);

        eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    try {
                        String data = res.getText().toString();
                        if (data.contains("+")) {
                            String[] ops = data.split(Pattern.quote("+"));
                            if (ops.length == 2) {
                                double op1 = Double.parseDouble(ops[0]);
                                double op2 = Double.parseDouble(ops[1]);
                                double result = op1 + op2;
                                res.setText(String.valueOf(result));
                            } else {
                                Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_LONG).show();
                            }
                        }
                        if (data.contains("-")) {
                            String[] ops = data.split("-");
                            if (ops.length == 2) {
                                double op1 = Double.parseDouble(ops[0]);
                                double op2 = Double.parseDouble(ops[1]);
                                double result = op1 - op2;
                                res.setText(String.valueOf(result));
                            } else {
                                Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_LONG).show();
                            }
                        }
                        if (data.contains("*")) {
                            String[] ops = data.split(Pattern.quote("*"));
                            if (ops.length == 2) {
                                double op1 = Double.parseDouble(ops[0]);
                                double op2 = Double.parseDouble(ops[1]);
                                double result = op1 * op2;
                                res.setText(String.valueOf(result));
                            } else {
                                Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_LONG).show();
                            }
                        }
                        if (data.contains("/")) {
                            String[] ops = data.split("/");
                            if (ops.length == 2) {
                                double op1 = Double.parseDouble(ops[0]);
                                double op2 = Double.parseDouble(ops[1]);
                                double result = op1 / op2;
                                res.setText(String.valueOf(result));
                            } else {
                                Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_LONG).show();
                            }
                        }
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_LONG).show();
                    }
            }
        });
    }
}