package com.example.fpagnoux.monapplibd;


public class rank {

    private String pseudo;
    private int score;

    public rank(){

    }


    public rank(String unPseudo, int unScore){
        super();
        pseudo = unPseudo;
        score = unScore;
    }

    public void setPseudo(String wPseudo){
        pseudo = wPseudo;
    }
    public String getPseudo(){
        return pseudo;
    }

    public void setScore(int wScore){
        score = wScore;
    }
    public int getScore(){
        return score;
    }


}
