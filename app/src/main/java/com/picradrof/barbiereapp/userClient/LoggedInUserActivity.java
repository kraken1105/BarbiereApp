package com.picradrof.barbiereapp.userClient;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.picradrof.barbiereapp.R;
import com.picradrof.barbiereapp.businessLogic.CoordinatorFacade;
import com.picradrof.barbiereapp.businessLogic.ICliente;
import com.picradrof.barbiereapp.entity.Cliente;
import com.picradrof.barbiereapp.entity.IEntityPrenotazione;
import com.picradrof.barbiereapp.entity.SlotOrario;

import java.time.LocalDate;
import java.time.LocalTime;

public class LoggedInUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in_user);

        final ICliente coordinatore = CoordinatorFacade.getInstance();

        // Recupero i parametri passati da LoginActivity
        Intent i = getIntent();
        final Cliente cliente = (Cliente) i.getSerializableExtra("clienteLoggato");
        Log.d("LOGGEDINUSER", "LoggedInUserActivity: ottenuto il cliente "+cliente.getNome()+" "+cliente.getCognome());

        TextView text = (TextView) findViewById(R.id.provatext);
        text.setText("Benvenuto "+cliente.getNome()+" "+cliente.getCognome());

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            @TargetApi(26)
            public void onClick(View view) {
                Intent bookInt = new Intent(LoggedInUserActivity.this,BookingActivity.class);
                bookInt.putExtra("clienteLoggato", (Cliente) cliente);
                startActivity(bookInt);
                /*
                SlotOrario s=new SlotOrario(LocalDate.of(2018,10,24), LocalTime.of(10,30),LocalTime.of(11,00));
                try {
                    IEntityPrenotazione ie=coordinatore.effettuaPrenotazione(cliente, s);
                    Toast.makeText(LoggedInUserActivity.this, "esito positivo", Toast.LENGTH_LONG).show();
                } catch(Exception e){ Toast.makeText(LoggedInUserActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();}
            */}
        });
    }

}
