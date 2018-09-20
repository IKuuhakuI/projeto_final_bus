package com.ort.luiz.transpORT;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class RotaOnibus1Activity extends AppCompatActivity {

    TextView rotaOnibus1;
    String pontosOnibus1 = "Disboard\nGrand Line\nKonoha\nToutsuki\nUA";
    Button btnVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rota_onibus1);

        rotaOnibus1 = findViewById(R.id.rotaOnibus1ID);
        btnVoltar = findViewById(R.id.btnVoltarOnibus1ID);

        btnVoltar.setOnClickListener((V)->{
            startActivity(new Intent(this, Onibus1Activity.class));
        });

        rotaOnibus1.setText(pontosOnibus1);
    }
}
