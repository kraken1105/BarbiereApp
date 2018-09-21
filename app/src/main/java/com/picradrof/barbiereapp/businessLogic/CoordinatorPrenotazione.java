package com.picradrof.barbiereapp.businessLogic;

import com.picradrof.barbiereapp.businessLogic.exception.exceptionSlotOrario.NotAvailableDateException;
import com.picradrof.barbiereapp.entity.*;

public class CoordinatorPrenotazione {

    //**************** Singleton ******************/
    private static CoordinatorPrenotazione instance = null;

    private CoordinatorPrenotazione() {}

    public static CoordinatorPrenotazione getInstance() {
        if(instance == null) {
            instance = new CoordinatorPrenotazione();
        }
        return instance;
    }
    //********************************************/

    IEntityPrenotazione effettuaPrenotazione(IEntityCliente cliente, IEntitySlotOrario slotOrario)
            throws NotAvailableDateException {
        CoordinatorSlotOrario corSlotOrario = CoordinatorSlotOrario.getInstance();

        if (!corSlotOrario.setDisponibilita(slotOrario, false))
            throw new NotAvailableDateException("Fascia oraria appena prenotata da un altro cliente!");

        return new Prenotazione(cliente, slotOrario);
    }

}
