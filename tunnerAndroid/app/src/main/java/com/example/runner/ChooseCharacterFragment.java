package com.example.runner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Класс - меню выбора персонажей, являющийся фрагментом для главного активити
 * @see MainContent
 * @author Денис Пономарев
 **/
public class ChooseCharacterFragment extends Fragment implements View.OnClickListener{

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
        View v = inflater.inflate(R.layout.choose_character, null);
        setClickers(v);

        return v;
    }

    /**
     * Метод, устанавливающий обработчики нажатия для кнопок меню
     * @param v - представление фрагмента меню
     * */
    private void setClickers(View v){
        ArrayList<View> buttons = v.findViewById(R.id.choose_char_lay).getTouchables();

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
            ((MainContent) Objects.requireNonNull(getActivity())).openFragment(0);
        }
    }
}
