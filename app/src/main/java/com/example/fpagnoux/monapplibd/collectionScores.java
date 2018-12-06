package com.example.fpagnoux.monapplibd;

import android.content.Context;

import java.util.ArrayList;

public class collectionScores {
    ArrayList<rank> ensScores= new ArrayList<>();
    Rank_SQLiteOpenHelper base_score;

    public int nb_elements(){ return ensScores.size();}

    public int getScore (int id){ return ensScores.get(id).getScore();}

    public String getReponse(int score){ return ensScores.get(score).getPseudo();}

    //solution basée sur une insertion en code des questions

    public void insertion_questions(Context un_context){
        base_score = new Rank_SQLiteOpenHelper(un_context);

        ensScores = base_score.getAllRank();

        if(ensScores.isEmpty()){
            base_score.ajoutScoreRenelaBd_liste(new rank(0, "hugo", 100));

            base_score.ajoutInsertScore();

            ensScores = base_score.getAllRank();

        }
    }
}
