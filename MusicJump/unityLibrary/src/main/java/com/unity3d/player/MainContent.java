package com.unity3d.player;


import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import java.io.IOException;


/**
 * Главная активность, на которой располагаются все фрагменты
 * @author Денис Пономарев, Данил Кузин
 * @see ChooseCharacterFragment
 * @see ChooseLevelFragment
 * @see SettingsFragment
 * @see MainFragment
 * */
public class MainContent extends AppCompatActivity{
    /**Поле управления воспроизведения аудио файла*/
    private MediaPlayer mPlayer = new MediaPlayer();

    /**Текущая громкость аудио файла*/
    private static Integer musicVolume;

    /**
     * Метод получения значения поля {@link MainContent#musicVolume}
     * @return возвращает текущую громкость аудио файла
     * */
    public static Integer getMusicVolume() {
        return musicVolume;
    }

    /**
     * Метод определения значения поля {@link MainContent#musicVolume}
     * @param musicVolume - текущая громкость аудио файла
     * */
    public static void setMusicVolume(int musicVolume) {
        MainContent.musicVolume = musicVolume;
    }

    /**
     * Метод, в котором производится первоначальная настройка activity, создаются объекты визуального интерфейса
     * @param savedInstanceState - содержит прежнее состояние activity, если оно было сохранено
     * */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragments);

        openFragment(0);
        startMusic();
    }

    /**
     * Метод запуска музыки в меню путем
     * вызова соответствующих методов поля {@link MainContent#mPlayer}
     * */
    public void startMusic(){
        if(mPlayer.isPlaying()){
            return;
        }

        mPlayer= MediaPlayer.create(getApplicationContext(), R.raw.music);
        mPlayer.setLooping(true);
        mPlayer.start();
    }

    /**
     * Метод остановки музыки в меню путем
     * вызова соответствующих методов поля {@link MainContent#mPlayer}
     * */
    public void stopMusic() throws IOException {
        mPlayer.stop();
        mPlayer.prepare();
        mPlayer.seekTo(0);
    }

    /**
     * Метод вывода на экран соответствующего фрагмента меню
     * @param numberFragment - номер фрагмента
     * */
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
            case 4: {
                fragmentTransaction.replace(R.id.fragment_container_view, new LoginFragment());
            } break;
            case 5: {
                fragmentTransaction.replace(R.id.fragment_container_view, new RegistrationFragment());
            } break;
        }

        fragmentTransaction.commit();
    }

    /**
     * Метод получения класса {@link AudioManager} , который
     * управляет громкостью звука, из контекста
     * @return возвращает {@link AudioManager} контекста
     * */
    public AudioManager getAudioManager(){
        return (AudioManager) getSystemService(Context.AUDIO_SERVICE);
    }

    /**
     * Метод, который вызывается, когда окно становится невидимым для пользователя.
     * В данном случае музыка ставится на паузу.
     * */
    @Override
    protected void onStop() {
        mPlayer.pause();
        super.onStop();
    }

    /**
     * Метод вызывается, когда возобновление активности завершено.
     * В данном случае музыка продолжает свое проигрывание.
     * */
    @Override
    protected void onPostResume() {
        mPlayer.start();
        super.onPostResume();
    }

    /**
     * Метод вызывается, когда игрок выбирает уровень,
     * запускается активити, созданное в Unity
     * */
    public void startUnityActivity(){
        Intent intent = new Intent(MainContent.this, UnityPlayerActivity.class);
        startActivity(intent);
    }
}
