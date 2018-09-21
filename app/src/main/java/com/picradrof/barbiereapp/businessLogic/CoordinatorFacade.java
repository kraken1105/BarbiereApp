package com.picradrof.barbiereapp.businessLogic;

import com.picradrof.barbiereapp.entity.IEntityCliente;
import com.picradrof.barbiereapp.businessLogic.exception.*;
import com.picradrof.barbiereapp.entity.IEntitySlotOrario;

import java.time.LocalDate;
import java.util.ArrayList;

public class CoordinatorFacade implements ICliente {

    //**************** Singleton ******************/
    private static CoordinatorFacade instance = null;

    private CoordinatorFacade() {}

    public static CoordinatorFacade getInstance() {
        if(instance == null) {
            instance = new CoordinatorFacade();
        }
        return instance;
    }
    //********************************************/

    @Override
    public boolean effettuaRegistrazione(String username, String password, String nome, String cognome)
            throws UsernameTooShortException,PasswordTooShortException,AlreadyExistingUsernameException,
                   NameNullException,SurnameNullException {
        CoordinatorCliente corCliente = CoordinatorCliente.getInstance();
        return corCliente.effettuaRegistrazione(username, password, nome, cognome);
    }

    @Override
    public IEntityCliente login(String username, String password)
            throws UsernameTooShortException,PasswordTooShortException,WrongLoginInfoException,
                   UserNotEnabledException {
        CoordinatorCliente corCliente = CoordinatorCliente.getInstance();
        return corCliente.login(username, password);
    }

    boolean effettuaPrenotazione(IEntityCliente cliente, IEntitySlotOrario slotOrario) {


        return false;
    }

    ArrayList<IEntitySlotOrario> verificaDisponibilita(LocalDate data) {

        CoordinatorSlotOrario corSlotOrario = CoordinatorSlotOrario.getInstance();

        return corSlotOrario.verificaDisponibilita(data);
    }
}
