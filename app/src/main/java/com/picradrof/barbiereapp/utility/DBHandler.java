package com.picradrof.barbiereapp.utility;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.picradrof.barbiereapp.userClient.LoginActivity;

public class DBHandler {

    //**************** Singleton ******************/
    private static DBHandler instance = null;

    private DBHandler(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    public static DBHandler getInstance(Context ctx) {
        if(instance == null) {
            instance = new DBHandler(ctx);
        }
        return instance;
    }

    public static DBHandler getInstance() {
        return instance;
    }
    //********************************************/

    static final String KEY_RIGAID = "id";
    static final String KEY_NOME = "nome";
    static final String KEY_INDIRIZZO = "indirizzo";
    static final String TAG = "GestioneDB";
    static final String DATABASE_NOME = "TestDB";
    static final String DATABASE_TABELLA = "clienti";
    static final int DATABASE_VERSIONE = 1;

    static final String DATABASE_CREAZIONE =
            "CREATE TABLE clienti (id integer primary key autoincrement, username text unique," +
                    " password text not null, nome text not null, cognome text not null, abilitato boolean not null);";
    static final String DATABASE_POPOLAMENTO =
            "INSERT INTO clienti(username,password,nome,cognome,abilitato) values ('Provolino','wlaprovola','Provola','Affumicata','1');";

    final Context context;
    DatabaseHelper DBHelper;
    SQLiteDatabase db;

    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NOME, null, DATABASE_VERSIONE);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            try {
                db.execSQL(DATABASE_CREAZIONE);
                db.execSQL(DATABASE_POPOLAMENTO);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
            Log.w(DatabaseHelper.class.getName(),"Aggiornamento database dalla versione " + oldVersion + " alla "
                    + newVersion + ". I dati esistenti verranno eliminati.");
            db.execSQL("DROP TABLE IF EXISTS clienti");
            onCreate(db);
        }

    }


    public DBHandler open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }


    public void close()
    {
        DBHelper.close();
    }


    public long inserisciCliente(String username, String password, String nome, String cognome)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put("username", username);
        initialValues.put("password", password);
        initialValues.put("nome", nome);
        initialValues.put("cognome", cognome);
        initialValues.put("abilitato", false);
        return db.insert("clienti", null, initialValues);
    }


    public boolean cancellaCliente(long rigaId)
    {
        return db.delete(DATABASE_TABELLA, KEY_RIGAID + "=" + rigaId, null) > 0;
    }


    public Cursor ottieniTuttiClienti()
    {
        return db.query(DATABASE_TABELLA, new String[] {KEY_RIGAID, KEY_NOME, KEY_INDIRIZZO}, null, null, null, null, null);
    }


    public Cursor ottieniCliente(long rigaId) throws SQLException
    {
        Cursor mCursore = db.query(true, DATABASE_TABELLA, new String[] {KEY_RIGAID, KEY_NOME, KEY_INDIRIZZO}, KEY_RIGAID + "=" + rigaId, null, null, null, null, null);
        if (mCursore != null) {
            mCursore.moveToFirst();
        }
        return mCursore;
    }


    public boolean aggiornaCliente(long rigaId, String name, String email)
    {
        ContentValues args = new ContentValues();
        args.put(KEY_NOME, name);
        args.put(KEY_INDIRIZZO, email);
        return db.update(DATABASE_TABELLA, args, KEY_RIGAID + "=" + rigaId, null) > 0;
    }

}
