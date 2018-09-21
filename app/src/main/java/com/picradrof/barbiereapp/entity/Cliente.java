package com.picradrof.barbiereapp.entity;

import android.database.Cursor;

import com.picradrof.barbiereapp.businessLogic.exception.exceptionCliente.AlreadyExistingUsernameException;
import com.picradrof.barbiereapp.businessLogic.exception.exceptionCliente.UserNotEnabledException;
import com.picradrof.barbiereapp.businessLogic.exception.exceptionCliente.WrongLoginInfoException;
import com.picradrof.barbiereapp.utility.DBHandler;

import java.io.Serializable;

public class Cliente implements IEntityCliente,Serializable {
    protected String username;
    protected String password;
    protected String nome;
    protected String cognome;
    protected int id;
    protected boolean abilitato;

    /**
     * Costruttore che consente di registrare un nuovo Cliente nel sistema.
     * @param username
     * @param password
     * @param nome
     * @param cognome
     */
    public Cliente(String username, String password, String nome, String cognome) throws AlreadyExistingUsernameException {
        DBHandler db = DBHandler.getInstance();
        db.open();
        long esito = db.registraCliente(username,password,nome,cognome);
        db.close();

        if(esito==-1) {
            throw new AlreadyExistingUsernameException(username+" già presente nel sistema!");
        }
    }

    /**
     * Costruttore che consente di recuperare le info di un Cliente dal sistema.
     * @param username
     * @param password
     */
    public Cliente(String username, String password) throws WrongLoginInfoException,UserNotEnabledException {
        DBHandler db = DBHandler.getInstance();
        db.open();
        Cursor cursor = db.loginCliente(username);
        db.close();

        if (cursor.getCount() != 0)
            if (!password.equals(cursor.getString(1)))
                throw new WrongLoginInfoException("Username o Password errata!");
            else {
                if(cursor.getInt(4)==0)
                    throw new UserNotEnabledException("Utente non abilitato dal barbiere!");
                else {
                    id = cursor.getInt(0);
                    nome = cursor.getString(2);
                    cognome = cursor.getString(3);
                }
            }
        else {
            throw new WrongLoginInfoException("Username o Password errata!");
        }
    }

    public String getUsername() {return username;}
    public String getNome() {return nome;}
    public String getCognome() {return cognome;}
    public int getID() {return id;}
}
