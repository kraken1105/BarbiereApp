package com.picradrof.barbiereapp.businessEntity;

import android.content.*;
import android.database.Cursor;
import android.util.Log;

import com.picradrof.barbiereapp.businessLogic.exception.*;
import com.picradrof.barbiereapp.utility.DBHandler;

import java.io.Serializable;

public class Cliente implements IEntityCliente,Serializable {
    protected String username;
    protected String password;
    protected String nome;
    protected String cognome;
    protected int ID;
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
        long esito = db.inserisciCliente(username,password,nome,cognome);
        if(esito==-1) {
            throw new AlreadyExistingUsernameException(username+" già presente nel sistema!");
        }
        db.close();
    }

    /**
     * Costruttore che consente di recuperare le info di un Cliente dal sistema.
     * @param username
     * @param password
     */
    public Cliente(String username, String password) throws WrongLoginInfoException,UserNotEnabledException {
        DBHandler db = DBHandler.getInstance();
        db.open();
        /*Log.d("MYQUERY","Prima");
        Cursor cursor = db.ottieniCliente(username);
        Log.d("MYQUERY",String.valueOf(cursor.getInt(1))+" con nome "+cursor.getString(2));
        Log.d("MYQUERY","dopo");*/

        nome = "Nicola";
        cognome = "Esposito";

        // se username o psw errate bisogna fare:
        // throw new WrongLoginInfoException("Username o Password errate!");

        // se untente non è validato bisogna fare:
        // throw new UserNotEnabledException("Utente non validato!");
        db.close();
    }

    public String getUsername() {return username;}
    public String getNome() {return nome;}
    public String getCognome() {return cognome;}
    public int getID() {return ID;}
}
