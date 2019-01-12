package com.markor.mivialpha;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Pocetna extends ActionBarActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pocetna);

        postaviVarijable();
    }

    private void postaviVarijable(){
        final Button botundva = (Button) findViewById(R.id.bDva);

        botundva.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bDva:
                Intent a = new Intent(Pocetna.this, IgraciDva.class);
                startActivity(a);
                break;
        }
    }


}
