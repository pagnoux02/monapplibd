package com.example.fpagnoux.monapplibd;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;



public class Memory extends AppCompatActivity {
    //on assigne le layout memory_lanscape à l'activité
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memory_lanscape);
    }


    //Propriétés
    String theme = "titeuf";
    String nomJoueur;
    int nbCoups;
    //génération d'un chiffre aléatoire
    Random rand = new Random();
    int unNbRandom = rand.nextInt(8);
    int[] imgTheme;
    TextView txtViewTheme = (TextView) findViewById(R.id.theme);

    //Méthode

    //définition des themes

    private void definitionThemme()
    {
        //BD
        //Tintin
        if (theme == "tintin")
        {
            //instancie les images dans un tableau
            imgTheme = new int[] {R.drawable.t1_1, R.drawable.t1_2, R.drawable.t1_3, R.drawable.t1_4, R.drawable.t1_5, R.drawable.t1_6, R.drawable.t1_7, R.drawable.t1_8};
            //On affiche le thème sélectionné
            txtViewTheme.setText("Thème: Tintin");
        }
        //Titeuf
        else if (theme == "titeuf")
        {
            //instancie les images dans un tableau
            //imgTheme = new int[] {R.drawable.t2_1, R.drawable.t2_2, R.drawable.t2_3, R.drawable.t2_4, R.drawable.t2_5, R.drawable.t2_6, R.drawable.t2_7, R.drawable.t2_8};
            //On affiche le thème sélectionné
            txtViewTheme.setText("Thème: Titeuf");
        }
        //Simson
        else if (theme == "simson")
        {
            //instancie les images dans un tableau
            //imgtheme = new int[] {R.drawable.s3_1, R.drawable.s3_2, R.drawable.s3_3, R.drawable.s3_4, R.drawable.s3_5, R.drawable.s3_6, R.drawable.s3_7, R.drawable.s3_8};
            //On affiche le thème sélectionné
            txtViewTheme.setText("Thème: Simson");
        }
        //Manga
        //Naruto
        else if (theme == "naruto")
        {
            //instancie les images dans un tableau
            //imgTheme = new int[] {R.drawable.n4_1, R.drawable.n4_2, R.drawable.n4_3, R.drawable.n4_4, R.drawable.n4_5, R.drawable.n4_6, R.drawable.n4_7, R.drawable.n4_8};
            //On affiche le thème sélectionné
            txtViewTheme.setText("Thème: Naruto");
        }
        //Fairy Tail
        else if (theme == "fairytail")
        {
            //instancie les images dans un tableau
            //imgTheme = new int[] {R.drawable.f5_1, R.drawable.f5_2, R.drawable.f5_3, R.drawable.f5_4, R.drawable.f5_5, R.drawable.f5_6, R.drawable.f5_7, R.drawable.f5_8};
            //On affiche le thème sélectionné
            txtViewTheme.setText("Thème: Fairy Tail");
        }
        //One Piece
        else if (theme == "onepiece")
        {
            //instancie les images dans un tableau
            //imgTheme = new int[] {R.drawable.o6_1, R.drawable.o6_2, R.drawable.o6_3, R.drawable.o6_4, R.drawable.o6_5, R.drawable.o6_6, R.drawable.o6_7, R.drawable.o6_8};
            //On affiche le thème sélectionné
            txtViewTheme.setText("Thème: One Piece");
        }
        //Comics
        //Super Man
        else if (theme == "superman")
        {
            //instancie les images dans un tableau
            //imgTheme = new int[] {R.drawable.s7_1, R.drawable.s7_2, R.drawable.s7_3, R.drawable.s7_4, R.drawable.s7_5, R.drawable.s7_6, R.drawable.s7_7, R.drawable.s7_8};
            //On affiche le thème sélectionné
            txtViewTheme.setText("Thème: Superman");
        }
        //Spider Man
        else if (theme == "spiderman")
        {
            //instancie les images dans un tableau
            //imgTheme = new int[] {R.drawable.s8_1, R.drawable.s8_2, R.drawable.s8_3, R.drawable.s8_4, R.drawable.s8_5, R.drawable.s8_6, R.drawable.s8_7, R.drawable.s8_8};
            //On affiche le thème sélectionné
            txtViewTheme.setText("Thème: Spider-man");
        }
        //Avenger
        else if (theme == "avenger")
        {
            //instancie les images dans un tableau
            //imgTheme = new int[] {R.drawable.a9_1, R.drawable.a9_2, R.drawable.a9_3, R.drawable.a9_4, R.drawable.a9_5, R.drawable.a9_6, R.drawable.a9_7, R.drawable.a9_8};
            //On affiche le thème sélectionné
            txtViewTheme.setText("Thème: Avenger");
        }
    }
}
