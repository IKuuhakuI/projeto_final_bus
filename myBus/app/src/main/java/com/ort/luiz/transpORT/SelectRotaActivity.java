package com.ort.luiz.transpORT;

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
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SelectRotaActivity extends Activity {
    Button btnRastrear, btnVoltar;
    TextView textOnibus1, textOnibus2;

    Spinner pontoInicial, pontoFinal;

    String[] pontosValues = {"Cidade Z", "Disboard", "Grand Line", "Konoha", "Magnolia", "Namekusei", "Toutsuki", "UA"}, onibus1Pontos = {"Disboard", "Grand Line", "Konoha", "Toutsuki", "UA"}, onibus2Pontos = {"Cidade Z", "Disboard", "Konoha", "Magnolia", "Namekusei"};
    String pontoInicialSelected, pontoFinalSelected;
    int atOnibus1, atOnibus2;

    ArrayAdapter<String>arrayAdapterPontoInicial;
    ArrayAdapter<String>arrayAdapterPontoFinal;

    FirebaseDatabase database;
    DatabaseReference pontoRef;

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

        //Referência do banco de dados
        database = FirebaseDatabase.getInstance();
        pontoRef = database.getReference("Pontos");

        //Instanciando as variáveis
        pontoInicial = findViewById(R.id.partidaID);
        pontoFinal = findViewById(R.id.finalID);
        btnVoltar = findViewById(R.id.btnVerRotaOnibus1ID);
        btnRastrear = findViewById(R.id.btnRastrearID);
        textOnibus1 = findViewById(R.id.onibus1TextID);
        textOnibus2 = findViewById(R.id.onibus2TextID);

        //Cria o menu suspenso
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
                alert("mudou");
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
        btnRastrear.setOnClickListener((View V) ->{
            if(verificaConexao() == true) {
                if(pontoInicialSelected != pontoFinalSelected){
                    //Verifica se o ônibus2 passa pelo ponto inicial
                    pontoRef.child(pontoInicialSelected).child("Onibus2").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(Integer.parseInt(dataSnapshot.getValue().toString()) == 1){
                                pontoRef.child(pontoFinalSelected).child("Onibus2").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        if(Integer.parseInt(dataSnapshot.getValue().toString()) == 1){
                                            atOnibus2 = 1;
                                        } else {
                                            atOnibus2 = 0;
                                        }
                                        if(atOnibus2 == 0){
                                            textOnibus2.setText("Onibus2: Não passa");
                                        } else {
                                            textOnibus2.setText("Onibus2: Passa");
                                        }
                                    }

                                    @Override
                                    public void onCancelled(DatabaseError databaseError) { }
                                });
                            } else {
                                atOnibus2 = 0;
                                textOnibus2.setText("Onibus2: Não passa");
                            }
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) { }
                    });

                    //Verifica se o ônibus1 passa pelo ponto inicial
                    pontoRef.child(pontoInicialSelected).child("Onibus1").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(Integer.parseInt(dataSnapshot.getValue().toString()) == 1){
                                pontoRef.child(pontoFinalSelected).child("Onibus1").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        if(Integer.parseInt(dataSnapshot.getValue().toString()) == 1){
                                            atOnibus1 = 1;
                                            alert("Aqui");
                                        } else {
                                            atOnibus1 = 0;
                                            alert("Aqui");
                                        }
                                        if(atOnibus1 == 0){
                                            textOnibus1.setText("Onibus1: Não passa");
                                        } else {
                                            textOnibus1.setText("Onibus1: Passa");
                                        }
                                    }
                                    @Override
                                    public void onCancelled(DatabaseError databaseError) { }
                                });
                            } else {
                                atOnibus1 = 0;
                                textOnibus1.setText("Onibus1: Não passa");
                            }
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) { } });
                } else {
                    alert("Escolha pontos diferentes!");
                    textOnibus1.setText("Onibus1:");
                    textOnibus2.setText("Onibus2:");
                }
            } else{
                alert("Não há conexão com a internet, por favor tente novamente");
            }
        });

        btnVoltar. setOnClickListener(v -> {
            startActivity(new Intent(this, SelectActivity.class));
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
