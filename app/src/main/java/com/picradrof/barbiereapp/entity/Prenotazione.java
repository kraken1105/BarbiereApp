package com.picradrof.barbiereapp.entity;

import com.picradrof.barbiereapp.utility.DBHandler;

public class Prenotazione implements IEntityPrenotazione {
    protected IEntityCliente cliente;
    protected IEntitySlotOrario slotOrario;

    public Prenotazione(IEntityCliente cliente, IEntitySlotOrario slotOrario) {
        DBHandler db = DBHandler.getInstance();
        db.open();
        //funzione per l'inserimento in db della prenotazione

        db.close();

        this.cliente = cliente;
        this.slotOrario = slotOrario;
    }
}
