package com.unity3d.player;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Objects;


public class MainFragment extends Fragment implements View.OnClickListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_fragment, null);
        setClickers(v);
        return v;
    }

    private void setClickers(View v){
        ArrayList<View> buttons = v.findViewById(R.id.main_layout).getTouchables();

        for (View view: buttons){
            view.setOnClickListener(this);
        }
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.choose_char) {
            ((MainContent) requireActivity()).openFragment(1);
        } else if (id == R.id.start_play) {
            ((MainContent) requireActivity()).openFragment(2);
        } else if (id == R.id.settings) {
            ((MainContent) requireActivity()).openFragment(3);
        }
    }
}
