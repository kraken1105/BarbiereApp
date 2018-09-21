package com.picradrof.barbiereapp.businessLogic;

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

    boolean effettuaPrenotazione(IEntityCliente cliente, IEntitySlotOrario slotOrario) {


        return false;
    }

}
