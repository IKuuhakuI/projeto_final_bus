package com.ort.luiz.transpORT;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class RotaOnibus1Activity extends AppCompatActivity {

    Button btnVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rota_onibus1);

        btnVoltar = findViewById(R.id.btnVoltarOnibus1ID);

        btnVoltar.setOnClickListener((V)->{
            btnVoltar.setBackgroundResource(R.color.aqua);
            startActivity(new Intent(this, Onibus1Activity.class));
        });

    }
}
