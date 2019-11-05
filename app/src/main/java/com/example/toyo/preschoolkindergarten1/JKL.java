package com.example.toyo.preschoolkindergarten1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JKL extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jkl);
        Button button9=(Button)findViewById(R.id.b14);
        Button button10=(Button) findViewById(R.id.b15);


        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent(JKL.this, MNO.class);
                startActivity(intent);


            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent(JKL.this,SecondPage.class);
                startActivity(intent);


            }
        });
    }
}

