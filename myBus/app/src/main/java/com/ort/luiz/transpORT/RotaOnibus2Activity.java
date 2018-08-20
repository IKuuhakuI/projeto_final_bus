package com.ort.luiz.transpORT;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class RotaOnibus2Activity extends AppCompatActivity {

    TextView rotaOnibus2;
    String pontosOnibus2 = "Cidade Z\nDisboard\nKonoha\nMagnolia\nNamekusei";
    Button btnVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rota_onibus2);

        rotaOnibus2 = findViewById(R.id.rotaOnibus2ID);
        btnVoltar.findViewById(R.id.btnVoltarID);

        //Mostra a rota do Onibus2
        rotaOnibus2.setText(pontosOnibus2);
    }
}
