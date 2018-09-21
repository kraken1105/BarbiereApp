package com.picradrof.barbiereapp.entity;

import android.database.*;
import java.time.*;

public interface IServer {
    public long registraCliente(String username, String password, String nome, String cognome);
    public Cursor loginCliente(String username) throws SQLException;

    //public long effettuaPrenotazione(IEntityCliente cliente, IEntitySlotOrario slotOrario);
    //public long configuraDisponibilita(IEntitySlotOrario slotOrario, boolean disponibile);
    //public Cursor getSlotPerData(LocalDate data, LocalTime oraInizio, LocalTime oraFine) throws SQLException;
}
