package com.example.fpagnoux.monapplibd;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Random;



public class Memory extends AppCompatActivity {
    //on assigne le layout memory_lanscape à l'activité
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memory_lanscape);
    }


    //Propriétés
    String theme = "tintin";
    String nomJoueur;
    int nbCoups;
    //génération d'un chiffre aléatoire
    Random rand = new Random();
    int unNbRandom = rand.nextInt(8);
    private int[] imgTheme;

    //Méthode

    //définition des themes

    private void definitionThemme()
    {
        //BD
        //Tintin
        if (theme == "tintin")
        {
            imgTheme = new int[] {R.drawable.t1_1, R.drawable.t1_2, R.drawable.t1_3, R.drawable.t1_4, R.drawable.t1_5, R.drawable.t1_6, R.drawable.t1_7, R.drawable.t1_8};
        }
        //Titeuf
        else if (theme == "titeuf")
        {
            //imgTheme = new int[] {R.drawable.t2_1, R.drawable.t2_2, R.drawable.t2_3, R.drawable.t2_4, R.drawable.t2_5, R.drawable.t2_6, R.drawable.t2_7, R.drawable.t2_8};
        }
        //Simson
        else if (theme == "simson")
        {
            //imgtheme = new int[] {R.drawable.s3_1, R.drawable.s3_2, R.drawable.s3_3, R.drawable.s3_4, R.drawable.s3_5, R.drawable.s3_6, R.drawable.s3_7, R.drawable.s3_8};
        }
        //Manga
        //Naruto
        else if (theme == "naruto")
        {
            //imgTheme = new int[] {R.drawable.n4_1, R.drawable.n4_2, R.drawable.n4_3, R.drawable.n4_4, R.drawable.n4_5, R.drawable.n4_6, R.drawable.n4_7, R.drawable.n4_8};
        }
        //Fairy Tail
        else if (theme == "fairytail")
        {
            //imgTheme = new int[] {R.drawable.f5_1, R.drawable.f5_2, R.drawable.f5_3, R.drawable.f5_4, R.drawable.f5_5, R.drawable.f5_6, R.drawable.f5_7, R.drawable.f5_8};
        }
        //One Piece
        else if (theme == "onepiece")
        {
            //imgTheme = new int[] {R.drawable.o6_1, R.drawable.o6_2, R.drawable.o6_3, R.drawable.o6_4, R.drawable.o6_5, R.drawable.o6_6, R.drawable.o6_7, R.drawable.o6_8};
        }
        //Comics
        //Super Man
        else if (theme == "superman")
        {
            //imgTheme = new int[] {R.drawable.s7_1, R.drawable.s7_2, R.drawable.s7_3, R.drawable.s7_4, R.drawable.s7_5, R.drawable.s7_6, R.drawable.s7_7, R.drawable.s7_8};
        }
        //Spider Man
        else if (theme == "spiderman")
        {
            //imgTheme = new int[] {R.drawable.s8_1, R.drawable.s8_2, R.drawable.s8_3, R.drawable.s8_4, R.drawable.s8_5, R.drawable.s8_6, R.drawable.s8_7, R.drawable.s8_8};
        }
        //Avenger
        else if (theme == "avenger")
        {
            //imgTheme = new int[] {R.drawable.a9_1, R.drawable.a9_2, R.drawable.a9_3, R.drawable.a9_4, R.drawable.a9_5, R.drawable.a9_6, R.drawable.a9_7, R.drawable.a9_8};
        }
    }
}
