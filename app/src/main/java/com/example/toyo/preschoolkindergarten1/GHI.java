package com.example.toyo.preschoolkindergarten1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GHI extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghi);
        Button button7=(Button)findViewById(R.id.b12);
        Button button8=(Button) findViewById(R.id.b13);

        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent(GHI.this, JKL.class);
                startActivity(intent);


            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent(GHI.this,SecondPage.class);
                startActivity(intent);


            }
        });
    }
}
