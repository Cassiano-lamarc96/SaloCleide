package com.example.sigfas.salocleide;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class bancoDados extends SQLiteOpenHelper{

    public static final int VERSAO_BANCO = 1;
    public static final String BANCO_CLIENTE = "SALAOCLEIDE";

    public bancoDados(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){

    }
}
