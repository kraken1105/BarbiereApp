package com.picradrof.barbiereapp.businessLogic.exception.exceptionCliente;

import android.util.Log;

public class UsernameTooShortException extends Exception {
    public UsernameTooShortException(String msg) {
        super(msg);
        Log.d("EXCEPTION", msg);
    }
}
