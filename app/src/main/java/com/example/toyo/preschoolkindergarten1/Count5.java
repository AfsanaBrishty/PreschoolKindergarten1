package com.example.toyo.preschoolkindergarten1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Count5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count5);
        Button button1 = (Button) findViewById(R.id.b44);
        Button button2 = (Button) findViewById(R.id.b45);
        Button button3 = (Button) findViewById(R.id.b49);
        try {
            button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(Count5.this, Count4.class);
                    startActivity(intent);


                }
            });
           button2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(Count5.this, Count6.class);
                    startActivity(intent);


                }
            });
            button3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(Count5.this, MainActivity.class);
                    startActivity(intent);


                }
            });
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
