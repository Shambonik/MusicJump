package com.example.runner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;

import java.util.Objects;


public class SettingsFragment extends Fragment implements View.OnClickListener{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.settings, null);

        Button exitButton = v.findViewById(R.id.to_menu);
        exitButton.setOnClickListener(this);

        return v;
    }



    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.to_menu) {
            ((MainContent) Objects.requireNonNull(getActivity())).openFragment(0);
        }
    }
}
