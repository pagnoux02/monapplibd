package com.example.fpagnoux.monapplibd;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class AccesLocal {

    private String nomBase = "Classement";
    private Integer versionBase = 1;
    private MySQLiteOpenHelper accesBD;
    private SQLiteDatabase bd;

    public AccesLocal(Context context){
        accesBD = new MySQLiteOpenHelper(context, nomBase, null, versionBase);
    }

    public void ajout(rank Rank){
        bd = accesBD.getWritableDatabase();
        String req = "insert into rank (id, pseudo, score) values ";
        req += "("+Rank.getId()+","+Rank.getPseudo()+","+Rank.getScore()+")";
        bd.execSQL(req);
    }

    public rank recupDernier(){
        bd = accesBD.getReadableDatabase();
        rank Rank=null;
        String req = "select * from Rank";
        Cursor curseur = bd.rawQuery(req, null);
        curseur.moveToLast();
        if(!curseur.isAfterLast()){
            Integer id = curseur.getInt(0);
            String pseudo = curseur.getString(1);
            Integer score = curseur.getInt(2);
            Rank = new rank(id, pseudo, score);
        }
        curseur.close();
        return Rank;
    }

}
