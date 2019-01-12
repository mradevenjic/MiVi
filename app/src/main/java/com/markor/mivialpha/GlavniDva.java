package com.markor.mivialpha;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class GlavniDva extends ActionBarActivity implements View.OnClickListener{

    TextView igrac1, igrac2, puntitekst1, puntitekst2;
    String tekst1, tekst2, upis1, upis2;
    EditText eTekst1, eTekst2;
    int brojac1, brojac2, punti1, punti2, x;
    Bundle basket;
    Intent a;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glavni_dva);

        postaviVarijable();

        brojac1 = 0;
        brojac2 = 0;
        punti1 = 0;
        punti2 = 0;

        basket = getIntent().getExtras();
        tekst1 = basket.getString("player1");
        tekst2 = basket.getString("player2");
        igrac1.setText(tekst1);
        igrac2.setText(tekst2);

        eTekst1.setText("" + brojac1);
        eTekst2.setText("" + brojac1);
        puntitekst1.setText("" + punti1);
        puntitekst2.setText("" + punti2);

        upis1 = puntitekst1.getText().toString();
        upis2 = puntitekst2.getText().toString();
    }

    public void postaviVarijable(){
        Button botunplus1 = (Button) findViewById(R.id.bPlus1dva);
        Button botunplus2 = (Button) findViewById(R.id.bPlus2dva);
        Button botundodaj1 = (Button) findViewById(R.id.bDodajDva1);
        Button botundodaj2 = (Button) findViewById(R.id.bDodajDva2);
        Button botunoduzmi1 = (Button) findViewById(R.id.bOduzmiDva1);
        Button botunoduzmi2 = (Button) findViewById(R.id.bOduzmiDva2);
        Button botunispis = (Button) findViewById(R.id.bIspisDva);
        Button botunupisi = (Button) findViewById(R.id.bUpisiDva);
        Button botunload = (Button) findViewById(R.id.bLoadDva);
        igrac1 = (TextView) findViewById(R.id.tvIgrac1);
        igrac2 = (TextView) findViewById(R.id.tvIgrac2);
        puntitekst1 = (TextView) findViewById(R.id.tvPuntiDva1);
        puntitekst2 = (TextView) findViewById(R.id.tvPuntiDva2);
        eTekst1 = (EditText) findViewById(R.id.etDva1);
        eTekst2 = (EditText) findViewById(R.id.etDva2);

        botunplus1.setOnClickListener(this);
        botunplus2.setOnClickListener(this);
        botundodaj1.setOnClickListener(this);
        botundodaj2.setOnClickListener(this);
        botunoduzmi1.setOnClickListener(this);
        botunoduzmi2.setOnClickListener(this);
        botunispis.setOnClickListener(this);
        botunupisi.setOnClickListener(this);
        botunload.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bPlus1dva:
                brojac1++;
                eTekst1.setText("" + brojac1);
                break;
            case R.id.bPlus2dva:
                brojac2++;
                eTekst2.setText("" + brojac2);
                break;
            case R.id.bDodajDva1:
                x = Integer.parseInt(eTekst1.getText().toString());
                punti1 += x;
                puntitekst1.setText("" + punti1);
                brojac1 = 0;
                eTekst1.setText("" + brojac1);
                break;
            case R.id.bDodajDva2:
                x = Integer.parseInt(eTekst2.getText().toString());
                punti2 += x;
                puntitekst2.setText("" + punti2);
                brojac2 = 0;
                eTekst2.setText("" + brojac2);
                break;
            case R.id.bOduzmiDva1:
                x = Integer.parseInt(eTekst1.getText().toString());
                punti1 -= x;
                puntitekst1.setText("" + punti1);
                brojac1 = 0;
                eTekst1.setText("" + brojac1);
                break;
            case R.id.bOduzmiDva2:
                x = Integer.parseInt(eTekst2.getText().toString());
                punti2 -= x;
                puntitekst2.setText("" + punti2);
                brojac2 = 0;
                eTekst2.setText("" + brojac2);
                break;
            case R.id.bUpisiDva:
                upis1 = upis1 + "\n" + puntitekst1.getText().toString();
                upis2 = upis2 + "\n" + puntitekst2.getText().toString();

                sharedPref = getSharedPreferences("save", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("saveIme1", igrac1.getText().toString());
                editor.putString("saveIme2", igrac2.getText().toString());
                editor.putInt("savePunti1", punti1);
                editor.putInt("savePunti2", punti2);
                editor.putString("saveUpis1", upis1);
                editor.putString("saveUpis2", upis2);
                editor.apply();

                Toast.makeText(this, "Bodovi upisani.", Toast.LENGTH_LONG).show();
                break;
            case R.id.bIspisDva:
                basket.putString("ispisdva1", upis1);
                basket.putString("ispisdva2", upis2);
                a = new Intent(GlavniDva.this, IspisDva.class);
                a.putExtras(basket);
                startActivity(a);
                break;
            case R.id.bLoadDva:
                sharedPref = getSharedPreferences("save", Context.MODE_PRIVATE);

                punti1 = sharedPref.getInt("savePunti1", 1);
                punti2 = sharedPref.getInt("savePunti2", 1);
                upis1 = sharedPref.getString("saveUpis1", "Can't load");
                upis2 = sharedPref.getString("saveUpis2", "Can't load");
                igrac1.setText(sharedPref.getString("saveIme1", "Greška1"));
                igrac2.setText(sharedPref.getString("saveIme2", "Greška2"));
                puntitekst1.setText("" + punti1);
                puntitekst2.setText("" + punti2);

                basket.putString("player1", igrac1.getText().toString());
                basket.putString("player2", igrac2.getText().toString());
                break;
        }
    }


}




















