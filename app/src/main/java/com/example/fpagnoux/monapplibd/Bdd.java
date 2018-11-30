package com.example.fpagnoux.monapplibd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by J. Saifer on 30/01/2017.
 */

public class Bdd extends SQLiteOpenHelper {
    static String DB_NAME="score.db";
    static int DB_VERSION=3;

    public Bdd(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlFilTable ="CREATE TABLE CLASSEMENT(id INTEGER PRIMARY KEY, pseudo TEXT, score INTEGER)";
        db.execSQL(sqlFilTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for(int i = oldVersion;i<newVersion;i++)  {
            int versionToUpdate = i+1;
            if(versionToUpdate==2) {
                upgradeToVersion2(db);
            } else if(versionToUpdate==3) {
                // Code pour mettre la base de données en version 3
            }
            //[...]
        }
    }

    private void upgradeToVersion2(SQLiteDatabase db) {
        String sqlCommand = "ALTER TABLE QUESTION ADD COLUMN numero NUMERIC";
        db.execSQL(sqlCommand);
    }
}