package com.example.dean.soundintime;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    private MediaPlayer zoidbergPlayer;
    private MediaPlayer nujdikiPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button zoidbergButton;
        Button nujdikButton;
        zoidbergButton = (Button) findViewById(R.id.zoidbergBtn);
        nujdikButton = (Button) findViewById(R.id.nujdikBtn);

        zoidbergPlayer = MediaPlayer.create(getApplicationContext(), R.raw.zoidberg_whoop);
        zoidbergPlayer.setVolume(1.0f, 1.0f);
        nujdikiPlayer = MediaPlayer.create(getApplicationContext(), R.raw.nuzhdiki);
        nujdikiPlayer.setVolume(1.0f, 1.0f);

        zoidbergButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StopPlaying();
                zoidbergPlayer.start();
            }
        });

        nujdikButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StopPlaying();
                nujdikiPlayer.start();
            }
        });
    }

    private void StopPlaying() {
        if(zoidbergPlayer != null && zoidbergPlayer.isPlaying()){
            zoidbergPlayer.stop();
        }
        if(nujdikiPlayer!=null && nujdikiPlayer.isPlaying()){
            nujdikiPlayer.stop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(nujdikiPlayer != null) {
            nujdikiPlayer.release();
            nujdikiPlayer = null;
        }

        if(zoidbergPlayer != null){
            zoidbergPlayer.release();
            zoidbergPlayer = null;
        }
    }
}
