package com.fpp.kontrolki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class dostawaActivity extends AppCompatActivity {

    private Button cofnij, dalej;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dostawa);

        cofnij = findViewById(R.id.cofnij);
        dalej = findViewById(R.id.dalej);


        dalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(dostawaActivity.this, dodatkiActivity.class);

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