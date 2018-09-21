package com.picradrof.barbiereapp.businessLogic.exception.exceptionCliente;

import android.util.Log;

public class AlreadyExistingUsernameException extends Exception {
    public AlreadyExistingUsernameException(String msg) {
        super(msg);
        Log.d("EXCEPTION", msg);
    }
}
