package com.picradrof.barbiereapp.entity;

import com.picradrof.barbiereapp.utility.DBHandler;

public class Prenotazione implements IEntityPrenotazione {
    protected Cliente cliente;
    protected SlotOrario slotOrario;

    public Prenotazione(Cliente cliente, SlotOrario slotOrario) {
        DBHandler db = DBHandler.getInstance();
        db.open();
        //funzione per l'inserimento in db della prenotazione
        db.inserisciPrenotazione(cliente.getUsername(),slotOrario.getData(),slotOrario.getOraInizio(),slotOrario.getOraFine());
        db.close();

        this.cliente = cliente;
        this.slotOrario = slotOrario;
    }
}
