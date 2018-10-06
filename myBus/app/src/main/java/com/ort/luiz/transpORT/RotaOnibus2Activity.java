package com.ort.luiz.transpORT;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class RotaOnibus2Activity extends AppCompatActivity {

    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rota_onibus2);

        btnVoltar = findViewById(R.id.btnVoltarOnibus2ID);

        btnVoltar.setOnClickListener((V)->{
            startActivity(new Intent(this, Onibus2Activity.class));
            btnVoltar.setBackgroundResource(R.color.aqua);
            finish();
        });
    }
}