package com.example.fpagnoux.monapplibd;

import android.content.Context;

import java.util.ArrayList;

public class collectionScore {
    ArrayList<rank> ensScore= new ArrayList<>();
    MySQLiteOpenHelper base_score;

    public int nb_elements(){ return ensScore.size();}

    public int getId(int numId){return ensScore.get(numId).getId();}

    public String getPseudo (int num_question, int num_proposition){ return ensScore.get(num_question).getPseudo();}

    public int getScore(int numQuestion){ return ensScore.get(numQuestion).getScore();}

    //solution basée sur une insertion en code des questions

    public void insertion_questions(Context un_context){
        base_score = new MySQLiteOpenHelper(un_context);

        ensScore = base_score.getLesScores();

        if(ensScore.isEmpty()){
            base_score.ajoutScoreDep(new rank(1,"Hugo", 100));
            base_score.ajoutScoreDep(new rank(2,"Francois", 90));
            base_score.ajoutScoreDep(new rank(3,"Mael", 80));
            base_score.ajoutScoreDep(new rank(4,"Julian", 70));
            base_score.ajoutScoreDep(new rank(5,"Dylan", 60));
            base_score.ajoutScoreDep(new rank(6,"Steeven", 50));
            base_score.ajoutScoreDep(new rank(7,"Thomas", 40));
            base_score.ajoutScoreDep(new rank(8,"Anthony", 30));
            base_score.ajoutScoreDep(new rank(9,"Loïc", 20));
            base_score.ajoutScoreDep(new rank(10,"Benjamin", 10));
            base_score.ajoutScoreDep(new rank(11,"Valentin", 0));

            ensScore = base_score.getLesScores();
        }
    }
}
