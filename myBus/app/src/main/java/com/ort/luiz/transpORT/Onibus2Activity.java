package com.ort.luiz.transpORT;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.app.Activity;

public class Onibus2Activity extends Activity {
    FirebaseDatabase database;
    DatabaseReference onibus2Ref;

    Button btnVoltar, btnVerRotaOnibus2;
    String acState;

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
        setContentView(R.layout.activity_onibus2);

        database = FirebaseDatabase.getInstance();
        onibus2Ref = database.getReference("Onibus2");

        //Botao voltar
        btnVoltar = findViewById(R.id.btnVoltarID);
        //Abre a pagina inicial
        btnVoltar.setOnClickListener((V)->{ startActivity(new Intent(this, SelectOnibusActivity.class)); });

        btnVerRotaOnibus2 = findViewById(R.id.btnVerRotaOnibus2ID);
        //Abre as rotas do ônibus 2
        btnVerRotaOnibus2.setOnClickListener((V)->{ startActivity(new Intent(this, RotaOnibus2Activity.class)); });

        //Le do banco de dados
        onibus2Ref.child("QR").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                TextView textView = findViewById(R.id.textPartidaID);
                String valor = dataSnapshot.child("Valor").getValue().toString();
                String hora = dataSnapshot.child("Hora").getValue().toString();

                onibus2Ref.child("AcState").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(Integer.parseInt(dataSnapshot.getValue().toString()) == 0){
                            acState = "Desligado";
                        } else {
                            acState = "Ligado";
                        }

                        textView.setText("Ponto atual: " + valor + "\nHora: " + hora + "\nAr Condicionado: " + acState);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

