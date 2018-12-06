package com.example.fpagnoux.monapplibd;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.Random;
import java.util.Timer;

public class reneActivity  extends AppCompatActivity implements View.OnClickListener {
    // creation d'un nombre aleatoir
    Random rand = new Random();
    int n = rand.nextInt(3);

    //liste avec les 3 image ( pour l'aleatoir ) + 1 image de base
    private int[] imgdujeu = new int[]{android.R.drawable.sym_def_app_icon, android.R.drawable.star_big_off, android.R.drawable.star_big_on, android.R.drawable.checkbox_off_background};


    private ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9;


    // private ImageView listimgaview[] = img1 ,img2 ,img3,img4,img5,img6,img7,img8,img9;

    //   private List l = new LinkedList(img1,img2,img3,img4,img5,img6,img7,img8,img9);
    private TextView text;
    private int score = 0;
    private String theme;
    private Button start;
    private Boolean jeu = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rene_la_bd);

        text = (TextView) findViewById(R.id.txtscore);
        start = (Button) findViewById(R.id.btnstart);

        // text.setText(String.valueOf( listimgaview[1]));
        start.setOnClickListener(this);

        // instancie les images
        img1 = (ImageView) findViewById(R.id.imgjeu1);
        img2 = (ImageView) findViewById(R.id.imgjeu2);
        img3 = (ImageView) findViewById(R.id.imgjeu3);
        img4 = (ImageView) findViewById(R.id.imgjeu4);
        img5 = (ImageView) findViewById(R.id.imgjeu5);
        img6 = (ImageView) findViewById(R.id.imgjeu6);
        img7 = (ImageView) findViewById(R.id.imgjeu7);
        img8 = (ImageView) findViewById(R.id.imgjeu8);
        img9 = (ImageView) findViewById(R.id.imgjeu9);


        //ajoute un evenement qui verifie le click sur les img
        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        img5.setOnClickListener(this);
        img6.setOnClickListener(this);
        img7.setOnClickListener(this);
        img8.setOnClickListener(this);
        img9.setOnClickListener(this);


    }


    //fonction qui s'active quand il y a un click
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnstart:

                jouer(1);

                break;
        }

        if (jeu == true) {


            switch (v.getId()) {

                case R.id.imgjeu1:
                    score++;
                    text.setText(String.valueOf(score));
                    break;
                case R.id.imgjeu2:
                    score = score + 15;
                    text.setText(String.valueOf(score));
                    break;
                case R.id.imgjeu3:
                    score = score + 30;
                    text.setText(String.valueOf(score));
                    break;
                case R.id.imgjeu4:
                    score = score + 30;
                    text.setText(String.valueOf(score));
                    break;
                case R.id.imgjeu5:
                    score = score + 45;
                    text.setText(String.valueOf(score));
                    break;
                case R.id.imgjeu6://
                    score = score + 60;
                    text.setText(String.valueOf(score));
                    break;

                case R.id.imgjeu7:
                    score = score + 75;
                    text.setText(String.valueOf(score));
                    break;
                case R.id.imgjeu8:
                    score = score + 90;
                    text.setText(String.valueOf(score));
                    break;
                case R.id.imgjeu9:
                    score = score + 105;
                    text.setText(String.valueOf(score));
                    break;
            }
        }

    }

    // Jouer peromet de generé 2 nbr aléatoir pour le choix de l'image et de la case de reception
    private void jouer(int theme) {
   
        jeu = true;
        int n = rand.nextInt(3);
        int imgjeuplace = rand.nextInt(9);


        switch (imgjeuplace) {

            case 0:
                personnagejouer(n, 3, 3, 3, 3, 3, 3, 3, 3);

                break;
            case 1:
                personnagejouer(3, n, 3, 3, 3, 3, 3, 3, 3);
                break;
            case 2:
                personnagejouer(3, 3, n, 3, 3, 3, 3, 3, 3);
                break;
            case 3:
                personnagejouer(3, 3, 3, n, 3, 3, 3, 3, 3);
                break;
            case 4:
                personnagejouer(3, 3, 3, 3, n, 3, 3, 3, 3);
                break;
            case 5:
                personnagejouer(3, 3, 3, 3, 3, n, 3, 3, 3);
                break;
            case 6:
                personnagejouer(3, 3, 3, 3, 3, 3, n, 3, 3);
                break;
            case 7:
                personnagejouer(3, 3, 3, 3, 3, 3, 3, n, 3);
                break;
            case 8:
                personnagejouer(3, 3, 3, 3, 3, 3, 3, 3, n);
                break;


        }
    }


    // affectation des image au differente case
    private void personnagejouer(int monimg1, int monimg2, int monimg3, int monimg4, int monimg5, int monimg6, int monimg7, int monimg8, int monimg9) {


        img1.setImageResource(imgdujeu[monimg1]);
        img2.setImageResource(imgdujeu[monimg2]);
        img8.setImageResource(imgdujeu[monimg3]);

        img8.setImageResource(imgdujeu[monimg4]);
        img8.setImageResource(imgdujeu[monimg5]);
        img8.setImageResource(imgdujeu[monimg6]);

        img8.setImageResource(imgdujeu[monimg7]);
        img8.setImageResource(imgdujeu[monimg8]);
        img9.setImageResource(imgdujeu[monimg9]);
    }

}







