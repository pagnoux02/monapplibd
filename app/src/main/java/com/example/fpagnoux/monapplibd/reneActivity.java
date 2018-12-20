package com.example.fpagnoux.monapplibd;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;
import java.util.Random;
import java.util.Timer;

public class reneActivity  extends AppCompatActivity implements View.OnClickListener {
    // creation d'un nombre aleatoir
    Random rand = new Random();
    int n = rand.nextInt( 3);

    //liste avec les 3 image ( pour l'aleatoir ) + 1 image de base
    private int[] imgdujeu = new int[]{android.R.drawable.sym_def_app_icon, android.R.drawable.star_big_off, android.R.drawable.star_big_on, android.R.drawable.checkbox_off_background};

  //  android.R.drawable.checkbox_off_background
    private ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9;
    private ImageView imgpnt1,imgpnt2,imgpnt3;




    private TextView text;
    private int score = 0;
    private Button start;
    private Boolean jeu = false;

    private String leTheme;
    private String lePseudo;

    //hugo
    private TextView test;
    private TextView pseudo;

    private boolean eststart =true ;
    private int i ;


    private TextView Timer;
    private int letempstotal = 60;

    private int place, imgalea ;

        // contien tout les imageview de jeu

    // TEST
    long animationDuration = 1000;
    private int nbdelacase;
    private float trans;
   
    //TEST


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rene_la_bd);

        text = (TextView) findViewById(R.id.txtscore);
        start = (Button) findViewById(R.id.btnstart);


        Timer = (TextView) findViewById(R.id.txttimer);
        // text.setText(String.valueOf( listimgaview[1]));
        start.setOnClickListener(this);


        //hugo
        leTheme = this.getIntent().getExtras().getString("Theme");
        lePseudo = this.getIntent().getExtras().getString("Joueur");

        // instancie les images

        // imageview qui contient les images afin dans la zone de score
        imgpnt1 =  (ImageView) findViewById(R.id.imgpts1);
        imgpnt2 =  (ImageView) findViewById(R.id.imgpts2);
        imgpnt3 =  (ImageView) findViewById(R.id.imgpts3);

        imgpnt1.setImageResource(imgdujeu[0]);
        imgpnt2.setImageResource(imgdujeu[1]);
        imgpnt3.setImageResource(imgdujeu[2]);

        // instancie les images ou l'utilisateur devra cliquer

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


        test = this.findViewById(R.id.txttheme);
        test.setText(leTheme);
        pseudo = this.findViewById(R.id.txtpseudo);
        pseudo.setText(lePseudo);


      


    }

    //attribution des points par images

