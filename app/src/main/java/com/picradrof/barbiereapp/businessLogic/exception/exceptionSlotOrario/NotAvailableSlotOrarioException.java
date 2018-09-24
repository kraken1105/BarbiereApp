package com.picradrof.barbiereapp.businessLogic.exception.exceptionSlotOrario;

import android.util.Log;

public class NotAvailableSlotOrarioException extends Exception {
    public NotAvailableSlotOrarioException(String msg) {
        super(msg);
        Log.d("EXCEPTION", msg);
    }
}
