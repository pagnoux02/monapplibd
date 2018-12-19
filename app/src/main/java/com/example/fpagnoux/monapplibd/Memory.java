package com.example.fpagnoux.monapplibd;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.floor;
import static java.lang.Math.random;


public class Memory extends AppCompatActivity {
    //Propriétés
    private String theme = "tintin";
    private String nomJoueur;
    private int nbCoups;
    //génération d'un chiffre aléatoire
    Random rand = new Random();
    int unNbRandom = rand.nextInt(8);
    private int[] imgTheme;
    private TextView txtViewTheme;
    private ImageView imgV1, imgV2, imgV3, imgV4, imgV5, imgV6, imgV7, imgV8, imgV9, imgV10, imgV11, imgV12,imgV13, imgV14, imgV15, imgV16;
    private int img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12,img13, img14, img15, img16;
    //liste pour les images
    private int[] tabCarte = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,13, 14, 15, 16};
    private int[] assignImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memory_lanscape); //on assigne le layout memory_lanscape à l'activité


        // instanciation des imagesView
        imgV1 = (ImageView) findViewById(R.id.image1_1);
        imgV2 = (ImageView) findViewById(R.id.image1_2);
        imgV3 = (ImageView) findViewById(R.id.image1_3);
        imgV4 = (ImageView) findViewById(R.id.image1_4);
        imgV5 = (ImageView) findViewById(R.id.image2_1);
        imgV6 = (ImageView) findViewById(R.id.image2_2);
        imgV7 = (ImageView) findViewById(R.id.image2_3);
        imgV8 = (ImageView) findViewById(R.id.image2_4);
        imgV9 = (ImageView) findViewById(R.id.image3_1);
        imgV10 = (ImageView) findViewById(R.id.image3_2);
        imgV11 = (ImageView) findViewById(R.id.image3_3);
        imgV12 = (ImageView) findViewById(R.id.image3_4);
        imgV13 = (ImageView) findViewById(R.id.image4_1);
        imgV14 = (ImageView) findViewById(R.id.image4_2);
        imgV15 = (ImageView) findViewById(R.id.image4_3);
        imgV16 = (ImageView) findViewById(R.id.image4_4);

        //tag
        imgV1.setTag("0");
        imgV2.setTag("1");
        imgV3.setTag("2");
        imgV4.setTag("3");
        imgV5.setTag("4");
        imgV6.setTag("5");
        imgV7.setTag("6");
        imgV8.setTag("7");
        imgV9.setTag("8");
        imgV10.setTag("9");
        imgV11.setTag("10");
        imgV12.setTag("11");
        imgV13.setTag("12");
        imgV14.setTag("13");
        imgV15.setTag("14");
        imgV16.setTag("15");


        //On affiche le theme choisi dans le textView theme
        txtViewTheme = findViewById(R.id.theme);
        if(theme == "tintin")
        {
            txtViewTheme.setText("Thème : Tintin");
        }
        else if (theme == "titeuf")
        {
            txtViewTheme.setText("Thème : Titeuf");
        }
        else if (theme == "simson")
        {
            txtViewTheme.setText("Thème : Simson");
        }
        else if (theme == "naruto")
        {
            txtViewTheme.setText("Thème : Naruto");
        }
        else if (theme == "fairytail")
        {
            txtViewTheme.setText("Thème : Fairy Tail");
        }
        else if (theme == "onepiece")
        {
            txtViewTheme.setText("Thème : One Piece");
        }
        else if (theme == "superman")
        {
            txtViewTheme.setText("Thème : Superman");
        }
        else if (theme == "spiderman")
        {
            txtViewTheme.setText("Thème : Spider-man");
        }
        else if (theme == "avengers")
        {
            txtViewTheme.setText("Thème : Avengers");
        }


        //charge les images
        imgrsc();

        //melange de la liste
        Collections.shuffle(Arrays.asList(tabCarte));




        imgV1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //int laCarte = String.parseInt((String) view.getTag());
                //doStuff(imgV1, laCarte);
            }
        });

        imgV2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgV3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgV4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgV5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgV6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgV7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgV8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgV9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgV10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgV11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgV12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgV13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgV14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgV15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgV16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }

    //https://www.youtube.com/watch?v=94CWNE9ruMA tuto inspi
    //Méthode


    private void imgrsc()
    {
        img1 = R.drawable.t1_1;
        img2 = R.drawable.t1_2;
        img3 = R.drawable.t1_3;
        img4 = R.drawable.t1_4;
        img5 = R.drawable.t1_5;
        img6 = R.drawable.t1_6;
        img7 = R.drawable.t1_7;
        img8 = R.drawable.t1_8;
        img9 = R.drawable.t1_1_2;
        img10 = R.drawable.t1_2_2;
        img11 = R.drawable.t1_3_2;
        img12 = R.drawable.t1_4_2;
        img13 = R.drawable.t1_5_2;
        img14 = R.drawable.t1_6_2;
        img15 = R.drawable.t1_7_2;
        img16 = R.drawable.t1_8_2;
    }


    //définition des themes

    private void definitionTheme()
    {
        /*int unNbRandom = rand.nextInt(8);
        //BD
        //Tintin
        if (theme == "tintin")
        {
            //instancie les images dans un tableau
            imgTheme = new int[] {R.drawable.t1_1, R.drawable.t1_2, R.drawable.t1_3, R.drawable.t1_4, R.drawable.t1_5, R.drawable.t1_6, R.drawable.t1_7, R.drawable.t1_8};
            ImageView[] imgAlea = new ImageView[(int)((Math.random()*imgTheme.length)*2)];
        }
        //Titeuf
        else if (theme == "titeuf")
        {
            //instancie les images dans un tableau
            imgTheme = new int[] {R.drawable.t2_1, R.drawable.t2_2, R.drawable.t2_3, R.drawable.t2_4, R.drawable.t2_5, R.drawable.t2_6, R.drawable.t2_7, R.drawable.t2_8};
        }
        //Simson
        else if (theme == "simson")
        {
            //instancie les images dans un tableau
            //imgtheme = new int[] {R.drawable.s3_1, R.drawable.s3_2, R.drawable.s3_3, R.drawable.s3_4, R.drawable.s3_5, R.drawable.s3_6, R.drawable.s3_7, R.drawable.s3_8};
        }
        //Manga
        //Naruto
        else if (theme == "naruto")
        {
            //instancie les images dans un tableau
            //imgTheme = new int[] {R.drawable.n4_1, R.drawable.n4_2, R.drawable.n4_3, R.drawable.n4_4, R.drawable.n4_5, R.drawable.n4_6, R.drawable.n4_7, R.drawable.n4_8};
        }
        //Fairy Tail
        else if (theme == "fairytail")
        {
            //instancie les images dans un tableau
            //imgTheme = new int[] {R.drawable.f5_1, R.drawable.f5_2, R.drawable.f5_3, R.drawable.f5_4, R.drawable.f5_5, R.drawable.f5_6, R.drawable.f5_7, R.drawable.f5_8};
        }
        //One Piece
        else if (theme == "onepiece")
        {
            //instancie les images dans un tableau
            //imgTheme = new int[] {R.drawable.o6_1, R.drawable.o6_2, R.drawable.o6_3, R.drawable.o6_4, R.drawable.o6_5, R.drawable.o6_6, R.drawable.o6_7, R.drawable.o6_8};
        }
        //Comics
        //Super Man
        else if (theme == "superman")
        {
            //instancie les images dans un tableau
            //imgTheme = new int[] {R.drawable.s7_1, R.drawable.s7_2, R.drawable.s7_3, R.drawable.s7_4, R.drawable.s7_5, R.drawable.s7_6, R.drawable.s7_7, R.drawable.s7_8};
        }
        //Spider Man
        else if (theme == "spiderman")
        {
            //instancie les images dans un tableau
            //imgTheme = new int[] {R.drawable.s8_1, R.drawable.s8_2, R.drawable.s8_3, R.drawable.s8_4, R.drawable.s8_5, R.drawable.s8_6, R.drawable.s8_7, R.drawable.s8_8};
        }
        //Avenger
        else if (theme == "avengers")
        {
            //instancie les images dans un tableau
            //imgTheme = new int[] {R.drawable.a9_1, R.drawable.a9_2, R.drawable.a9_3, R.drawable.a9_4, R.drawable.a9_5, R.drawable.a9_6, R.drawable.a9_7, R.drawable.a9_8};
        }*/
    }

}
