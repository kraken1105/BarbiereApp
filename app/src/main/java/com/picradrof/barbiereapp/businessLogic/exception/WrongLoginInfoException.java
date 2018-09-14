package com.picradrof.barbiereapp.businessLogic.exception;

import android.util.Log;

public class WrongLoginInfoException extends Exception {
    public WrongLoginInfoException(String msg) {
        super(msg);
        Log.d("EXCEPTION", msg);
    }
}
