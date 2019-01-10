package com.example.fpagnoux.monapplibd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class collectionScore {
    ArrayList<rank> ensScore= new ArrayList<>();
    MySQLiteOpenHelper base_score;

    public int nb_elements(){ return ensScore.size();}

    //solution basée sur une insertion en code des questions

    public void insertion_Score(Context un_context){
        base_score = new MySQLiteOpenHelper(un_context);

        ensScore = base_score.getLesScores();

        if(ensScore.isEmpty()){
            base_score.ajoutScoreDep(new rank("Hugo", 100));
            base_score.ajoutScoreDep(new rank("Francois", 90));
            base_score.ajoutScoreDep(new rank("Mael", 80));
            base_score.ajoutScoreDep(new rank("Julian", 70));
            base_score.ajoutScoreDep(new rank("Dylan", 60));
            base_score.ajoutScoreDep(new rank("Steeven", 50));
            base_score.ajoutScoreDep(new rank("Thomas", 40));
            base_score.ajoutScoreDep(new rank("Anthony", 30));
            base_score.ajoutScoreDep(new rank("Loïc", 20));
            base_score.ajoutScoreDep(new rank("Benjamin", 10));
            base_score.ajoutScoreDep(new rank("Valentin", 0));

            base_score.ajoutInsertScore();
            ensScore = base_score.getLesScores();
        }
    }
}
