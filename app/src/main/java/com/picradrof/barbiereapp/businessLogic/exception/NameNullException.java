package com.picradrof.barbiereapp.businessLogic.exception;

import android.util.Log;

public class NameNullException extends Exception {
    public NameNullException(String msg) {
        super(msg);
        Log.d("EXCEPTION", msg);
    }
}
