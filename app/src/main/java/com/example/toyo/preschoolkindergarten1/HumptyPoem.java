package com.example.toyo.preschoolkindergarten1;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HumptyPoem extends AppCompatActivity {
    MediaPlayer mySong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humpty_poem);
        mySong=MediaPlayer.create(HumptyPoem.this,R.raw.humpty_dumpty);
        Button button1=(Button)findViewById(R.id.b51);
        try {
            button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(HumptyPoem.this, MyRhymes.class);
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




