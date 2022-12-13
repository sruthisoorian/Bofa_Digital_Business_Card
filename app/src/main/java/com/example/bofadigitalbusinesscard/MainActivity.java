package com.example.bofadigitalbusinesscard;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;

import android.content.Intent;

import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    ImageButton settingsButton;
    ImageView qrCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set Components to variables
        settingsButton = (ImageButton) findViewById(R.id.settingsButton);
        qrCode = findViewById(R.id.QrCode);

        //VCard Dissection
        String vCardString = "BEGIN:VCARD\n" +
                "N:Sruthi\n" +
                "FN: Sruthi Soorian\n" +
                "ORG: GBT-GCIB And Sales Technology\n" +
                "TITLE: Software Engineer (TAP 2022)\n" +
                "TEL;TYPE#WORK,VOICE:(111) 555-1212\n" +
                "EMAIL: sruthi.soorian@bofa.com\n" +
                "END:VCARD";




        //Open Settings
        settingsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openSettingsPage();
            }
        });

    }

    public void openSettingsPage(){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}