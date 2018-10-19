package com.ort.luiz.transpORT;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RotaOnibus1Activity extends AppCompatActivity {

    Button btnVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rota_onibus1);

        Intent i = getIntent();

        String lastPage = i.getStringExtra("lastPage");

        //alert(lastPage);

        btnVoltar = findViewById(R.id.btnVoltarOnibus1ID);

        btnVoltar.setOnClickListener((V)->{
            btnVoltar.setBackgroundResource(R.color.aqua);
            if(lastPage.equals("selectRota")){
                startActivity(new Intent(this, SelectRotaActivity.class));
            } else if(lastPage.equals("selectOnibus")) {
                startActivity(new Intent(this, Onibus1Activity.class));
            }
        });

    }

    private void alert(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}
