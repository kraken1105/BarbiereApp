package com.picradrof.barbiereapp.businessLogic;

import com.picradrof.barbiereapp.businessLogic.exception.exceptionCliente.AlreadyExistingUsernameException;
import com.picradrof.barbiereapp.businessLogic.exception.exceptionCliente.NameNullException;
import com.picradrof.barbiereapp.businessLogic.exception.exceptionCliente.PasswordTooShortException;
import com.picradrof.barbiereapp.businessLogic.exception.exceptionCliente.SurnameNullException;
import com.picradrof.barbiereapp.businessLogic.exception.exceptionCliente.UserNotEnabledException;
import com.picradrof.barbiereapp.businessLogic.exception.exceptionCliente.UsernameTooShortException;
import com.picradrof.barbiereapp.businessLogic.exception.exceptionCliente.WrongLoginInfoException;
import com.picradrof.barbiereapp.businessLogic.exception.exceptionSlotOrario.NotAvailableDateException;
import com.picradrof.barbiereapp.entity.IEntityCliente;
import com.picradrof.barbiereapp.entity.IEntityPrenotazione;
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

    @Override
    public IEntityPrenotazione effettuaPrenotazione(IEntityCliente cliente, IEntitySlotOrario slotOrario)
            throws NotAvailableDateException {
        CoordinatorPrenotazione corPrenotazione = CoordinatorPrenotazione.getInstance();
        return corPrenotazione.effettuaPrenotazione(cliente, slotOrario);
    }

    @Override
    public ArrayList<IEntitySlotOrario> verificaDisponibilita(LocalDate data)
            throws NotAvailableDateException {
        CoordinatorSlotOrario corSlotOrario = CoordinatorSlotOrario.getInstance();
        return corSlotOrario.verificaDisponibilita(data);
    }
}
