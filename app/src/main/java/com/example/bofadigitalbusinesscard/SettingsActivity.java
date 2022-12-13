package com.example.bofadigitalbusinesscard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;

import android.view.View;
import android.widget.*;

public class SettingsActivity extends AppCompatActivity {
    ImageButton exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //Set Components to variables
        exitButton = (ImageButton) findViewById(R.id.exitButton);

        //Exit Settings
        exitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                closeSettingsPage();
            }
        });
    }

    public void closeSettingsPage(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}