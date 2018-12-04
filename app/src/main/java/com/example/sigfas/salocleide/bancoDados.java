package com.example.sigfas.salocleide;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class bancoDados extends SQLiteOpenHelper{

    public static final int VERSAO_BANCO = 1;
    public static final String BANCO_CLIENTE = "SALAOCLEIDEv1";

    public bancoDados(Context context){
        super(context, BANCO_CLIENTE, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CriaTabela = "CREATE TABLE CLIENTE ( CLIE_ID INTEGER PRIMARY KEY AUTOINCREMENT, CLIE_NOME TEXT, CLIE_TELEFONE INT ) ";
        db.execSQL(CriaTabela);
        CriaTabela = "CREATE TABLE SERVICO (SERV_ID INTEGER PRIMARY KEY AUTOINCREMENT, SERV_NOME TEXT, SERV_PRECO REAL)";
        db.execSQL(CriaTabela);
        CriaTabela = "CREATE TABLE SERVICO_REALIZADO (SERE_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "CLIE_ID INTEGER, SERV_ID INTEGER, SERV_PRECO REAL, " +
                "  FOREIGN KEY(CLIE_ID) REFERENCES CLIENTE(CLIE_ID), " +
                "  FOREIGN KEY(SERV_ID) REFERENCES SERVICO(SERV_ID)) ";
        db.execSQL(CriaTabela);
        CriaTabela = "CREATE TABLE USUARIO (USUA_ID INTEGER PRIMARY KEY AUTOINCREMENT, USUA_CODIGO INT, USUA_SENHA TEXT) ";

    }

    public boolean insereCliente(mCliente clie){
        try {

            SQLiteDatabase db = getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("CLIE_NOME", clie.getNome());
            cv.put("CLIE_TELEFONE", clie.getTelefone());
            db.insert("CLIENTE", null, cv);
            db.close();
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean insereServico(mServico serv){
        try {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("SERV_NOME", serv.getNome());
            cv.put("SERV_PRECO", serv.getPreco());
            db.insert("SERVICO", null, cv);
            db.close();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean insereServicoRealizado(servicoRealizado sere){
        try {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("CLIE_ID", sere.getIdCliente());
            cv.put("SERV_ID", sere.getIdServico());
            cv.put("SERV_PRECO", sere.getPreco());
            db.insert("SERVICO_REALIZADO", null, cv);
            db.close();
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public List<mCliente> retornaClientes(){
        List<mCliente> lstRet = new ArrayList<mCliente>();
        SQLiteDatabase db = getReadableDatabase();
        String query = " SELECT * FROM CLIENTE ";
        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst()){
            do{
                mCliente mClie = new mCliente();
                mClie.setId(c.getInt(0));
                mClie.setNome(c.getString(1));
                mClie.setTelefone(c.getInt(2));
                lstRet.add(mClie);
            }while (c.moveToNext());
        }
        db.close();
        return  lstRet;
    }

    public mCliente retornaClieId(int id){
        mCliente mClie = new mCliente();
        try{
            SQLiteDatabase db = getReadableDatabase();
            String sql = "SELECT * FROM CLIENTE WHERE CLIE_ID = " + id;
            Cursor c = db.rawQuery(sql, null);
            if (c.moveToFirst()){
                do{
                    mClie.setId(c.getInt(0));
                    mClie.setNome(c.getString(1));
                    mClie.setTelefone(c.getInt(2));
                    return mClie;
                }while (c.moveToNext());
            }
        }catch (Exception e){
            return null;
        }
        return mClie;
    }

    public mServico retornaServId(int id){
        mServico mServico = new mServico();
        try{
            SQLiteDatabase db = getReadableDatabase();
            String sql = "SELECT * FROM SERVICO WHERE SERV_ID = " + id;
            Cursor c = db.rawQuery(sql, null);
            if (c.moveToFirst()){
                do{
                    mServico.setId(c.getInt(0));
                    mServico.setNome(c.getString(1));
                    mServico.setPreco(c.getDouble(2));
                    return mServico;
                }while (c.moveToNext());
            }
        }catch (Exception e){
            return null;
        }
        return mServico;
    }

    public List<mServico> retornaServico(){
        List<mServico> lstRet = new ArrayList<mServico>();
        SQLiteDatabase db = getReadableDatabase();
        String query = " SELECT * FROM SERVICO ";
        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst()){
            do{
                mServico mServico = new mServico();
                mServico.setId(c.getInt(0));
                mServico.setNome(c.getString(1));
                mServico.setPreco(c.getDouble(2));
                lstRet.add(mServico);
            }while (c.moveToNext());
        }
        db.close();
        return  lstRet;
    }

    public List<servicoRealizado> retornaServicoRealizado(){
        List<servicoRealizado> lstRet = new ArrayList<servicoRealizado>();
        SQLiteDatabase db = getReadableDatabase();
        String query = " SELECT * FROM SERVICO_REALIZADO ";
        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst()){
            do{
                servicoRealizado servicoRealizado = new servicoRealizado();
                servicoRealizado.setId(c.getInt(0));
                servicoRealizado.setIdCliente(c.getInt(1));
                servicoRealizado.setIdServico(c.getInt(2));
                servicoRealizado.setpreco(c.getDouble(3));
                lstRet.add(servicoRealizado);
            }while (c.moveToNext());
        }
        db.close();
        return  lstRet;
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1){
        String deleteTabela = "DROP TABLE CLIENTE ";
        db = getWritableDatabase();
        db.execSQL(deleteTabela);
        deleteTabela = "DROP TABLE SERVICO";
        db.execSQL(deleteTabela);
        deleteTabela = "DROP TABLE SERVICO_REALIZADO";
        db.execSQL(deleteTabela);
        deleteTabela = "DROP TABLE USUARIO";
        db.execSQL(deleteTabela);
        this.onCreate(db);
    }
}
