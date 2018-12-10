package com.example.fpagnoux.monapplibd;

import android.content.Context;

public final class Controle {

    private static Controle instance = null;
    private static rank Rank;
    private static AccesLocal accesLocal;

    private Controle(){
        super();
    }

    public static final Controle getInstance(Context context){
        if(Controle.instance ==null){
            Controle.instance = new Controle();
            accesLocal = new AccesLocal(context);
            Rank = accesLocal.recupDernier();
        }
        return Controle.instance;
    }

    public void creerScore(Integer id, String pseudo, Integer score){
        Rank = new rank(id, pseudo, score);
        accesLocal.ajout(Rank);
    }

}
