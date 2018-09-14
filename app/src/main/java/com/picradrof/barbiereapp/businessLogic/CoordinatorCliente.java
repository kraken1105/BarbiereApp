package com.picradrof.barbiereapp.businessLogic;

import com.picradrof.barbiereapp.businessLogic.exception.AlreadyExistingUsernameException;
import com.picradrof.barbiereapp.businessEntity.Cliente;

public class CoordinatorCliente implements ICliente {

    //**************** Singleton ******************/
    private static CoordinatorCliente instance = null;

    private CoordinatorCliente() {}

    protected static CoordinatorCliente getInstance() {
        return instance;
    }
    //********************************************/

    @Override
    public boolean effettuaRegistrazione(String username, String password, String nome, String cognome) {
        /*  Chi fa i controlli sui parametri?
            Li facciamo qua (come nel sequence diagram), o li facciamo nell'activity?
         */

        try {
            Cliente cliente = new Cliente(username, password, nome, cognome);
        } catch (AlreadyExistingUsernameException ex) {
            return false;
        }

        return true;
    }

    @Override
    public boolean login(String username, String password) {
        return false;
    }
}
