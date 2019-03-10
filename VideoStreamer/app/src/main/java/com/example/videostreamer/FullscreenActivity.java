package com.example.videostreamer;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.net.Uri;
import android.widget.MediaController;
import android.widget.VideoView;
import android.view.SurfaceHolder.Callback;
import android.media.MediaPlayer.OnPreparedListener;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends Activity implements SurfaceHolder.Callback, OnPreparedListener {
    private MediaPlayer mediaPlayer;
    private SurfaceHolder vidHolder;
    private SurfaceView vidSurface;
    String vidAddress = "https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        vidSurface = (SurfaceView) findViewById(R.id.surfView);
        vidHolder = vidSurface.getHolder();
        vidHolder.addCallback(this);
        /*super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VideoView vidView = (VideoView)findViewById(R.id.myVideo);
        String vidAddress = "https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4";
        Uri vidUri = Uri.parse(vidAddress);

        MediaController vidControl = new MediaController(this);
        vidControl.setAnchorView(vidView);
        vidView.setMediaController(vidControl);
        vidView.setVideoURI(vidUri);
        vidView.start();*/
    }

    @Override
    public void surfaceCreated(SurfaceHolder arg0) {
        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDisplay(vidHolder);
            mediaPlayer.setDataSource(vidAddress);
            mediaPlayer.prepare();
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mediaPlayer.start();
    }
}
