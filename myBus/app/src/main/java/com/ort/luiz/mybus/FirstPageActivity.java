package com.ort.luiz.mybus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;

public class FirstPageActivity extends Activity {
    Button btnRastrear;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        btnRastrear = findViewById(R.id.btnRastrearID);

        btnRastrear.setOnClickListener((V)->{
            startActivity(new Intent(this, MainActivity.class));
        });
    }
}