public void pointparimg(int i){

    ImageView[] imgdelacase = new ImageView[]{img1,img2,img3,img4, img5, img6, img7, img8, img9};
    if ((int) imgdelacase[i].getTag() == android.R.drawable.sym_def_app_icon) {
        score = score + -5;
        jeu = false;
        animation(i);

    }
    if ((int) imgdelacase[i].getTag() == android.R.drawable.star_big_off) {
        score = score + 5;
        jeu = false;
        animation(i);
    }
    if ((int) imgdelacase[i].getTag() == android.R.drawable.star_big_on) {
        score = score + 15;
        jeu = false;
        animation(i);
    }
    text.setText(String.valueOf(score));

}

    //fonction qui s'active quand il y a un click
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            // verification du clique sur le bouton start
            case R.id.btnstart:

                // verification si le jeu est deja en fonctionnement
                    score = 0;
                    if (eststart == true ) {
                    text.setText(String.valueOf(score));
                    letimer();
                    jouer(1);
                    eststart = false;
                 //   handleAnimation(imgpnt1);
                }
                break;
        }

        if (jeu == true) {


            switch (v.getId()) {
                    // atribution du score en fonction de l'image et de la place

                case R.id.imgjeu1:
                    pointparimg(0);
               //     animation(1);

                    break;
                case R.id.imgjeu2:
                    pointparimg(1);

                    break;
                case R.id.imgjeu3:
                    pointparimg(2);

                    break;
                case R.id.imgjeu4:
                    pointparimg(3);

                    break;
                case R.id.imgjeu5:
                    pointparimg(4);

                    break;
                case R.id.imgjeu6://
                    pointparimg(5);

                    break;
                case R.id.imgjeu7:
                    pointparimg(6);

                    break;
                case R.id.imgjeu8:
                    pointparimg(7);

                    break;
                case R.id.imgjeu9:
                    pointparimg(8);

                    break;




            }
        }

    }

    // Jouer peromet de generé 2 nbr aléatoir pour le choix de l'image et de la case de reception
    private void jouer(final int theme) {



        jeu = true;

        int n = rand.nextInt(3);
        int imgjeuplace = rand.nextInt(9);


        place = imgjeuplace;
        imgalea = n;
        //text.setText(String.valueOf(n));

        switch (imgjeuplace) {

            case 0:
             //   img1.setImageResource(imgdujeu[n]);
                personnagejouer(n, 3, 3, 3, 3, 3, 3, 3, 3);

                break;
            case 1:
               // img2.setImageResource(imgdujeu[n]);

                personnagejouer(3, n, 3, 3, 3, 3, 3, 3, 3);
                break;
            case 2:
               // img3.setImageResource(imgdujeu[n]);
                personnagejouer(3, 3, n, 3, 3, 3, 3, 3, 3);
                break;
            case 3:
               // img4.setImageResource(imgdujeu[n]);
               personnagejouer(3, 3, 3, n, 3, 3, 3, 3, 3);
                break;
            case 4:
              //  img5.setImageResource(imgdujeu[n]);
                personnagejouer(3, 3, 3, 3, n, 3, 3, 3, 3);
                break;
            case 5:
               // img6.setImageResource(imgdujeu[n]);
                personnagejouer(3, 3, 3, 3, 3, n, 3, 3, 3);
                break;
            case 6:
                //img7.setImageResource(imgdujeu[n]);
                personnagejouer(3, 3, 3, 3, 3, 3, n, 3, 3);
                break;
            case 7:
              //  img8.setImageResource(imgdujeu[n]);
                personnagejouer(3, 3, 3, 3, 3, 3, 3, n, 3);
                break;
            case 8:
             //   img9.setImageResource(imgdujeu[n]);
                personnagejouer(3, 3, 3, 3, 3, 3, 3, 3, n);
                break;
        }
            // permet de refaire la fonction jouer tout les X temps
         //  int  alea = (rand.nextInt((5 - 2) + 1) + 2);
        //    alea = alea * 1000;
            if (letempstotal > 0 ) {

                Handler unHandler = new Handler();
                unHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        jouer(1);
                        ImageView[] imgdelacase = new ImageView[]{img1,img2,img3,img4, img5, img6, img7, img8, img9};



                      imgdelacase[nbdelacase].animate().alpha(1);

                    }
                },  3000);


            }
            // remet au valeur par defaut
            else {

             jeu = false;
             letempstotal = 60;
             personnagejouer(3, 3, 3, 3, 3, 3, 3, 3, 3);

             eststart = true;


            }

        }


    // affectation des image au differente case
    public void personnagejouer(int monimg1, int monimg2, int monimg3, int monimg4, int monimg5, int monimg6, int monimg7, int monimg8, int monimg9) {


        img1.setImageResource(imgdujeu[monimg1]);
        //affectation d'un tag qui permet de faire une comparaison par la suite
        img1.setTag(imgdujeu[monimg1]);
      
        img2.setImageResource(imgdujeu[monimg2]);
        img2.setTag(imgdujeu[monimg2]);

        img3.setImageResource(imgdujeu[monimg3]);
        img3.setTag(imgdujeu[monimg3]);
     
        img4.setImageResource(imgdujeu[monimg4]);
        img4.setTag(imgdujeu[monimg4]);

        img5.setImageResource(imgdujeu[monimg5]);
        img5.setTag(imgdujeu[monimg5]);

        img6.setImageResource(imgdujeu[monimg6]);
        img6.setTag(imgdujeu[monimg6]);

        img7.setImageResource(imgdujeu[monimg7]);
        img7.setTag(imgdujeu[monimg7]);


        img8.setImageResource(imgdujeu[monimg8]);
        img8.setTag(imgdujeu[monimg8]);

        img9.setImageResource(imgdujeu[monimg9]);
        img9.setTag(imgdujeu[monimg9]);

    }

// affichage du temps sur 60s
    public void letimer (){
        letempstotal--;
        Timer.setText(String.valueOf(letempstotal+" / 60"));
        if (letempstotal >00 ){
        Handler unHandler = new Handler();
        unHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                letimer();

            }
        }, 1000);
    }}
/*
    public void handleAnimation(View view){
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(imgpnt1,"X",400f);

        animatorX.setDuration(animationDuration);
       AnimatorSet animatorSet = new AnimatorSet();
       animatorSet.playTogether(animatorX);
       animatorSet.start();


        Handler unHandler = new Handler();
        unHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ObjectAnimator animatorX2 = ObjectAnimator.ofFloat(imgpnt1,"X",200f);
                animatorX2.setDuration(animationDuration);
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.playTogether(animatorX2);
                animatorSet2.start();

            }
        }, 1000);
    }*/


public void animation (int i){


    ImageView[] imgdelacase = new ImageView[]{img1,img2,img3,img4, img5, img6, img7, img8, img9};
    //uneImage3.animate().translationX(400);

    imgdelacase[i].animate().translationY(500).setDuration(300);

    nbdelacase = i ;

    imgdelacase[i].animate().translationY(100).withStartAction(new Runnable(){
        public void run(){
            ImageView[] imgdelacase = new ImageView[]{img1,img2,img3,img4, img5, img6, img7, img8, img9};

            // do something
        }
    });
// EndAction

    imgdelacase[i].animate().alpha(0).withEndAction(new Runnable(){
        public void run(){
            // arraylist avec les imageview
            ImageView[] imgdelacase = new ImageView[]{img1,img2,img3,img4, img5, img6, img7, img8, img9};
            // affectation position Y par defaut de chaque imageview
            imgdelacase[0].setY(846);
            imgdelacase[1].setY(846);
            imgdelacase[2].setY(846);
            imgdelacase[3].setY(1272);
            imgdelacase[4].setY(1272);
            imgdelacase[5].setY(1272);
            imgdelacase[6].setY(1714);
            imgdelacase[7].setY(1714);
            imgdelacase[8].setY(1714);
        }
    } );
}}















