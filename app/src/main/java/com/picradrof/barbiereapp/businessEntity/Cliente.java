package com.picradrof.barbiereapp.businessEntity;

import com.picradrof.barbiereapp.businessLogic.exception.*;

public class Cliente implements IEntityCliente  {
    protected String username;
    protected String password;
    protected String nome;
    protected String cognome;

    /**
     * Costruttore che consente di registrare un nuovo Cliente nel sistema.
     * @param username
     * @param password
     * @param nome
     * @param cognome
     */
    public Cliente(String username, String password, String nome, String cognome) throws AlreadyExistingUsernameException {

        // se utente già presente nel database bisogna fare:
        // throw new AlreadyExistingUsernameException(username+" già presente nel database!");
    }

    /**
     * Costruttore che consente di recuperare le info di un Cliente dal sistema.
     * @param username
     * @param password
     */
    public Cliente(String username, String password) throws WrongLoginInfoException,UserNotEnabledException {

        // se username o psw errate bisogna fare:
        // throw new WrongLoginInfoException("Username o Password errate!");

        // se untente non è validato bisogna fare:
        // throw new UserNotEnabledException("Utente non validato!");
    }
}
