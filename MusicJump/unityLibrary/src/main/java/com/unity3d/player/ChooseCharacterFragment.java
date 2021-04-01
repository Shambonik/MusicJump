package com.unity3d.player;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Objects;


public class ChooseCharacterFragment extends Fragment implements View.OnClickListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.choose_character, null);
        setClickers(v);

        return v;
    }


    private void setClickers(View v){
        ArrayList<View> buttons = v.findViewById(R.id.choose_char_lay).getTouchables();

        for (View view: buttons){
            view.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.to_menu) {
            ((MainContent) requireActivity()).openFragment(0);
        }
    }
}
