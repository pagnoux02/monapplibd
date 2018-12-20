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


//https://www.youtube.com/watch?v=94CWNE9ruMA tuto inspi


public class Memory extends AppCompatActivity {
    //Propriétés

    private String theme = "tintin";
    private String nomJoueur;
    private int nbCoups;

    //génération d'un chiffre aléatoire
    Random rand = new Random();
    //int unNbRandom = rand.nextInt(16);

    private int[] imgTheme;
    private TextView txtViewTheme;

    private ImageView imgV1, imgV2, imgV3, imgV4, imgV5, imgV6, imgV7, imgV8, imgV9, imgV10, imgV11, imgV12,imgV13, imgV14, imgV15, imgV16;
    private int img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12,img13, img14, img15, img16;
    //liste pour les images
    private int[] tabCarte = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,13, 14, 15, 16};

    int carte1, carte2;
    int clic1, clic2;
    int nbCarte = 1;


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

        definitionTheme();
        /*if(theme == "tintin")
        {
            txtViewTheme.setText("Thème : Tintin");
            imgTheme = new int[] {R.drawable.t1_1, R.drawable.t1_2, R.drawable.t1_3, R.drawable.t1_4, R.drawable.t1_5, R.drawable.t1_6, R.drawable.t1_7, R.drawable.t1_8};

        }
        else if (theme == "titeuf")
        {
            txtViewTheme.setText("Thème : Titeuf");
        }
        else if (theme == "simpson")
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
        }*/


        //charge les images
        imgrsc();

        //melange de la liste
        Collections.shuffle(Arrays.asList(tabCarte));




        imgV1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int laCarte = Integer.parseInt((String) view.getTag());
                doStuff(imgV1, laCarte);
            }
        });

        imgV2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int laCarte = Integer.parseInt((String) view.getTag());
                doStuff(imgV2, laCarte);
            }
        });

        imgV3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int laCarte = Integer.parseInt((String) view.getTag());
                doStuff(imgV3, laCarte);
            }
        });

        imgV4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int laCarte = Integer.parseInt((String) view.getTag());
                doStuff(imgV4, laCarte);
            }
        });

        imgV5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int laCarte = Integer.parseInt((String) view.getTag());
                doStuff(imgV5, laCarte);
            }
        });

        imgV6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int laCarte = Integer.parseInt((String) view.getTag());
                doStuff(imgV6, laCarte);
            }
        });

        imgV7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int laCarte = Integer.parseInt((String) view.getTag());
                doStuff(imgV7, laCarte);
            }
        });

        imgV8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int laCarte = Integer.parseInt((String) view.getTag());
                doStuff(imgV8, laCarte);
            }
        });

        imgV9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int laCarte = Integer.parseInt((String) view.getTag());
                doStuff(imgV9, laCarte);
            }
        });

        imgV10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int laCarte = Integer.parseInt((String) view.getTag());
                doStuff(imgV10, laCarte);
            }
        });

        imgV11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int laCarte = Integer.parseInt((String) view.getTag());
                doStuff(imgV11, laCarte);
            }
        });

        imgV12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int laCarte = Integer.parseInt((String) view.getTag());
                doStuff(imgV12, laCarte);
            }
        });

        imgV13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int laCarte = Integer.parseInt((String) view.getTag());
                doStuff(imgV13, laCarte);
            }
        });

        imgV14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int laCarte = Integer.parseInt((String) view.getTag());
                doStuff(imgV14, laCarte);
            }
        });

        imgV15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int laCarte = Integer.parseInt((String) view.getTag());
                doStuff(imgV15, laCarte);
            }
        });

        imgV16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int laCarte = Integer.parseInt((String) view.getTag());
                doStuff(imgV16, laCarte);
            }
        });
    }


    private void doStuff(ImageView imgView, int carte)
    {
        //met les bonnes images dans les imageviews
        if (tabCarte[carte] == 1) {
            imgView.setImageResource(img1);
        } else if (tabCarte[carte] == 2) {
        imgView.setImageResource(img2);
        } else if (tabCarte[carte] == 3) {
            imgView.setImageResource(img3);
        } else if (tabCarte[carte] == 4) {
            imgView.setImageResource(img4);
        } else if (tabCarte[carte] == 5) {
            imgView.setImageResource(img5);
        } else if (tabCarte[carte] == 6) {
            imgView.setImageResource(img6);
        } else if (tabCarte[carte] == 7) {
            imgView.setImageResource(img7);
        } else if (tabCarte[carte] == 8) {
            imgView.setImageResource(img8);
        } else if (tabCarte[carte] == 9) {
            imgView.setImageResource(img9);
        } else if (tabCarte[carte] == 10) {
            imgView.setImageResource(img10);
        } else if (tabCarte[carte] == 11) {
            imgView.setImageResource(img11);
        } else if (tabCarte[carte] == 12) {
            imgView.setImageResource(img12);
        } else if (tabCarte[carte] == 13) {
            imgView.setImageResource(img13);
        } else if (tabCarte[carte] == 14) {
            imgView.setImageResource(img14);
        } else if (tabCarte[carte] == 15) {
            imgView.setImageResource(img15);
        } else if (tabCarte[carte] == 16) {
            imgView.setImageResource(img16);
        }

        if(nbCarte == 1)
        {
            carte1 = tabCarte[carte];
            if(carte1 > 200){
                carte1 = carte1 - 100;
            }
            nbCarte = 2;
            clic1 = carte;
            imgView.setEnabled(false);
        } else if (carte2 == 2)
        {
            carte2 = tabCarte[carte];
            if (carte2 > 200) {
                carte2 = carte2 - 100;
            }
            nbCarte = 2;
            clic2 = carte;
            imgView.setEnabled(false);
        }

    }


    //Méthode


    private void imgrsc()
    {

        if(theme == "tintin")
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
        else if (theme == "titeuf")
        {
            img1 = R.drawable.t2_1;
            img2 = R.drawable.t2_2;
            img3 = R.drawable.t2_3;
            img4 = R.drawable.t2_4;
            img5 = R.drawable.t2_5;
            img6 = R.drawable.t2_6;
            img7 = R.drawable.t2_7;
            img8 = R.drawable.t2_8;
            img9 = R.drawable.t2_1_2;
            img10 = R.drawable.t2_2_2;
            img11 = R.drawable.t2_3_2;
            img12 = R.drawable.t2_4_2;
            img13 = R.drawable.t2_5_2;
            img14 = R.drawable.t2_6_2;
            img15 = R.drawable.t2_7_2;
            img16 = R.drawable.t2_8_2;
        }
        else if (theme == "simpson")
        {
            /*img1 = R.drawable.t3_1;
            img2 = R.drawable.t3_2;
            img3 = R.drawable.t3_3;
            img4 = R.drawable.t3_4;
            img5 = R.drawable.t3_5;
            img6 = R.drawable.t3_6;
            img7 = R.drawable.t3_7;
            img8 = R.drawable.t3_8;
            img9 = R.drawable.t3_1_2;
            img10 = R.drawable.t3_2_2;
            img11 = R.drawable.t3_3_2;
            img12 = R.drawable.t3_4_2;
            img13 = R.drawable.t3_5_2;
            img14 = R.drawable.t3_6_2;
            img15 = R.drawable.t3_7_2;
            img16 = R.drawable.t3_8_2;*/
        }
        else if (theme == "naruto")
        {
            /*img1 = R.drawable.t4_1;
            img2 = R.drawable.t4_2;
            img3 = R.drawable.t4_3;
            img4 = R.drawable.t4_4;
            img5 = R.drawable.t4_5;
            img6 = R.drawable.t4_6;
            img7 = R.drawable.t4_7;
            img8 = R.drawable.t4_8;
            img9 = R.drawable.t4_1_2;
            img10 = R.drawable.t4_2_2;
            img11 = R.drawable.t4_3_2;
            img12 = R.drawable.t4_4_2;
            img13 = R.drawable.t4_5_2;
            img14 = R.drawable.t4_6_2;
            img15 = R.drawable.t4_7_2;
            img16 = R.drawable.t4_8_2;*/
        }
        else if (theme == "fairytail")
        {
            /*img1 = R.drawable.t5_1;
            img2 = R.drawable.t5_2;
            img3 = R.drawable.t5_3;
            img4 = R.drawable.t5_4;
            img5 = R.drawable.t5_5;
            img6 = R.drawable.t5_6;
            img7 = R.drawable.t5_7;
            img8 = R.drawable.t5_8;
            img9 = R.drawable.t5_1_2;
            img10 = R.drawable.t5_2_2;
            img11 = R.drawable.t5_3_2;
            img12 = R.drawable.t5_4_2;
            img13 = R.drawable.t5_5_2;
            img14 = R.drawable.t5_6_2;
            img15 = R.drawable.t5_7_2;
            img16 = R.drawable.t5_8_2;*/
        }
        else if (theme == "onepiece")
        {
            /*img1 = R.drawable.t6_1;
            img2 = R.drawable.t6_2;
            img3 = R.drawable.t6_3;
            img4 = R.drawable.t6_4;
            img5 = R.drawable.t6_5;
            img6 = R.drawable.t6_6;
            img7 = R.drawable.t6_7;
            img8 = R.drawable.t6_8;
            img9 = R.drawable.t6_1_2;
            img10 = R.drawable.t6_2_2;
            img11 = R.drawable.t6_3_2;
            img12 = R.drawable.t6_4_2;
            img13 = R.drawable.t6_5_2;
            img14 = R.drawable.t6_6_2;
            img15 = R.drawable.t6_7_2;
            img16 = R.drawable.t6_8_2;*/
        }
        else if (theme == "superman")
        {
            /*img1 = R.drawable.t7_1;
            img2 = R.drawable.t7_2;
            img3 = R.drawable.t7_3;
            img4 = R.drawable.t7_4;
            img5 = R.drawable.t7_5;
            img6 = R.drawable.t7_6;
            img7 = R.drawable.t7_7;
            img8 = R.drawable.t7_8;
            img9 = R.drawable.t7_1_2;
            img10 = R.drawable.t7_2_2;
            img11 = R.drawable.t7_3_2;
            img12 = R.drawable.t7_4_2;
            img13 = R.drawable.t7_5_2;
            img14 = R.drawable.t7_6_2;
            img15 = R.drawable.t7_7_2;
            img16 = R.drawable.t7_8_2;*/
        }
        else if (theme == "spiderman")
        {
            /*img1 = R.drawable.t8_1;
            img2 = R.drawable.t8_2;
            img3 = R.drawable.t8_3;
            img4 = R.drawable.t8_4;
            img5 = R.drawable.t8_5;
            img6 = R.drawable.t8_6;
            img7 = R.drawable.t8_7;
            img8 = R.drawable.t8_8;
            img9 = R.drawable.t8_1_2;
            img10 = R.drawable.t8_2_2;
            img11 = R.drawable.t8_3_2;
            img12 = R.drawable.t8_4_2;
            img13 = R.drawable.t8_5_2;
            img14 = R.drawable.t8_6_2;
            img15 = R.drawable.t8_7_2;
            img16 = R.drawable.t8_8_2;*/
        }
        else if (theme == "avengers")
        {
            /*img1 = R.drawable.t9_1;
            img2 = R.drawable.t9_2;
            img3 = R.drawable.t9_3;
            img4 = R.drawable.t9_4;
            img5 = R.drawable.t9_5;
            img6 = R.drawable.t9_6;
            img7 = R.drawable.t9_7;
            img8 = R.drawable.t9_8;
            img9 = R.drawable.t9_1_2;
            img10 = R.drawable.t9_2_2;
            img11 = R.drawable.t9_3_2;
            img12 = R.drawable.t9_4_2;
            img13 = R.drawable.t9_5_2;
            img14 = R.drawable.t9_6_2;
            img15 = R.drawable.t9_7_2;
            img16 = R.drawable.t9_8_2;*/
        }
    }


    //définition des themes

    private void definitionTheme()
    {
        int unNbRandom = rand.nextInt(16);
        //BD
        //Tintin
        if (theme == "tintin")
        {
            //instancie les images dans un tableau
            imgTheme = new int[] {R.drawable.t1_1, R.drawable.t1_2, R.drawable.t1_3, R.drawable.t1_4, R.drawable.t1_5, R.drawable.t1_6, R.drawable.t1_7, R.drawable.t1_8, R.drawable.t1_1_2, R.drawable.t1_2_2, R.drawable.t1_3_2, R.drawable.t1_4_2, R.drawable.t1_5_2, R.drawable.t1_6_2, R.drawable.t1_7_2, R.drawable.t1_8_2};
        }
        //Titeuf
        else if (theme == "titeuf")
        {
            //instancie les images dans un tableau
            imgTheme = new int[] {R.drawable.t2_1, R.drawable.t2_2, R.drawable.t2_3, R.drawable.t2_4, R.drawable.t2_5, R.drawable.t2_6, R.drawable.t2_7, R.drawable.t2_8, R.drawable.t2_1_2, R.drawable.t2_2_2, R.drawable.t2_3_2, R.drawable.t2_4_2, R.drawable.t2_5_2, R.drawable.t2_6_2, R.drawable.t2_7_2, R.drawable.t2_8_2};
        }
        //Simson
        else if (theme == "simpson")
        {
            //instancie les images dans un tableau
            //imgtheme = new int[] {R.drawable.s3_1, R.drawable.s3_2, R.drawable.s3_3, R.drawable.s3_4, R.drawable.s3_5, R.drawable.s3_6, R.drawable.s3_7, R.drawable.s3_8, R.drawable.t3_1_2, R.drawable.t3_2_2, R.drawable.t3_3_2, R.drawable.t3_4_2, R.drawable.t3_5_2, R.drawable.t3_6_2, R.drawable.t3_7_2, R.drawable.t3_8_2};
        }
        //Manga
        //Naruto
        else if (theme == "naruto")
        {
            //instancie les images dans un tableau
            //imgTheme = new int[] {R.drawable.n4_1, R.drawable.n4_2, R.drawable.n4_3, R.drawable.n4_4, R.drawable.n4_5, R.drawable.n4_6, R.drawable.n4_7, R.drawable.n4_8, R.drawable.t4_1_2, R.drawable.t4_2_2, R.drawable.t4_3_2, R.drawable.t4_4_2, R.drawable.t4_5_2, R.drawable.t4_6_2, R.drawable.t4_7_2, R.drawable.t4_8_2};
        }
        //Fairy Tail
        else if (theme == "fairytail")
        {
            //instancie les images dans un tableau
            //imgTheme = new int[] {R.drawable.f5_1, R.drawable.f5_2, R.drawable.f5_3, R.drawable.f5_4, R.drawable.f5_5, R.drawable.f5_6, R.drawable.f5_7, R.drawable.f5_8, R.drawable.t5_1_2, R.drawable.t5_2_2, R.drawable.t5_3_2, R.drawable.t5_4_2, R.drawable.t5_5_2, R.drawable.t5_6_2, R.drawable.t5_7_2, R.drawable.t5_8_2};
        }
        //One Piece
        else if (theme == "onepiece")
        {
            //instancie les images dans un tableau
            //imgTheme = new int[] {R.drawable.o6_1, R.drawable.o6_2, R.drawable.o6_3, R.drawable.o6_4, R.drawable.o6_5, R.drawable.o6_6, R.drawable.o6_7, R.drawable.o6_8, R.drawable.t6_1_2, R.drawable.t6_2_2, R.drawable.t6_3_2, R.drawable.t6_4_2, R.drawable.t6_5_2, R.drawable.t6_6_2, R.drawable.6_7_2, R.drawable.t6_8_2};
        }
        //Comics
        //Super Man
        else if (theme == "superman")
        {
            //instancie les images dans un tableau
            //imgTheme = new int[] {R.drawable.s7_1, R.drawable.s7_2, R.drawable.s7_3, R.drawable.s7_4, R.drawable.s7_5, R.drawable.s7_6, R.drawable.s7_7, R.drawable.s7_8, R.drawable.t7_1_2, R.drawable.t7_2_2, R.drawable.t7_3_2, R.drawable.t7_4_2, R.drawable.t7_5_2, R.drawable.t7_6_2, R.drawable.t7_7_2, R.drawable.t7_8_2};
        }
        //Spider Man
        else if (theme == "spiderman")
        {
            //instancie les images dans un tableau
            //imgTheme = new int[] {R.drawable.s8_1, R.drawable.s8_2, R.drawable.s8_3, R.drawable.s8_4, R.drawable.s8_5, R.drawable.s8_6, R.drawable.s8_7, R.drawable.s8_8, R.drawable.t8_1_2, R.drawable.t8_2_2, R.drawable.t8_3_2, R.drawable.t8_4_2, R.drawable.t8_5_2, R.drawable.t8_6_2, R.drawable.t8_7_2, R.drawable.t8_8_2};
        }
        //Avenger
        else if (theme == "avengers")
        {
            //instancie les images dans un tableau
            //imgTheme = new int[] {R.drawable.a9_1, R.drawable.a9_2, R.drawable.a9_3, R.drawable.a9_4, R.drawable.a9_5, R.drawable.a9_6, R.drawable.a9_7, R.drawable.a9_8, R.drawable.t9_1_2, R.drawable.t9_2_2, R.drawable.t9_3_2, R.drawable.t9_4_2, R.drawable.t9_5_2, R.drawable.t9_6_2, R.drawable.t9_7_2, R.drawable.t9_8_2};
        }
    }

}
