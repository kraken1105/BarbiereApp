package com.picradrof.barbiereapp.businessLogic;

public interface ICliente {
    boolean effettuaRegistrazione(String username, String password, String nome, String cognome);
    boolean login(String username, String password);
}
