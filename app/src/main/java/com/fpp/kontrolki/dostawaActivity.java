package com.fpp.kontrolki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class dostawaActivity extends AppCompatActivity {

    private Button cofnij, dalej;
    private EditText adres, telefon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dostawa);

        cofnij = findViewById(R.id.cofnij);
        dalej = findViewById(R.id.dalej);

        adres = findViewById(R.id.wprowadzAdres);
        telefon = findViewById(R.id.wprowadzTelefon);

        dalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(dostawaActivity.this, zdjPojazdow2.class);
                next.putExtra("Adres", adres.getText().toString());
                next.putExtra("Telefon", telefon.getText().toString());
                startActivity(next);
            }
        });

        cofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(dostawaActivity.this, MainActivity.class);
                startActivity(back);
            }
        });
    }
}