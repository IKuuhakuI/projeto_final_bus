package com.ort.luiz.transpORT;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class SelectActivity extends AppCompatActivity {

    Button btnOnibus, btnRota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        btnOnibus = findViewById(R.id.btnOnibusId);
        btnRota = findViewById(R.id.btnRotaId);

        btnOnibus.setOnClickListener(v->{
            startActivity(new Intent(this, SelectOnibusActivity.class));
        });

        btnRota.setOnClickListener(v -> {
            startActivity(new Intent(this, SelectRotaActivity.class));
        });

    }
}
