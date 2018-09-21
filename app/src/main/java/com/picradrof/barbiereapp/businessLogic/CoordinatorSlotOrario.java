package com.picradrof.barbiereapp.businessLogic;

import android.annotation.TargetApi;

import com.picradrof.barbiereapp.businessLogic.exception.exceptionSlotOrario.NotAvailableDateException;
import com.picradrof.barbiereapp.entity.IEntitySlotOrario;
import com.picradrof.barbiereapp.entity.SlotOrario;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class CoordinatorSlotOrario {

    //**************** Singleton ******************/
    private static CoordinatorSlotOrario instance = null;

    private CoordinatorSlotOrario() {}

    public static CoordinatorSlotOrario getInstance() {
        if(instance == null) {
            instance = new CoordinatorSlotOrario();
        }
        return instance;
    }
    //********************************************/

    @TargetApi(26)
    ArrayList<IEntitySlotOrario> verificaDisponibilita(LocalDate data)
            throws NotAvailableDateException {
        LocalTime oraApertura = LocalTime.of(8, 00);
        LocalTime oraChiusura = LocalTime.of(20, 00);
        ArrayList<IEntitySlotOrario> listaSlotPerData = new ArrayList<IEntitySlotOrario>();

        /*  Controlli sui dati inseriti dall'utente */
        // La data non deve essere passata
        if(data.isBefore(LocalDate.now())) throw new NotAvailableDateException("Inserire una data futura!");
        // La data non deve essere troppo lontana
        if(data.isAfter(LocalDate.now().plusDays(30))) throw new NotAvailableDateException("Inserire una data entro 30 giorni!");
        // La data non deve essere relativa ad un giorno di chiusura (lunedì)
        if(data.getDayOfWeek().equals(DayOfWeek.MONDAY)) throw new NotAvailableDateException("Lunedì è giorno di chiusura!");

        // Preleva tutti gli slot relativi alla data richiesta
        while (!oraApertura.equals(oraChiusura)) {
            listaSlotPerData.add(new SlotOrario(data, oraApertura, oraApertura.plusMinutes(30)));
            oraApertura = oraApertura.plusMinutes(30);
        }

        return listaSlotPerData;
    }

    boolean setDisponibilita(IEntitySlotOrario slotOrario, boolean disponibile) {
        return slotOrario.setDisponibilita(disponibile);
    }
}
