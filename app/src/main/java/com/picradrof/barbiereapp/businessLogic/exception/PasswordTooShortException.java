package com.picradrof.barbiereapp.businessLogic.exception;

import android.util.Log;

public class PasswordTooShortException extends Exception {
    public PasswordTooShortException() {}

    public PasswordTooShortException(String msg) {
        super(msg);
        Log.d("EXCEPTION", msg);
    }
}
