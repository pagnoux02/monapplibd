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

        ensScore = base_score.getLesQuestions();

        if(ensScore.isEmpty()){
            base_score.ajoutScoreDep(new rank(1,"hugo", 1000));
            base_score.ajoutScoreDep(new rank(2,"francois", 990));

            base_score.ajoutInsertScore();

            ensScore = base_score.getLesQuestions();

        }
    }

}
