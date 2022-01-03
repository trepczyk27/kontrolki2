package com.fpp.kontrolki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.Toast;

public class realizacjaActivity extends AppCompatActivity {
    private RatingBar ocena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizacja);

        ocena = findViewById(R.id.ocena);

        ocena.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                if(v < 4){
                    Toast.makeText(realizacjaActivity.this, "Dziękujemy za opinię weźmiemy to pod uwagę", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(realizacjaActivity.this, "Dziękujemy za dobrą opinię;)", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}