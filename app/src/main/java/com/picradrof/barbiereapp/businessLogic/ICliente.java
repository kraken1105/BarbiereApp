package com.picradrof.barbiereapp.businessLogic;

import com.picradrof.barbiereapp.businessLogic.exception.exceptionCliente.*;
import com.picradrof.barbiereapp.businessLogic.exception.exceptionSlotOrario.NotAvailableDateException;
import com.picradrof.barbiereapp.entity.*;

import java.time.LocalDate;
import java.util.ArrayList;

public interface ICliente {
    boolean effettuaRegistrazione(String username, String password, String nome, String cognome)
            throws UsernameTooShortException,PasswordTooShortException,AlreadyExistingUsernameException,
            NameNullException,SurnameNullException;
    IEntityCliente login(String username, String password)
            throws UsernameTooShortException,PasswordTooShortException, WrongLoginInfoException,
            UserNotEnabledException;
    IEntityPrenotazione effettuaPrenotazione(IEntityCliente cliente, IEntitySlotOrario slotOrario)
            throws NotAvailableDateException;
    ArrayList<IEntitySlotOrario> verificaDisponibilita(LocalDate data)
            throws NotAvailableDateException;
}
