package com.example.toyo.preschoolkindergarten1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class STU extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu);
        Button button15=(Button)findViewById(R.id.b20);
        Button button16=(Button) findViewById(R.id.b21);

        try {
            button15.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent1 = new Intent(STU.this, VWX.class);
                    startActivity(intent1);


                }
            });
            button16.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent2 = new Intent(STU.this, SecondPage.class);
                    startActivity(intent2);


                }
            });
        }catch (Exception e)
        {
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}