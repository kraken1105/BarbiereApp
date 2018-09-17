package com.picradrof.barbiereapp.businessLogic.exception;

import android.util.Log;

public class SurnameNullException extends Exception {
    public SurnameNullException(String msg) {
        super(msg);
        Log.d("EXCEPTION", msg);
    }
}
