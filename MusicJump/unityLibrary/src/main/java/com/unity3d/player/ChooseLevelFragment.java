package com.unity3d.player;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/*
* Класс - меню выбора персонажа для игры
* @author Пономарев Денис, Кузин Данил
*/
public class ChooseLevelFragment extends Fragment implements View.OnClickListener{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /*
    * Метод, возвращающий главному меню фрагмент
    * */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.level_fragment, null);
        setClickers(v);

        return v;
    }


    private void setClickers(View v){
        ArrayList<View> buttons = v.findViewById(R.id.levels_layout).getTouchables();

        for (View view: buttons){
            view.setOnClickListener(this);
        }
    }


    /*
    Метод, реагирующий на нажатия кнопок в меню выбора персонажа
    @param v - элемент, над которым произвели действие
    */
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