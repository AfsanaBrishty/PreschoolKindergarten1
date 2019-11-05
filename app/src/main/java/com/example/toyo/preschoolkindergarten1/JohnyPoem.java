package com.example.toyo.preschoolkindergarten1;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class JohnyPoem extends AppCompatActivity {
    MediaPlayer mySong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_johny_poem);
        mySong=MediaPlayer.create(JohnyPoem.this,R.raw.johnyjohny);
        Button button1=(Button)findViewById(R.id.b52);   //johnyjohny to MyRhymes page;
        try {
            button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(JohnyPoem.this, MyRhymes.class);
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

