package com.example.toyo.preschoolkindergarten1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyRhymes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_rhymes);
        Button button1= (Button)findViewById(R.id.b28);  //go to twinkle
        Button button2= (Button) findViewById(R.id.b29); //go to baabaa
        Button button3=(Button)findViewById(R.id.b30);  //got to humty
        Button button4=(Button)findViewById(R.id.b31); // go to johnny
        Button button5=(Button)findViewById(R.id.b32); // myRhymes to menu page



        try {
            button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(MyRhymes.this, Twinklepoem.class);
                    startActivity(intent);


                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(MyRhymes.this, BaabaaPoem.class);
                    startActivity(intent);
                }
            });
            button3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(MyRhymes.this, HumptyPoem.class);
                    startActivity(intent);
                }
            });
            button4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(MyRhymes.this, JohnyPoem.class);
                    startActivity(intent);
                }
            });

            button5.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(MyRhymes.this, SecondPage.class);
                    startActivity(intent);


                }
            });



        }catch (Exception e)
        {
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }
}



