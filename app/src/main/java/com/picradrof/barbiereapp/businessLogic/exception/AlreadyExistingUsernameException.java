package com.picradrof.barbiereapp.businessLogic.exception;

import android.util.Log;

public class AlreadyExistingUsernameException extends Exception {
    public AlreadyExistingUsernameException() {}

    public AlreadyExistingUsernameException(String msg) {
        super(msg);
        Log.d("EXCEPTION", msg);
    }
}
