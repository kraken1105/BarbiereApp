package com.picradrof.barbiereapp.businessLogic.exception;

import android.util.Log;

public class UserNotEnabledException extends Exception {
    public UserNotEnabledException(String msg) {
        super(msg);
        Log.d("EXCEPTION", msg);
    }
}
