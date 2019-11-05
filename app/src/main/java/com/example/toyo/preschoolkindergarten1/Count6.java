package com.example.toyo.preschoolkindergarten1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Count6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count6);
        Button button1 = (Button) findViewById(R.id.b46);
        Button button2 = (Button) findViewById(R.id.b50);
        try {
            button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(Count6.this, Count5.class);
                    startActivity(intent);


                }
            });
          button2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(Count6.this, MainActivity.class);
                    startActivity(intent);


                }
            });
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}



