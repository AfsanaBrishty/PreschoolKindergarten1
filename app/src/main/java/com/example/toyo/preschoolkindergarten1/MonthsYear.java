package com.example.toyo.preschoolkindergarten1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MonthsYear extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_months_year);
        Button button=(Button)findViewById(R.id.b25);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent(MonthsYear.this, MonthsYear2.class);
                startActivity(intent);


            }
        });
    }
}
