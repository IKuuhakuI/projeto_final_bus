package com.ort.luiz.transpORT;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class SelectRotaActivity extends Activity {
    Button btnRastrear;
    Spinner pontoInicial, pontoFinal;
    String[] pontosValues = {"Cidade Z", "Disboard", "Grand Line", "Konoha", "Magnolia", "Namekusei", "Toutsuki", "UA"};
    ArrayAdapter<String>arrayAdapterPontoInicial;
    ArrayAdapter<String>arrayAdapterPontoFinal;
    String pontoInicialSelected, pontoFinalSelected;

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
        setContentView(R.layout.activity_select_rota);

        //Cria o menu suspenso
        pontoInicial = findViewById(R.id.partidaID);
        pontoFinal = findViewById(R.id.finalID);

        arrayAdapterPontoInicial = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pontosValues);
        arrayAdapterPontoFinal = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pontosValues);

        pontoInicial.setAdapter(arrayAdapterPontoInicial);
        pontoFinal.setAdapter(arrayAdapterPontoFinal);

        //alert(String.valueOf(verificaConexao()));

        //Le o item selecionado no menu ponto inicial
        pontoInicial.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                //alert("Your selection is: " + pontosValues[i]);
                pontoInicialSelected = pontosValues[i];
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        //Le o item selecionado no menu ponto final
        pontoFinal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                pontoFinalSelected = pontosValues[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        //Botao para rastrear o ônibus
        btnRastrear = findViewById(R.id.btnRastrearID);
        btnRastrear.setOnClickListener((View V) ->{
            if(verificaConexao() == true) {

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
