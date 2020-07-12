package com.example.myapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class ClickerFragment extends Fragment {

    public int count = 0;
    AppCompatImageView pikachuImgButton;
    TextView pikachuTextView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.clicker_layout, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pikachuImgButton = view.findViewById(R.id.pikachu_image);
        pikachuTextView = view.findViewById(R.id.clickCountLabel);

        view.findViewById(R.id.clickerPrevious).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ClickerFragment.this)
                        .navigate(R.id.action_ClickerFragment_to_FirstFragment);
            }
        });

        pikachuImgButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                count++;
                pikachuTextView.setText("You pet Pikachu: " + count + " times!");
            }
        });
    }
}