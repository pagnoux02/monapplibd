package com.example.fpagnoux.monapplibd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;

public class MySQLiteOpenHelper extends SQLiteOpenHelper{

    private String creation="create table Rank ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "pseudo TEXT NOT NULL,"
            + "score INTEGER);";

    private static String DB_NAME = "Classement";
    private static int DB_VERSION = 1;


    public MySQLiteOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        Log.i("test base","insertion " + String.valueOf(creation));
        sqLiteDatabase.execSQL(creation);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertScore(){
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("INSERT INTO Rank VALUES (15, hugo, 1000);");
    }

    public ArrayList<rank> getLesQuestions(){
        ArrayList<rank> ensScore = new ArrayList<rank>();
        String reqSelect = " SELECT * FROM Rank";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor unCurseur = db.rawQuery(reqSelect, null);
        if(unCurseur.moveToFirst()){
            do{
                rank unRank= new rank();
                unRank.setId(unCurseur.getInt(unCurseur.getColumnIndex("id")));
                unRank.setPseudo(unCurseur.getString(unCurseur.getColumnIndex("pseudo")));
                unRank.setScore(unCurseur.getInt(unCurseur.getColumnIndex("score")));

                ensScore.add(unRank);
            }while (unCurseur.moveToNext());
            Collections.shuffle(ensScore);
        }

        return ensScore;
    }

    public long ajoutScoreDep(rank uneQuestion){
        SQLiteDatabase db = this.getWritableDatabase();

        //db.execSQL("INSERT INTO QuestionsQcm VALUES (0,'PremQuestion','premProp','SecProp','TroisProp','quatProp','premProp');");
        System.out.println("ok!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        ContentValues values = new ContentValues();

        values.put("id",uneQuestion.getId());
        values.put("pseudo",uneQuestion.getPseudo());
        values.put("score",uneQuestion.getScore());

        long insertion = db.insert("Rank", null, values);
        return insertion;
    }

    public void ajoutInsertScore(){
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("INSERT INTO Rank VALUES (15,'');");


    }
}
