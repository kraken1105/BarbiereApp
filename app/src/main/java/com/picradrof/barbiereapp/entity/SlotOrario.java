package com.picradrof.barbiereapp.entity;

import com.picradrof.barbiereapp.utility.DBHandler;

import java.time.*;

public class SlotOrario implements IEntitySlotOrario {
    protected LocalDate data;
    protected LocalTime oraInizio;
    protected LocalTime oraFine;
    protected boolean disponibile;


    public SlotOrario(LocalDate data, LocalTime oraInizio, LocalTime oraFine) {

        DBHandler db = DBHandler.getInstance();
        db.open();
        // prelevo il campo disponibile da db
        int disponibile = db.verificaDisponibilità(data,oraInizio,oraFine).getInt(1);
        db.close();

        this.data = data;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
        if(disponibile==1) this.disponibile=true;
                            else this.disponibile=false;
    }


    @Override
    public boolean setDisponibilita(boolean disponibile) {

        // provo ad inserire in db, potrei avere errore se un altro cliente ha già prenotato.
        // restituisco l'esito con il return (oppure possiamo fare eccezione)

        DBHandler db = DBHandler.getInstance();
        db.open();
        //funzione per l'inserimento in db della prenotazione
        db.setDisponibilità(this.data,this.oraInizio,this.oraFine,disponibile);
        db.close();



        return false;
    }

    public LocalDate getData(){return this.data;}
    public LocalTime getOraInizio(){return this.oraInizio;}
    public LocalTime getOraFine(){return this.oraFine;}
}
