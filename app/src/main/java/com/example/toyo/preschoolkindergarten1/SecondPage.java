package com.example.toyo.preschoolkindergarten1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
       Button button1= (Button)findViewById(R.id.b2);
       Button button2= (Button) findViewById(R.id.bhome);
       Button button3=(Button)findViewById(R.id.b5);
       Button button4=(Button)findViewById(R.id.b4);
       Button button5=(Button)findViewById(R.id.b3);
       Button button6=(Button)findViewById(R.id.b7);
       Button button7=(Button)findViewById(R.id.b6);

       try {
           button1.setOnClickListener(new View.OnClickListener() {
               public void onClick(View view) {
                   Intent intent = new Intent(SecondPage.this, Abc.class);
                   startActivity(intent);


               }
           });
           button2.setOnClickListener(new View.OnClickListener() {
               public void onClick(View view) {
                   Intent intent2 = new Intent(SecondPage.this, MainActivity.class);
                   startActivity(intent2);


               }
           });
           button3.setOnClickListener(new View.OnClickListener() {
               public void onClick(View view) {
                   Intent intent3 = new Intent(SecondPage.this, MonthsYear.class);
                   startActivity(intent3);


               }
           });
           button4.setOnClickListener(new View.OnClickListener() {
               public void onClick(View view) {
                   Intent intent4 = new Intent(SecondPage.this, DaysWeek.class);
                   startActivity(intent4);


               }
           });
           button5.setOnClickListener(new View.OnClickListener() {
               public void onClick(View view) {
                   Intent intent5 = new Intent(SecondPage.this, Count1.class);
                   startActivity(intent5);


               }
           });
           button6.setOnClickListener(new View.OnClickListener() {
               public void onClick(View view) {
                   System.out.println("LOL");
                   Intent intent6 = new Intent(SecondPage.this, Quiz1.class);
                   startActivity(intent6);


               }
           });
           button7.setOnClickListener(new View.OnClickListener() {
               public void onClick(View view) {


                   Intent intent7 = new Intent(SecondPage.this, MyRhymes.class);
                   startActivity(intent7);


               }
           });
       }
       catch (Exception e)
       {
           Toast.makeText(this,e.getMessage(), Toast.LENGTH_LONG).show();
       }

    }
}

