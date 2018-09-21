package com.picradrof.barbiereapp.businessLogic.exception.exceptionSlotOrario;

import android.util.Log;

public class NotAvailableDateException extends Exception {
    public NotAvailableDateException(String msg) {
        super(msg);
        Log.d("EXCEPTION", msg);
    }
}
