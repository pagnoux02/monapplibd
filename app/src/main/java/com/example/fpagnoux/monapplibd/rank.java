package com.example.fpagnoux.monapplibd;


public class rank {
    private int id;
    private String pseudo;
    private int score;

    public rank(){

    }


    public rank(int unId, String unPseudo, int unScore){
        id = unId;
        pseudo = unPseudo;
        score = unScore;
    }

    public void setId(int unId){
        id = unId;
    }
    public int getId(){
        return id;
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
