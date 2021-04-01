package com.unity3d.player;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * Класс - меню выбора уровня игры, являющийся фрагментом для главного активити
 * @see MainContent
 * @author Денис Пономарев
 **/
public class ChooseLevelFragment extends Fragment implements View.OnClickListener{

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
        View v = inflater.inflate(R.layout.level_fragment, null);
        setClickers(v);

        return v;
    }

    /**
     * Метод, устанавливающий обработчики нажатия для кнопок меню
     * @param v - представление фрагмента меню
     * */
    private void setClickers(View v){
        ArrayList<View> buttons = v.findViewById(R.id.levels_layout).getTouchables();

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
        if (v.getId() == R.id.to_menu) {
            ((MainContent) requireActivity()).openFragment(0);
        }
        if (v.getId() == R.id.first_level){
            ((MainContent) requireActivity()).startUnityActivity();
        }
    }
}