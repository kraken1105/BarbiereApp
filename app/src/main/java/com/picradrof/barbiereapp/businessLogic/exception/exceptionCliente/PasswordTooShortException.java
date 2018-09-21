package com.picradrof.barbiereapp.businessLogic.exception.exceptionCliente;

import android.util.Log;

public class PasswordTooShortException extends Exception {
    public PasswordTooShortException(String msg) {
        super(msg);
        Log.d("EXCEPTION", msg);
    }
}
