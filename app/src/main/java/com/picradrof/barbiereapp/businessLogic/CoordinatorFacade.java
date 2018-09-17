package com.picradrof.barbiereapp.businessLogic;

import com.picradrof.barbiereapp.businessEntity.IEntityCliente;
import com.picradrof.barbiereapp.businessLogic.exception.*;

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
        ICliente corCliente = CoordinatorCliente.getInstance();
        return corCliente.effettuaRegistrazione(username, password, nome, cognome);
    }

    @Override
    public IEntityCliente login(String username, String password)
            throws WrongLoginInfoException,UserNotEnabledException {
        ICliente corCliente = CoordinatorCliente.getInstance();
        return corCliente.login(username, password);
    }
}
