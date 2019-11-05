package com.example.toyo.preschoolkindergarten1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DEF extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_def);
        Button button5=(Button)findViewById(R.id.b10);
        Button button6=(Button) findViewById(R.id.b11);

        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent(DEF.this, GHI.class);
                startActivity(intent);


            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent(DEF.this,SecondPage.class);
                startActivity(intent);


            }
        });
    }
}
