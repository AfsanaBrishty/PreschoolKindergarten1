package com.example.toyo.preschoolkindergarten1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PQR extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pqr);
        Button button13=(Button)findViewById(R.id.b18);
        Button button14=(Button) findViewById(R.id.b19);

        try {
            button13.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(PQR.this, STU.class);
                    startActivity(intent);


                }
            });
            button14.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(PQR.this, SecondPage.class);
                    startActivity(intent);


                }
            });
        }
        catch (Exception e)
        {
            //e.getMessage();
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}