package com.picradrof.barbiereapp.entity;

import android.database.Cursor;
import android.util.Log;

import com.picradrof.barbiereapp.businessLogic.exception.exceptionSlotOrario.NotAvailableSlotOrarioException;
import com.picradrof.barbiereapp.utility.DBHandler;

import java.time.*;

public class SlotOrario implements IEntitySlotOrario {
    protected int id;
    protected LocalDate data;
    protected LocalTime oraInizio;
    protected LocalTime oraFine;
    protected boolean disponibile;

    public SlotOrario(LocalDate data, LocalTime oraInizio, LocalTime oraFine) {

        DBHandler db = DBHandler.getInstance();
        db.open();
        Cursor cursor = db.verificaDisponibilità(data,oraInizio,oraFine);
        db.close();

        this.data = data;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
        this.id = cursor.getInt(0);
        if(cursor.getInt(1)==1) this.disponibile=true;
        else this.disponibile=false;
    }

    @Override
    public boolean setDisponibilita(boolean disponibile) {

        DBHandler db = DBHandler.getInstance();
        db.open();
        if(db.setDisponibilità(this.data,this.oraInizio,this.oraFine,disponibile)==0)
            return false;
        db.close();

        return true;
    }

    public LocalDate getData(){return this.data;}

    @Override
    public LocalTime getOraInizio(){return this.oraInizio;}

    @Override
    public LocalTime getOraFine(){return this.oraFine;}

    public int getID() {return id;}
}
