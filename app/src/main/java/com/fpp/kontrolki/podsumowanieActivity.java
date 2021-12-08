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

    private TextView jkawa, jadres, jtelefon, jdod;

    String kawa, wielkosc, dodatek, adres, telefon;
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
            dodatek =(String) b.get("Dodatek");
            wielkosc =(String) b.get("Wielkosc");
            kawa =(String) b.get("Kawa");
        }

        ktoreDodatki();

        jkawa = findViewById(R.id.tekst2);
        jdod = findViewById(R.id.tekst3);
        jadres = findViewById(R.id.tekst5);
        jtelefon = findViewById(R.id.tekst6);


        jkawa.setText("Kawa "+ kawa + " " + wielkosc + " z dodatkiem: ");
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
        if(dodatek.contains("cukier")){
            dodatki += "- cukier \n";
        }
        if(dodatek.contains("miod")){
            dodatki += "- miód \n";
        }
        if(dodatek.contains("mleko")){
            dodatki += "- mleko \n";
        }
        if(dodatek.contains("kakao")){
            dodatki += "- kakao \n";
        }
        if(dodatek.contains("cynamon")){
            dodatki += "- cynamon \n";
        }
        if(dodatek.contains("imbir")){
            dodatki += "- imbir \n";
        }
        if(dodatek.contains("kardamon")){
            dodatki += "- kardamon \n";
        }
        if(dodatek.contains("wanilia")){
            dodatki += "- wanilia \n";
        }
    }
}