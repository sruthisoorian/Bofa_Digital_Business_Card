package com.example.bofadigitalbusinesscard;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;

import android.content.Intent;

import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private static boolean STARTUP = true;

    ImageButton settingsButton;
    ImageView qrCode;
    ImageView headshotImage, bofaLogo;
    TextView jobTag, nameTag, companyTag, cellTag, emailTag, cardDecal;

    String name, company, job, cell, email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set Components to variables
        settingsButton = (ImageButton) findViewById(R.id.settingsButton);
        qrCode = findViewById(R.id.QrCode);
        headshotImage = findViewById(R.id.headshotImage);
        jobTag = findViewById(R.id.jobTag);
        nameTag = findViewById(R.id.nameTag);
        companyTag = findViewById(R.id.companyTag);
        cellTag = findViewById(R.id.cellTag);
        emailTag = findViewById(R.id.emailTag);
        bofaLogo = findViewById(R.id.bofaLogo);
        cardDecal = findViewById(R.id.decal);

        //Declare string values
        if (STARTUP == true){
            name = "Sruthi Soorian";
            job = "Software Engineer (TAP 2022)";
            company = "GBT-GCIB AND SALES TECHNOLOGY";
            cell = "555-123-4567";
            email = "sruthi.soorian@bofa.com";
            ranOnce();
        }
        else{
            Intent intent = getIntent();
            name = intent.getExtras().getString("name");
            job = intent.getExtras().getString("job");
            company = intent.getExtras().getString("company");
            cell = intent.getExtras().getString("cell");
            email = intent.getExtras().getString("email");

        }

        //Set default strings
        nameTag.setText(name);
        jobTag.setText(job);
        companyTag.setText(company);
        cellTag.setText(cell);
        emailTag.setText(email);

        //VCard Dissection





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
        intent.putExtra("name", name);
        intent.putExtra("job", job);
        intent.putExtra("company", company);
        intent.putExtra("cell", cell);
        intent.putExtra("email", email);
        startActivity(intent);
    }

    private void ranOnce(){
        if(STARTUP){
            STARTUP = false;
        }
    }
}