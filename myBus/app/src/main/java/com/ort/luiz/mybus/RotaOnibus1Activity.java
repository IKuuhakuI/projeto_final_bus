package com.ort.luiz.mybus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ort.luiz.transpORT.R;


public class RotaOnibus1Activity extends AppCompatActivity {

    TextView rotaOnibus1;
    String pontosOnibus1 = "Disboard\nGrand Line\nKonoha\nToutsuki\nUA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rota_onibus1);

        rotaOnibus1 = findViewById(R.id.rotaOnibus1ID);

        rotaOnibus1.setText(pontosOnibus1);
    }
}
