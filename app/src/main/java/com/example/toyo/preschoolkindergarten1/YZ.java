package com.example.toyo.preschoolkindergarten1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class YZ extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yz);
        button=findViewById(R.id.b24);
        try {

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent(YZ.this,SecondPage.class);
                startActivity(intent);

            }
        });
        }catch (Exception e)
        {
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
