package com.fpp.kontrolki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

public class dodatkiActivity extends AppCompatActivity {

    private Spinner kawy, przyprawy;
    private Button cofnij, dalej;

    String kawa, wielkosc, dodatek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodatki);

        cofnij = findViewById(R.id.cofnij);
        dalej = findViewById(R.id.dalej);

        cofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cofnij = new Intent(dodatkiActivity.this, dostawaActivity.class);
                startActivity(cofnij);
            }
        });

        dalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dalej = new Intent(dodatkiActivity.this, podsumowanieActivity.class);
                startActivity(dalej);
            }
        });

        kawy = findViewById(R.id.jakaKawa);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.kawy_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        kawy.setAdapter(adapter1);

        przyprawy = findViewById(R.id.jakiePrzyprawy);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.przyprawy_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        przyprawy.setAdapter(adapter2);
    }

    public void rozmiar(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.mala:
                if (checked)
                    wielkosc = "MALA";
                break;
            case R.id.srednia:
                if (checked)
                    wielkosc = "SREDNIA";
                break;
            case R.id.duza:
                if (checked)
                    wielkosc = "DUZA";
                break;
        }
    }
}