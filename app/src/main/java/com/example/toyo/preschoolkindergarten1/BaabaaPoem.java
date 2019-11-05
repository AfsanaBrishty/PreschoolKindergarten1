package com.example.toyo.preschoolkindergarten1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BaabaaPoem extends AppCompatActivity {

    MediaPlayer mySong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baabaa_poem);
        mySong=MediaPlayer.create(BaabaaPoem.this,R.raw.baabaablack);
        Button button1=(Button)findViewById(R.id.b37); //baabaa to myrhymes
        try {
            button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(BaabaaPoem.this, MyRhymes.class);
                    startActivity(intent);


                }
            });
        }
        catch (Exception e)
        {
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }
    public void playIT(View v){
        mySong.start();
    }
    @Override
    protected void onPause(){
        super.onPause();
        mySong.release();

    }
}
