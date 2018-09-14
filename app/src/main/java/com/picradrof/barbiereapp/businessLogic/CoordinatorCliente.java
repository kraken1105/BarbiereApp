package com.picradrof.barbiereapp.businessLogic;

import com.picradrof.barbiereapp.businessEntity.*;
import com.picradrof.barbiereapp.businessLogic.exception.*;

public class CoordinatorCliente implements ICliente {

    //**************** Singleton ******************/
    private static CoordinatorCliente instance = null;

    private CoordinatorCliente() {}

    protected static CoordinatorCliente getInstance() {
        return instance;
    }
    //********************************************/

    @Override
    public boolean effettuaRegistrazione(String username, String password, String nome, String cognome)
            throws UsernameTooShortException,PasswordTooShortException,AlreadyExistingUsernameException {
        /*  Controlli sui dati inseriti dall'utente per registrarsi */
        // Username troppo corto
        if(username.length()<6) throw new UsernameTooShortException("L'username inserito deve contenere almeno 6 caratteri!");
        // Password troppo corta
        if(password.length()<6) throw new PasswordTooShortException("La password inserita deve contenere almeno 6 caratteri!");
        // Il costruttore di Cliente verifica anche se l'username è già presente nel sistema
        IEntityCliente cliente = new Cliente(username, password, nome, cognome);

        return true; // utente inserito nel database
    }

    @Override
    public IEntityCliente login(String username, String password)
            throws WrongLoginInfoException,UserNotEnabledException {

        IEntityCliente cliente = new Cliente(username, password);
        return cliente;
    }
}
