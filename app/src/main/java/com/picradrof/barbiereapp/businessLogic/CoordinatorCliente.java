package com.picradrof.barbiereapp.businessLogic;

import com.picradrof.barbiereapp.entity.*;
import com.picradrof.barbiereapp.businessLogic.exception.*;

public class CoordinatorCliente {

    //**************** Singleton ******************/
    private static CoordinatorCliente instance = null;

    private CoordinatorCliente() {}

    public static CoordinatorCliente getInstance() {
        if(instance == null) {
            instance = new CoordinatorCliente();
        }
        return instance;
    }
    //********************************************/

    public boolean effettuaRegistrazione(String username, String password, String nome, String cognome)
            throws UsernameTooShortException,PasswordTooShortException,AlreadyExistingUsernameException,
                   NameNullException,SurnameNullException {
        /*  Controlli sui dati inseriti dall'utente per registrarsi */
        // Username troppo corto
        if(username.length()<6) throw new UsernameTooShortException("L'username inserito deve contenere almeno 6 caratteri!");
        // Password troppo corta
        if(password.length()<6) throw new PasswordTooShortException("La password inserita deve contenere almeno 6 caratteri!");
        // Nome vuoto
        if(nome.length()<1) throw new NameNullException("Il nome non può essere vuoto!");
        // Cognome vuoto
        if(cognome.length()<1) throw new SurnameNullException("Il cognome non può essere vuoto!");
        // Il costruttore di Cliente verifica anche se l'username è già presente nel sistema
        IEntityCliente cliente = new Cliente(username, password, nome, cognome);

        return true; // utente inserito nel database
    }

    public IEntityCliente login(String username, String password)
            throws UsernameTooShortException,PasswordTooShortException,WrongLoginInfoException,UserNotEnabledException {
        /*  Controlli sui dati inseriti dall'utente per registrarsi */
        // Username troppo corto
        if(username.length()<6) throw new UsernameTooShortException("L'username inserito deve contenere almeno 6 caratteri!");
        // Password troppo corta
        if(password.length()<6) throw new PasswordTooShortException("La password inserita deve contenere almeno 6 caratteri!");

        IEntityCliente cliente = new Cliente(username, password);
        return cliente;
    }
}
