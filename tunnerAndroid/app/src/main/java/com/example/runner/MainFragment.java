package com.example.runner;


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
        switch (v.getId()){
            case R.id.choose_char: {
                ((MainContent) Objects.requireNonNull(getActivity())).openFragment(1);
            } break;
            case R.id.start_play: {
                ((MainContent) Objects.requireNonNull(getActivity())).openFragment(2);
            } break;
            case R.id.settings:{
                ((MainContent) Objects.requireNonNull(getActivity())).openFragment(3);
            } break;
        }
    }
}
