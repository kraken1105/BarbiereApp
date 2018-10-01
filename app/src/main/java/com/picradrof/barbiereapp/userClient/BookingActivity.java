package com.picradrof.barbiereapp.userClient;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.picradrof.barbiereapp.R;

import java.util.Calendar;

public class BookingActivity extends AppCompatActivity {

    Button btn;
    protected int year_x,month_x,day_x;

    private DatePickerDialog.OnDateSetListener dpl = new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker view, int year, int month, int day){
            year_x = year;
            month_x = month;
            day_x = day;
            //da qui aggiorniamo gli slot
            Toast.makeText(BookingActivity.this, day_x + "/" + month_x + "/" + day_x, Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        final Calendar cal = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);
    }

    protected void showDialogByButton(){
        btn = (Button) findViewById(R.id.date_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(0);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id){
        if (id==0) return new DatePickerDialog(this,dpl,year_x,month_x,day_x);
        return null;
    }
}
