package com.example.fpagnoux.monapplibd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private String creation = "create table Rank ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "pseudo TEXT NOT NULL,"
            + "score INTEGER);";

    private String reqClassement = "SELECT * FROM Rank ORDER BY Rank.score DESC LIMIT 5;";

    private static String DB_NAME = "Classement";
    private static int DB_VERSION = 1;


    public MySQLiteOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        Log.i("test base", "insertion " + String.valueOf(creation));
        sqLiteDatabase.execSQL(creation);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE Rank;");
        onCreate(db);
    }

    public void insertScore(rank unRank) {
        SQLiteDatabase db = this.getWritableDatabase();
        String pseudo = unRank.getPseudo();
        int score = unRank.getScore();

        db.execSQL("INSERT INTO Rank VALUES ("+"pseudo,"+"score);");
    }

    public ArrayList<rank> getLesScores() {
        ArrayList<rank> ensScore = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor unCurseur = db.rawQuery(reqClassement, null);
        if (unCurseur.moveToFirst()) {
            do {

                //convertir en entier probleme de type
                rank unRank = new rank();
              unRank.setId(unCurseur.getInt(unCurseur.getColumnIndex("id")));
                unRank.setPseudo(unCurseur.getString(unCurseur.getColumnIndex("pseudo")));
                unRank.setScore(unCurseur.getInt(unCurseur.getColumnIndex("score")));

                System.out.println(unRank.getPseudo());
                ensScore.add(unRank);
            } while (unCurseur.moveToNext());
        }
        return ensScore;
    }

    public void ajoutInsertScore(){
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("INSERT INTO Rank VALUES ('pseudo',score);");


    }

    public long ajoutScoreDep(rank unRank) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("pseudo", unRank.getPseudo());
        values.put("score", unRank.getScore());

        long insertion = db.insert("Rank", null, values);
        return insertion;
    }

}
