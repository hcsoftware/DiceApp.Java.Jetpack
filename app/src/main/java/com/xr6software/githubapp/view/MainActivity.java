package com.xr6software.githubapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xr6software.githubapp.R;

public class MainActivity extends AppCompatActivity {

    private Button ma_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ma_btn = findViewById(R.id.ma_btn0);

        setOnClickListeners();

    }

    private void setOnClickListeners(){

        ma_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}