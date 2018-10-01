package com.picradrof.barbiereapp.userClient;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.picradrof.barbiereapp.R;
import com.picradrof.barbiereapp.businessLogic.CoordinatorFacade;
import com.picradrof.barbiereapp.businessLogic.exception.exceptionSlotOrario.NotAvailableDateException;
import com.picradrof.barbiereapp.entity.Cliente;
import com.picradrof.barbiereapp.entity.IEntityPrenotazione;
import com.picradrof.barbiereapp.entity.IEntitySlotOrario;
import com.picradrof.barbiereapp.utility.ListSlotAdapter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class BookingActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    Button btn;
    CoordinatorFacade cor = CoordinatorFacade.getInstance();
    Cliente cliente;
    protected int year_x, month_x, day_x;

    @TargetApi(26)
    private DatePickerDialog.OnDateSetListener dpl = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            year_x = year;
            month_x = month + 1;
            day_x = day;
            LocalDate data = LocalDate.of(year_x, month_x, day_x);
            aggiornaSlot(data);
        }
    };

    @Override
    @TargetApi(26)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        // Recupero i parametri passati da LoginActivity
        Intent i = getIntent();
        cliente = (Cliente) i.getSerializableExtra("clienteLoggato");

        final Calendar cal = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);

        LocalDate data = LocalDate.of(year_x, month_x + 1, day_x);
        String dateInIta = data.format(DateTimeFormatter.ofPattern("EEEE d MMMM yyyy", Locale.ITALIAN));
        aggiornaSlot(data);

        btn = (Button) findViewById(R.id.date_button);
        btn.setText(dateInIta);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(0);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == 0) return new DatePickerDialog(this, dpl, year_x, month_x, day_x);
        return null;
    }

    @TargetApi(26)
    protected void aggiornaSlot(LocalDate data) {
        String dateInIta = data.format(DateTimeFormatter.ofPattern("EEEE d MMMM yyyy", Locale.ITALIAN));
        btn.setText(dateInIta);

        try {
            ArrayList<IEntitySlotOrario> listaSlot = cor.verificaDisponibilita(data);

            ListView listView = (ListView) findViewById(R.id.list_view);

            ListSlotAdapter listAdapter = new ListSlotAdapter(this, listaSlot);
            listView.setAdapter(listAdapter);
            listView.setOnItemClickListener(this);
        } catch (NotAvailableDateException e) {
            Toast.makeText(BookingActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        IEntitySlotOrario slotOrario = (IEntitySlotOrario) parent.getAdapter().getItem(position);

        try {
            IEntityPrenotazione ie = cor.effettuaPrenotazione(cliente, slotOrario);
            Toast.makeText(BookingActivity.this, "esito positivo", Toast.LENGTH_LONG).show();
        } catch(Exception e){ Toast.makeText(BookingActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();}

    }

}
