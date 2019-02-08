package com.example.fpagnoux.monapplibd;


public class rank {

    private String pseudo;
    private int score,id;

public rank(){

}

    public rank( String unPseudo, int unScore){

        pseudo = unPseudo;
        score = unScore;

    }


    public rank(int unid, String unPseudo, int unScore){

        id = unid;
        pseudo = unPseudo;
        score = unScore;


    }


    public void setId(int unid){
        id = unid;
    }
    public int getid(){ return id;
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
