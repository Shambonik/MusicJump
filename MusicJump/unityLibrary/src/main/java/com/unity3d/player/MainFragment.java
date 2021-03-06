package com.unity3d.player;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import net.frakbot.jumpingbeans.JumpingBeans;

import java.util.ArrayList;

/**
 * Класс - главное меню, являющийся фрагментом для главного активити
 * @see MainContent
 * @author Денис Пономарев, Данил Кузин
 **/
public class MainFragment extends Fragment implements View.OnClickListener{

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
        View v = inflater.inflate(R.layout.main_fragment, null);

        final TextView title = v.findViewById(R.id.title_game);
        JumpingBeans jumpingBeans1 = JumpingBeans.with(title)
                .setWavePerCharDelay(50)
                .makeTextJump(0, title.getText().length())
                .setIsWave(true)
                .setLoopDuration(2000)
                .build();

        setClickers(v);

        return v;
    }

    /**
     * Метод, устанавливающий обработчики нажатия для кнопок меню
     * @param v - представление фрагмента меню
     * */
    private void setClickers(View v){
        ArrayList<View> buttons = v.findViewById(R.id.main_layout).getTouchables();

        for (View view: buttons){
            view.setOnClickListener(this);
        }
    }

    /**
     * Метод - обработчик нажатия на кнопку
     * @param v - элемент, над которым произошло действие
     * */
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.choose_char) {
            ((MainContent) requireActivity()).openFragment(1);
        } else if (id == R.id.start_play) {
            ((MainContent) requireActivity()).openFragment(2);
        } else if (id == R.id.settings) {
            ((MainContent) requireActivity()).openFragment(3);
        } else if (id == R.id.login) {
            ((MainContent) requireActivity()).openFragment(4);
        } else if (id == R.id.registr) {
            ((MainContent) requireActivity()).openFragment(5);
        }
    }
}
