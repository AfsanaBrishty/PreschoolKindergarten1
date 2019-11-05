package com.example.toyo.preschoolkindergarten1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DaysWeek extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days_week);
        Button button1=(Button)findViewById(R.id.b53); //To go next page//
        Button button2=(Button)findViewById(R.id.b54); //To go menu page//
        try {
            button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(DaysWeek.this, DaysWeek2.class);
                    startActivity(intent);
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(DaysWeek.this, SecondPage.class);
                    startActivity(intent);
                }
            });
        }catch (Exception e)
        {
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
