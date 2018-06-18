package com.ort.luiz.mybus;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class SelectOnibusActivity extends Activity {
    Button btnRastrear;
    Spinner ponto;
    String[] pontosValues = {"Onibus1", "Onibus2"};
    ArrayAdapter<String>arrayAdapter;
    String pontoSelected;

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
        setContentView(R.layout.activity_select_onibus);

        //Cria o menu suspenso
        ponto = findViewById(R.id.partidaID);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pontosValues);
        ponto.setAdapter(arrayAdapter);

        //alert(String.valueOf(verificaConexao()));

        //Le o item selecionado no menu
        ponto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                //alert("Your selection is: " + pontosValues[i]);
                pontoSelected = pontosValues[i];
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        //Botao para rastrear o ônibus
        btnRastrear = findViewById(R.id.btnRastrearID);
        btnRastrear.setOnClickListener((View V) ->{
            if(verificaConexao() == true) {
                if (pontoSelected == "Onibus1") {
                    startActivity(new Intent(this, Onibus1Activity.class));
                } else if (pontoSelected == "Onibus2") {
                    startActivity(new Intent(this, Onibus2Activity.class));
                }
            } else{
                alert("Não há conexão com a internet, por favor tente novamente");
            }
        });
    }

    //Verifica a conexão com a internet
    public  boolean verificaConexao() {
        boolean conectado;
        ConnectivityManager conectivtyManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conectivtyManager.getActiveNetworkInfo() != null
                && conectivtyManager.getActiveNetworkInfo().isAvailable()
                && conectivtyManager.getActiveNetworkInfo().isConnected()) {
            conectado = true;
        } else {
            conectado = false;
        }
        return conectado;
    }
        private void alert(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}
