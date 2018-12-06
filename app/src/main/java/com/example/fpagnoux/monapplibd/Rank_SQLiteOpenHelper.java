package com.example.fpagnoux.monapplibd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by J. Saifer on 30/01/2017.
 */

public class Rank_SQLiteOpenHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION =1;

    // Database Name
    public static final String DATABASE_NAME = "Class_Score";

    // Contacts table name
    public static final String TABLE_CLASSEMENT = "Classement";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "pseudo";
    private static final String KEY_SCORE = "Score";

    public static final int score = 0;

    //Création de la table
    public static final String reqCreationTable ="CREATE TABLE "+ TABLE_CLASSEMENT + " (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            KEY_NAME + " TEXT" + score + "INTEGER);";

    //Constructeur
    public Rank_SQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Polymorphisme 2ème constructeur
    public Rank_SQLiteOpenHelper(Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    //On crée la base de données
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("test base","insertion " + String.valueOf(reqCreationTable));
        String reqSupp = "DROP TABLE IF EXISTS " + TABLE_CLASSEMENT;
        db.execSQL(reqSupp);
        db.execSQL(reqCreationTable);

    }

//
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        /*
        String reqSupp = "DROP TABLE IF EXISTS " + reqCreationTable;
        db.execSQL(reqSupp);
        onCreate(db);*/

    }

    //On ajoute un nouveau score dans la base
    public long ajoutScoreRenelaBd_liste(rank unRang){

        ContentValues values = new ContentValues();
        SQLiteDatabase db = this.getWritableDatabase();

        values.put("pseudo",unRang.getPseudo());
        values.put("score",unRang.getScore());
        String listRang = new String();
        listRang += unRang;


        //On insère les données dans la base
        long insertion = db.insert(TABLE_CLASSEMENT, null, values);
        return insertion;
    }



    public List<rank> getAllRank() {
        List<rank> rankList = new ArrayList<rank>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CLASSEMENT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                rank unRank = new rank();
                unRank.setId(Integer.parseInt(cursor.getString(0)));
                unRank.setPseudo(cursor.getString(1));
                unRank.setScore(cursor.getInt(2));
                // Adding contact to list
                rankList.add(unRank);
            } while (cursor.moveToNext());
        }

        // return contact list
        return rankList;
    }



}