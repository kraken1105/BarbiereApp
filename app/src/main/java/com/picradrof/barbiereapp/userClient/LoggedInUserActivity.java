package com.picradrof.barbiereapp.userClient;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.picradrof.barbiereapp.R;
import com.picradrof.barbiereapp.entity.Cliente;

public class LoggedInUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in_user);

        // Recupero i parametri passati da LoginActivity
        Intent i = getIntent();
        Cliente cliente = (Cliente) i.getSerializableExtra("clienteLoggato");
        Log.d("LOGGEDINUSER", "LoggedInUserActivity: ottenuto il cliente "+cliente.getNome()+" "+cliente.getCognome());

        TextView text = (TextView) findViewById(R.id.provatext);
        text.setText("Benvenuto "+cliente.getNome()+" "+cliente.getCognome());

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
