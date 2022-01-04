package com.fpp.kontrolki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class podsumowanieActivity extends AppCompatActivity {

    private Button dalej;
    private Switch aSwitch;

    private TextView jMarka, jadres, jtelefon, jdod;

    String marka, model, dodatek,adres, telefon;
    String dodatki = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podsumowanie);

        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            adres =(String) b.get("Adres");
            telefon =(String) b.get("Telefon");
            model =(String) b.get("model");

            marka =(String) b.get("Kawa");
        }

        ktoreDodatki();

        jMarka = findViewById(R.id.tekst2);
        jdod = findViewById(R.id.tekst3);
        jadres = findViewById(R.id.tekst5);
        jtelefon = findViewById(R.id.tekst6);


        jMarka.setText("Pojazd "+ marka + " " + " o modelu: ");
        jdod.setText(dodatki);
        jadres.setText("adres: " + adres);
        jtelefon.setText("telefon: " + telefon);


        dalej = findViewById(R.id.dalej);
        aSwitch = findViewById(R.id.regulamin);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                dalej.setEnabled(isChecked);

            }
        });

        dalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(podsumowanieActivity.this, realizacjaActivity.class);
                startActivity(intent);
            }
        });
    }

    public void ktoreDodatki(){
        if(dodatek.contains("Nissan GTR")){
            dodatki += "- Nissan GTR \n";
        }
        if(dodatek.contains("Porshe Cayman")){
            dodatki += "- Porshe Cayman\n";
        }
        if(dodatek.contains("Ford Shelby Cobra")){
            dodatki += "- Ford Shelby Cobra \n";
        }
        if(dodatek.contains("Mercedes AMG GT")){
            dodatki += "- Mercedes AMG GT \n";
        }
        if(dodatek.contains("Mercedes Klasa G<")){
            dodatki += "- Mercedes Klasa G< \n";
        }

    }
}