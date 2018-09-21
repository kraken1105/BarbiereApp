package com.picradrof.barbiereapp.businessLogic;

import com.picradrof.barbiereapp.entity.IEntitySlotOrario;
import com.picradrof.barbiereapp.entity.SlotOrario;

import java.time.LocalDate;
import java.util.ArrayList;

public class CoordinatorSlotOrario {

    //**************** Singleton ******************/
    private static CoordinatorSlotOrario instance = null;

    private CoordinatorSlotOrario() {}

    public static CoordinatorSlotOrario getInstance() {
        if(instance == null) {
            instance = new CoordinatorSlotOrario();
        }
        return instance;
    }
    //********************************************/

    ArrayList<IEntitySlotOrario> verificaDisponibilita(LocalDate data) {

        //devo restituire la lista di tutti gli slot relativi a data

        return new ArrayList<IEntitySlotOrario>();
    }

    boolean setDisponibilita(IEntitySlotOrario slotOrario, boolean disponibile) {
        return slotOrario.setDisponibilita(disponibile);
    }
}
