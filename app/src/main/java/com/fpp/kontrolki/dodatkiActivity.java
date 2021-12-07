package com.fpp.kontrolki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

public class dodatkiActivity extends AppCompatActivity {

    private Spinner kawy, przyprawy;
    private Button cofnij, dalej;

    String kawa, wielkosc, dodatek, adres, telefon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodatki);
        //pobranie z poprzedniego activity
        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            adres =(String) b.get("Adres");
            telefon =(String) b.get("Telefon");
        }

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
                dalej.putExtra("Adres", adres);
                dalej.putExtra("Telefon", telefon);
                dalej.putExtra("Wielkosc", wielkosc);
                dalej.putExtra("Kawa", kawa);
                dalej.putExtra("Dodatek", dodatek);
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

        kawy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                kawa = adapter1.getItem(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        przyprawy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dodatek = adapter2.getItem(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void rozmiar(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.mala:
                if (checked)
                    wielkosc = "mała";
                break;
            case R.id.srednia:
                if (checked)
                    wielkosc = "średnia";
                break;
            case R.id.duza:
                if (checked)
                    wielkosc = "duża";
                break;
        }
    }
}