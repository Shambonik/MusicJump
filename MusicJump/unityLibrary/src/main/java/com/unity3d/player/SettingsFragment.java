package com.unity3d.player;

import android.media.AudioManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.fragment.app.Fragment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;


/**
 * Класс - главное меню, являющийся фрагментом для главного активити
 * @see MainContent
 * @author Денис Пономарев, Данил Кузин
 **/
public class SettingsFragment extends Fragment implements View.OnClickListener{
    /**Поле управления громкостью звука*/
    private AudioManager audioManager;

    /**
     * Метод создания фрагмента, в котором можно получить ранее сохраненное состояние фрагмента
     * @param savedInstanceState - сохраненные параметры фрагмента
     * */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Метод создания представления, в котором устанавливается визуальный интерфейс фрагмента
     * @param inflater - позволяет получить содержимое ресурса layout и передать его во фрагмент
     * @param container - контейнер, в который будет загружаться фрагмент
     * @param savedInstanceState - состояние фрагмента
     * @return возвращает созданное с помощью LayoutInflater представление в виде объекта
     * View - представление фрагмента меню
     * */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.settings, null);
        musicBarSettings(v);
        setClickers(v);
        return v;
    }

    /**
     * Метод управления громкостью звука путем передвижения ползунка
     * @param v - представление фрагмента меню
     * */
    private void musicBarSettings(View v){
        audioManager = ((MainContent) requireActivity()).getAudioManager();
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        SeekBar volumeControl = v.findViewById(R.id.volumeControl);
        volumeControl.setMax(maxVolume);
        if(MainContent.getMusicVolume() == null) {
            MainContent.setMusicVolume(maxVolume / 2);
            volumeControl.setProgress(maxVolume / 2);
        }
        else{
            volumeControl.setProgress(MainContent.getMusicVolume());
        }

        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
                MainContent.setMusicVolume(progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    /**
     * Метод, устанавливающий обработчики нажатия для кнопок меню
     * @param v - представление фрагмента меню
     * */
    private void setClickers(View v){
        ArrayList<View> touchables = v.getTouchables();
        for (View button : touchables){
            if(button instanceof Button){
                button.setOnClickListener(this);
            }
        }
    }

    /**
     * Метод - обработчик нажатия на кнопку
     * @param v - элемент, над которым произошло действие
     * */
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.to_menu) {
            ((MainContent) requireActivity()).openFragment(0);
        } else if (id == R.id.turn_off) {
            try {
                ((MainContent) requireActivity()).stopMusic();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (id == R.id.turn_on) {
            ((MainContent) requireActivity()).startMusic();
        }
    }
}