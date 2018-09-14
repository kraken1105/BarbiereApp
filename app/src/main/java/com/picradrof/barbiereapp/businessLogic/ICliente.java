package com.picradrof.barbiereapp.businessLogic;

import com.picradrof.barbiereapp.businessEntity.IEntityCliente;
import com.picradrof.barbiereapp.businessLogic.exception.*;

public interface ICliente {
    boolean effettuaRegistrazione(String username, String password, String nome, String cognome)
            throws UsernameTooShortException,PasswordTooShortException,AlreadyExistingUsernameException;
    IEntityCliente login(String username, String password)
            throws WrongLoginInfoException,UserNotEnabledException;
}
