package com.markor.mivialpha;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;


public class IspisDva extends ActionBarActivity {

    TextView igrac1, igrac2, punti1, punti2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ispis_dva);

        igrac1 = (TextView) findViewById(R.id.tvIspisDvaIgrac1);
        igrac2 = (TextView) findViewById(R.id.tvIspisDvaIgrac2);
        punti1 = (TextView) findViewById(R.id.tvIspisDvaPunti1);
        punti2 = (TextView) findViewById(R.id.tvIspisDvaPunti2);

        Bundle Basket = getIntent().getExtras();
        igrac1.setText(Basket.getString("player1"));
        igrac2.setText(Basket.getString("player2"));
        punti1.setText(Basket.getString("ispisdva1"));
        punti2.setText(Basket.getString("ispisdva2"));
    }


}
