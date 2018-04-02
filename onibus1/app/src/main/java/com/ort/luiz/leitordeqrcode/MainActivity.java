package com.ort.luiz.leitordeqrcode;

import android.app.Activity;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {
    Button btnScan;
    private String qr;

    FirebaseDatabase database;
    DatabaseReference onibus1Ref;
    SimpleDateFormat formatData;
    Date hora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();
        btnScan = findViewById(R.id.btnScan);

        final Activity activity = this;

        //Cria referencia para o onibus1
        onibus1Ref = database.getReference("Onibus1");

        //Le do banco de dados
        onibus1Ref.child("QR").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                qr = dataSnapshot.getValue().toString();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Camera Scan");
                integrator.setCameraId(0);
                integrator.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result != null){
            if(result.getContents() != null) {
                onibus1Ref.child("QR").child("Valor").setValue(result.getContents());

                formatData = new SimpleDateFormat("HH:mm");
                hora = new Date();

                String dataFormatada = formatData.format(hora);
                onibus1Ref.child("QR").child("Hora").setValue(dataFormatada);
            } else{
                alert("Scan cancelado");
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
    
    private void alert(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}