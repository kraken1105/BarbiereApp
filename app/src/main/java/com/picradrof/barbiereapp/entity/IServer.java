package com.picradrof.barbiereapp.entity;

import android.database.*;

public interface IServer {
    public long registraCliente(String username, String password, String nome, String cognome);
    public Cursor loginCliente(String username) throws SQLException;
}
