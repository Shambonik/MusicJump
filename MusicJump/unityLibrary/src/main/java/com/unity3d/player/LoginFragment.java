package com.unity3d.player;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;

import java.io.IOException;
import java.util.ArrayList;

public class LoginFragment extends Fragment implements View.OnClickListener{

    /**
     * Метод создания фрагмента, в котором можно получить ранее сохраненное состояние фрагмента
     * @param savedInstanceState - сохраненные параметры фрагмента
     * */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.login_page, null);
        setClickers(v);

        return v;
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
        } else if(id == R.id.registr) {
            ((MainContent) requireActivity()).openFragment(5);
        }
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
}
