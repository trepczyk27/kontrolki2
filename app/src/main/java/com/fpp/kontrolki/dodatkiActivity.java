package com.fpp.kontrolki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;

public class dodatkiActivity extends AppCompatActivity {

    private Spinner Marka, model;
    private Button cofnij, dalej;

    String marka, adres, telefon, zListy;
    String dodatek = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodatki);

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
                if(model.isEnabled()){
                    dodatek += zListy;
                }
                Intent dalej = new Intent(dodatkiActivity.this, podsumowanieActivity.class);
                dalej.putExtra("Adres", adres);
                dalej.putExtra("Telefon", telefon);

                dalej.putExtra("Kawa", marka);
                dalej.putExtra("Model", dodatek);
                startActivity(dalej);
            }
        });

        Marka = findViewById(R.id.jakaMarka);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.jakaMarka_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Marka.setAdapter(adapter1);

        model = findViewById(R.id.jakiModel);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.jakiModel_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        model.setAdapter(adapter2);

        Marka.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                marka = adapter1.getItem(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        model.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                zListy = adapter2.getItem(position).toString().toLowerCase();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }



    public void checkboxClicked(View view){
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()){


            case R.id.jakiModel:
                if(checked){

                    model.setEnabled(true);
                    model.setVisibility(View.VISIBLE);

                }else{

                    model.setVisibility(View.GONE);
                    model.setEnabled(false);
                }
                break;
        }
    }
}