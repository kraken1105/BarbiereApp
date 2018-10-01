package com.picradrof.barbiereapp.utility;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.picradrof.barbiereapp.entity.IServer;
import com.picradrof.barbiereapp.userClient.LoginActivity;

import java.time.LocalDate;
import java.time.LocalTime;

public class DBHandler implements IServer {

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

    // Stringhe per la creazione delle tabelle nel database
    static final String DATABASE_CREAZIONE =
            "CREATE TABLE clienti (id integer primary key autoincrement, username text unique," +
                    " password text not null, nome text not null, cognome text not null, abilitato boolean not null);";
    static final String DATABASE_CREAZIONE2 =
            "CREATE TABLE prenotazioni (id integer primary key autoincrement, cliente integer not null," +
                    " slotOrario integer not null, CONSTRAINT prenotazione_specifica unique(cliente,slotOrario));";
    static final String DATABASE_CREAZIONE3 =
            "CREATE TABLE slotOrari (id integer primary key autoincrement,data date not null," +
                    " oraInizio time not null, oraFine time not null, disponibile boolean not null, CONSTRAINT slot_specifico unique(data,oraInizio,oraFine));";

    // Stringhe per il popolamento delle tabelle nel database
    static final String DATABASE_POPOLAMENTO_CLIENTI =
            "INSERT INTO clienti(username,password,nome,cognome,abilitato) values ('Provolino','wlaprovola','Provola','Affumicata','1');";
    static final String DATABASE_POPOLAMENTO_PRENOTAZIONI =
            "INSERT INTO prenotazioni(cliente,slotOrario) values ('1','1');";
    static final String DATABASE_POPOLAMENTO_SLOTORARI1 =
            "INSERT INTO slotOrari(data,oraInizio,oraFine,disponibile) values ('2018-10-24','09:30:00','10:00:00','0') ; ";
    static final String DATABASE_POPOLAMENTO_SLOTORARI2 =
            "INSERT INTO slotOrari(data,oraInizio,oraFine,disponibile) values ('2018-10-24','10:30:00','11:00:00','1') ;" ;
    static final String DATABASE_POPOLAMENTO_SLOTORARI3 =
            "INSERT INTO slotOrari(data,oraInizio,oraFine,disponibile) values ('2018-10-25','8:00:00','08:30:00','1') ;" ;
    static final String DATABASE_POPOLAMENTO_SLOTORARI4 =
            "INSERT INTO slotOrari(data,oraInizio,oraFine,disponibile) values ('2018-10-25','08:30:00','09:00:00','1') ;" ;
    static final String DATABASE_POPOLAMENTO_SLOTORARI5 =
            "INSERT INTO slotOrari(data,oraInizio,oraFine,disponibile) values ('2018-10-25','09:00:00','09:30:00','1') ;" ;
    static final String DATABASE_POPOLAMENTO_SLOTORARI6 =
            "INSERT INTO slotOrari(data,oraInizio,oraFine,disponibile) values ('2018-10-25','09:30:00','10:00:00','1') ;" ;
    static final String DATABASE_POPOLAMENTO_SLOTORARI7 =
            "INSERT INTO slotOrari(data,oraInizio,oraFine,disponibile) values ('2018-10-25','10:00:00','10:30:00','1') ;" ;
    static final String DATABASE_POPOLAMENTO_SLOTORARI8 =
            "INSERT INTO slotOrari(data,oraInizio,oraFine,disponibile) values ('2018-10-25','10:30:00','11:00:00','1') ;" ;
    static final String DATABASE_POPOLAMENTO_SLOTORARI9 =
            "INSERT INTO slotOrari(data,oraInizio,oraFine,disponibile) values ('2018-10-25','11:00:00','11:30:00','1') ;" ;
    static final String DATABASE_POPOLAMENTO_SLOTORARI10 =
            "INSERT INTO slotOrari(data,oraInizio,oraFine,disponibile) values ('2018-10-25','11:30:00','12:00:00','1') ;" ;
    static final String DATABASE_POPOLAMENTO_SLOTORARI11 =
            "INSERT INTO slotOrari(data,oraInizio,oraFine,disponibile) values ('2018-10-25','12:00:00','12:30:00','1') ;" ;

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
                db.execSQL(DATABASE_CREAZIONE2);
                db.execSQL(DATABASE_CREAZIONE3);
                db.execSQL(DATABASE_POPOLAMENTO_CLIENTI);
                db.execSQL(DATABASE_POPOLAMENTO_PRENOTAZIONI);
                db.execSQL(DATABASE_POPOLAMENTO_SLOTORARI1);
                db.execSQL(DATABASE_POPOLAMENTO_SLOTORARI2);
                db.execSQL(DATABASE_POPOLAMENTO_SLOTORARI3);
                db.execSQL(DATABASE_POPOLAMENTO_SLOTORARI4);
                db.execSQL(DATABASE_POPOLAMENTO_SLOTORARI5);
                db.execSQL(DATABASE_POPOLAMENTO_SLOTORARI6);
                db.execSQL(DATABASE_POPOLAMENTO_SLOTORARI7);
                db.execSQL(DATABASE_POPOLAMENTO_SLOTORARI8);
                db.execSQL(DATABASE_POPOLAMENTO_SLOTORARI9);
                db.execSQL(DATABASE_POPOLAMENTO_SLOTORARI10);
                db.execSQL(DATABASE_POPOLAMENTO_SLOTORARI11);
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
            db.execSQL("DROP TABLE IF EXISTS prenotazioni");
            db.execSQL("DROP TABLE IF EXISTS slotOrari");
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

