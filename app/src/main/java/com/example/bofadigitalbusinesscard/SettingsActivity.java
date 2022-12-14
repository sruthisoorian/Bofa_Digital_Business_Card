package com.example.bofadigitalbusinesscard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;

import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity {
    ImageButton exitButton;
    EditText editCompany, editName, editPhone, editPosition, editEmail;

    private Spinner editTheme;
    ArrayList<String> spinnerArray = new ArrayList<String>();

    String name, company, job, cell, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //Set Components to variables
        exitButton = findViewById(R.id.exitButton);
        editCompany = findViewById(R.id.editCompany);
        editName = findViewById(R.id.editName);
        editPhone = findViewById(R.id.editPhone);
        editPosition = findViewById(R.id.editPosition);
        editEmail = findViewById(R.id.editEmail);
        editTheme = findViewById(R.id.editTheme);

        //Set the text in the field
        Intent intent = getIntent();
        name = intent.getExtras().getString("name");
        job = intent.getExtras().getString("job");
        company = intent.getExtras().getString("company");
        cell = intent.getExtras().getString("cell");
        email = intent.getExtras().getString("email");

        editName.setText(name);
        editPosition.setText(job);
        editCompany.setText(company);
        editPhone.setText(cell);
        editEmail.setText(email);

        //Populate Spinner
        spinnerArray.add("Default Grey");
        spinnerArray.add("Business Blue");
        spinnerArray.add("Profit Pink");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        editTheme.setAdapter(adapter);



        //Exit Settings
        exitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                closeSettingsPage();
            }
        });
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l){
        String choice = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(getApplicationContext(), choice, Toast.LENGTH_LONG).show();
    }

    public void closeSettingsPage(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("name", editName.getText().toString());
        intent.putExtra("job", editPosition.getText().toString());
        intent.putExtra("company", editCompany.getText().toString());
        intent.putExtra("cell", editPhone.getText().toString());
        intent.putExtra("email", editEmail.getText().toString());
        startActivity(intent);
    }


}