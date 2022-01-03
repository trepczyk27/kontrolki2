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

    private TextView jmarka, jadres, jtelefon ;

    String marka,  adres, telefon;


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

            marka =(String) b.get("Kawa");
        }



        jmarka = findViewById(R.id.tekst2);
        jadres = findViewById(R.id.tekst5);
        jtelefon = findViewById(R.id.tekst6);


        jmarka.setText("Pojazd "+ marka + " ");
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



}