    @Override
    public long registraCliente(String username, String password, String nome, String cognome)
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
        return db.query(DATABASE_TABELLA, new String[] {KEY_RIGAID, KEY_NOME, KEY_INDIRIZZO}, null, null,
                null, null, null);
    }

    @Override
    public Cursor loginCliente(String username) throws SQLException
    {
        Cursor mCursore = db.query("clienti", new String[] {"id", "password", "nome", "cognome", "abilitato"}, "username = ?",
                new String[]{username}, null, null, null, null);
        if (mCursore != null) {
            mCursore.moveToFirst();
        }
        return mCursore;
    }

    @Override
    public Cursor verificaDisponibilità(LocalDate data, LocalTime oraInizio, LocalTime oraFine) throws SQLException
    {
        Cursor mCursore = db.query("slotOrari", new String[] {"id", "disponibile"}, "data = ? and oraInizio = ? and oraFine = ?",
                new String[]{data.toString(),oraInizio.toString()+":00",oraFine.toString()+":00"},null, null, null, null);
        if (mCursore != null) {
            mCursore.moveToFirst();
        }
        return mCursore;
    }

    @Override
    public int setDisponibilità(LocalDate data, LocalTime oraInizio, LocalTime oraFine,boolean disponibile) throws SQLException
    {
        // setDisponibilita restituisce 1 se l'update è andato a buon fine, 0 altrimenti (slot già prenotato)

        Cursor mCursore = db.query("slotOrari", new String[] {"disponibile"}, "data = ? and oraInizio = ? and oraFine = ? ",
                new String[]{data.toString(),oraInizio.toString()+":00",oraFine.toString()+":00"},null, null, null, null);
        mCursore.moveToFirst();

        if(mCursore.getInt(0)==1) {
            ContentValues disponibilita = new ContentValues();
            disponibilita.put("disponibile", disponibile);
            return db.update("slotOrari", disponibilita, "data = ? and oraInizio = ? and oraFine = ?",
                    new String[]{data.toString(), oraInizio.toString()+":00", oraFine.toString()+":00"});
        }
        else return 0;
    }

    @Override
    public long inserisciPrenotazione(int clienteID, int slotOrarioID) {
        ContentValues initialValues = new ContentValues();
        initialValues.put("cliente",clienteID);
        initialValues.put("slotOrario",slotOrarioID);
        return db.insert("prenotazioni",null, initialValues);
    }

}
