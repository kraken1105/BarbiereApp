package com.picradrof.barbiereapp.entity;

import java.time.LocalTime;

public interface IEntitySlotOrario {
    boolean setDisponibilita(boolean disponibile);
    public LocalTime getOraInizio();
    public LocalTime getOraFine();
}
