package com.ort.luiz.mybus;

import android.accessibilityservice.GestureDescription;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class FirstPageActivity extends Activity {
    Button btnRastrear;
    Spinner onibus;
    String[] onibusValues = {"Onibus1", "Onibus2"};
    ArrayAdapter<String>arrayAdapter;
    String onibusSelected;

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

        //Cria o menu suspenso
        onibus = findViewById(R.id.onibusID);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, onibusValues);
        onibus.setAdapter(arrayAdapter);

        //Le o item selecionado no menu
        onibus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(getApplicationContext(),"Your selection is: " + onibusValues[i], Toast.LENGTH_SHORT).show();
                onibusSelected = onibusValues[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Botao para rastrear o ônibus
        btnRastrear = findViewById(R.id.btnRastrearID);
        btnRastrear.setOnClickListener((View V) ->{
            if(onibusSelected == "Onibus1") {
                startActivity(new Intent(this, Onibus1Activity.class));
            }
        });
    }
}
