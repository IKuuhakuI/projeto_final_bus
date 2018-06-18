package com.ort.luiz.mybus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class SelectActivity extends AppCompatActivity {

    Button btnOnibus, btnRastrear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        btnOnibus = findViewById(R.id.btnOnibusId);
        btnRastrear = findViewById(R.id.btnRastrearID);

        btnOnibus.setOnClickListener(V->{
            startActivity(new Intent(this, SelectOnibusActivity.class));
        });
    }
}
