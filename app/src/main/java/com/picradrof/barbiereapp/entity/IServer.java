package com.picradrof.barbiereapp.entity;

import android.database.*;
import java.time.*;

public interface IServer {
    public long registraCliente(String username, String password, String nome, String cognome);
    public Cursor loginCliente(String username) throws SQLException;
    public Cursor verificaDisponibilità(LocalDate data, LocalTime oraInizio, LocalTime oraFine) throws SQLException;
    public int setDisponibilità(LocalDate data, LocalTime oraInizio, LocalTime oraFine,boolean disponibile) throws SQLException;
    public long inserisciPrenotazione(int clienteID, int slotOrarioID);

    //public long effettuaPrenotazione(IEntityCliente cliente, IEntitySlotOrario slotOrario);
    //public long configuraDisponibilita(IEntitySlotOrario slotOrario, boolean disponibile);
    //public Cursor getSlotPerData(LocalDate data, LocalTime oraInizio, LocalTime oraFine) throws SQLException;
}
