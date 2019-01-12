package com.markor.mivialpha;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class IgraciDva extends ActionBarActivity {

    EditText tekstprvi, tekstdrugi;
    Button botnastavi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_igraci_dva);

        tekstprvi = (EditText) findViewById(R.id.etPrvi);
        tekstdrugi = (EditText) findViewById(R.id.etDrugi);
        botnastavi = (Button) findViewById(R.id.bNastavi);

        botnastavi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String igrac1 = tekstprvi.getText().toString();
                String igrac2 = tekstdrugi.getText().toString();

                Bundle basket = new Bundle();
                basket.putString("player1", igrac1);
                basket.putString("player2", igrac2);

                Intent a = new Intent(IgraciDva.this, GlavniDva.class);
                a.putExtras(basket);
                startActivity(a);
            }
        });
    }


}
