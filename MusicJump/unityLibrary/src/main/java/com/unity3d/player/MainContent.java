package com.unity3d.player;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;


public class MainContent extends AppCompatActivity {
    private MediaPlayer mPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragments);

        openFragment(0);
        startMusic();
    }

        private void startMusic(){
        mPlayer= MediaPlayer.create(getApplicationContext(), R.raw.music);
        mPlayer.setLooping(true);
        mPlayer.start();
    }

    public void openFragment(int numberFragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (numberFragment){
            case 0: {
                fragmentTransaction.replace(R.id.fragment_container_view, new MainFragment());
            } break;
            case 1: {
                fragmentTransaction.replace(R.id.fragment_container_view, new ChooseCharacterFragment());
            } break;
            case 2: {
                fragmentTransaction.replace(R.id.fragment_container_view, new ChooseLevelFragment());
            } break;
            case 3: {
                fragmentTransaction.replace(R.id.fragment_container_view, new SettingsFragment());
            } break;
        }

        fragmentTransaction.commit();
    }

    @Override
    protected void onStop() {
        mPlayer.pause();
        super.onStop();
    }

    @Override
    protected void onPostResume() {
        mPlayer.start();
        super.onPostResume();
    }

    public void startUnityActivity(){
        Intent intent = new Intent(MainContent.this, UnityPlayerActivity.class);
        startActivity(intent);
    }
}
