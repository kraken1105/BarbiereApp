package com.picradrof.barbiereapp.entity;

import com.picradrof.barbiereapp.utility.DBHandler;

import java.time.*;

public class SlotOrario implements IEntitySlotOrario {
    protected LocalDate data;
    protected LocalTime oraInizio;
    protected LocalTime oraFine;
    protected boolean disponibile;


    SlotOrario(LocalDate data, LocalTime oraInizio, LocalTime oraFine) {

        DBHandler db = DBHandler.getInstance();
        db.open();
        // prelevo il campo disponibile da db

        db.close();

        this.data = data;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
    }


    @Override
    public boolean setDisponibilita(boolean disponibile) {

        // provo ad inserire in db, potrei avere errore se un altro cliente ha già prenotato.
        // restituisco l'esito con il return (oppure possiamo fare eccezione)

        DBHandler db = DBHandler.getInstance();
        db.open();
        //funzione per l'inserimento in db della prenotazione

        db.close();



        return false;
    }
}
