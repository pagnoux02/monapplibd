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
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import java.util.List;
import java.util.Random;
import java.util.Timer;

public class reneActivity  extends AppCompatActivity implements View.OnClickListener {



    // creation d'un nombre aleatoir
    Random rand = new Random();
    int n = rand.nextInt( 3)+1;

    //liste avec les 3 image ( pour l'aleatoir ) + 1 image de base
    //private int[] imgdujeu = new int[]{android.R.drawable.sym_def_app_icon, android.R.drawable.star_big_off, android.R.drawable.star_big_on, android.R.drawable.checkbox_off_background};

   // private int[] imgdujeu = new int[]{R.drawable.t_1_fr, R.drawable.t_2_fr, R.drawable.t_3_fr, android.R.drawable.checkbox_off_background};
     // private int[] imgdujeu = new int[]{R.drawable.ti_1_fr, R.drawable.ti_2_frr, R.drawable.ti_3_fr, android.R.drawable.checkbox_off_background};
      private int[] imgdujeu = new int[]{android.R.drawable.checkbox_off_background ,R.drawable.s_1_fr, R.drawable.s_2_fr, R.drawable.s_3_fr ,R.drawable.ti_1_fr, R.drawable.ti_2_frr, R.drawable.ti_3_fr,R.drawable.t_1_fr, R.drawable.t_2_fr, R.drawable.t_3_fr,R.drawable.a_1_fr,R.drawable.a_2_fr,R.drawable.a_3_fr,R.drawable.sp_fr,R.drawable.sp_2_frr,R.drawable.sp_3_fr,R.drawable.su_1_fr,R.drawable.su_2_frr,R.drawable.su_3_fr,R.drawable.fai_1_fr,R.drawable.fai_2_frr,R.drawable.fai_3_fre, R.drawable.na_1_fr,R.drawable.na_2_fr,R.drawable.na_3_fr, R.drawable.one_1_frr,R.drawable.one_2_fr,R.drawable.one_3_fr};

  //  android.R.drawable.checkbox_off_background
    private ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9;
    private ImageView imgpnt1,imgpnt2,imgpnt3;



    private TextView text;
    private int score = 0;
    private Button start;
    private Boolean jeu = false;



    private String leTheme ,lePseudo ;





    private TextView test, pseudo , niveau;


    private boolean eststart =true ;
    private int i ;


    private TextView Timer;
    private int letempstotal = 60, tempsapparition;

    private int place, imgalea ;


    private rank joueur;
    //private MySQLiteOpenHelper cmd;


        // contien tout les imageview de jeu

    // TEST
    long animationDuration = 1000;
    private int nbdelacase;
    private float trans;
   
    //TEST


    private ProgressBar timerbar;
    //bouton choix du mode
    private Button facile , moyen,difficile ;
    private int modedejeu = 0;

    private int montheme;


    private int nbrindeximg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rene_la_bd);

        niveau = (TextView) findViewById(R.id.txtniveau);
        text = (TextView) findViewById(R.id.txtscore);
        start = (Button) findViewById(R.id.btnstart);

        timerbar = (ProgressBar)findViewById(R.id.progresstimer) ;

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


        // ajout d'un nombre à n afin de modifier la recherche  dans la list d'image en fonction des themes


        switch (leTheme){
            case "simpson":
                nbrindeximg=1;
                break;
            case "titeuf":
                nbrindeximg=4;
                break;
            case "tintin":
                nbrindeximg=7;
                break;
            case "avengers":
                nbrindeximg=10;

                break;
            case  "spiderman":
                nbrindeximg=13;
                break;
            case  "superman":
                nbrindeximg=16;
                break;

            case  "fairytail":
                nbrindeximg=19;
                break;
            case "naruto":
                nbrindeximg=22;
                break;
            case"onepiece":
                nbrindeximg=25;
                break;
        }

        imgpnt1.setImageResource(imgdujeu[nbrindeximg]);
        imgpnt2.setImageResource(imgdujeu[nbrindeximg+1]);
        imgpnt3.setImageResource(imgdujeu[nbrindeximg+2]);



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



        //ajoute un evenement  click sur les img
        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        img5.setOnClickListener(this);
        img6.setOnClickListener(this);
        img7.setOnClickListener(this);
        img8.setOnClickListener(this);
        img9.setOnClickListener(this);

        facile = (Button)findViewById(R.id.btnFacile);
        moyen = (Button)findViewById(R.id.btnMoyen);
        difficile= (Button)findViewById(R.id.btnDifficile);

        facile.setOnClickListener(this);
        moyen.setOnClickListener(this);
        difficile.setOnClickListener(this);

        test = this.findViewById(R.id.txttheme);
        test.setText(leTheme);
        pseudo = this.findViewById(R.id.txtpseudo);
        pseudo.setText(lePseudo);


      


    }

    //attribution des points par images

public void pointparimg(int i){

    ImageView[] imgdelacase = new ImageView[]{img1,img2,img3,img4, img5, img6, img7, img8, img9};
    if ((int) imgdelacase[i].getTag() ==imgdujeu[nbrindeximg]) {
        score = score + -5;
        jeu = false;
        animation(i);

    }
    if ((int) imgdelacase[i].getTag() == imgdujeu[nbrindeximg+1] ){
        score = score + 5;
        jeu = false;
        animation(i);
    }
    if ((int) imgdelacase[i].getTag() == imgdujeu[nbrindeximg+2]) {
        score = score + 15;
        jeu = false;
        animation(i);
    }
    text.setText(String.valueOf(score));

}

    //fonction qui s'active quand il y a un clic
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
                // determine le niveau  de difficulté
            case R.id.btnFacile:
                modedejeu =1;
                niveau.setText("Facile");
                break;
            case R.id.btnMoyen:
                modedejeu =2;
                niveau.setText("Moyen");
                break;
            case R.id.btnDifficile:
                modedejeu =3;
                niveau.setText("Difficile");
                break;

            // verification du clique sur le bouton start
            case R.id.btnstart:

                if (modedejeu != 0  ){
                // verification si le jeu est deja en fonctionnement

                    if (eststart == true ) {
                        score = 0;
                    text.setText(String.valueOf(score));
                    letimer();

                    jouer(leTheme,modedejeu);
                    eststart = false;
                 //   handleAnimation(imgpnt1);
                        facile.setVisibility(View.INVISIBLE);
                        moyen.setVisibility(View.INVISIBLE);
                        difficile.setVisibility(View.INVISIBLE);

                        start.setVisibility(View.INVISIBLE);
                }}
                break;
        }
         // Si le jeu est en c ours de deroulement
        if (jeu == true) {


            switch (v.getId()) {
                    // attribution du score en fonction de l'image et de la place

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

    // Jouer permet de générer 2 nbr aléatoires 1 pour le choix de l'image et 1 de la case de reception
    private void jouer( String theme, int unmodedejeu) {

        //generation aleatoire pour l'image et la case ou elle va se trouver
        int n = rand.nextInt(3)+1;
        int imgjeuplace = rand.nextInt(9);


        switch (modedejeu){
            case 1:
                tempsapparition = 3000;
                break;
            case 2:
                tempsapparition = 1500;
                break;
            case 3:
                tempsapparition = 900;
                break;

        }

        // ajout d'un nombre à n afin de modifier la recherche  dans la list d'image en fonction des themes
        switch (theme){
            case "simpson":

                break;
            case "titeuf":
                    n = n+3;
                break;
            case "tintin":
                    n = n+6;
                break;
            case "avengers":
                    n = n+9;
                break;
            case  "spiderman":
                n = n+12;
                break;
            case  "superman":
                n = n+15;
                break;
            case  "fairytail":
                n = n+ 18;
                break;
            case "naruto":
                n= n+21;
                break;
            case"onepiece":
                n = n+24;
                break;
        }
        jeu = true;




        place = imgjeuplace;
        imgalea = n;
        //text.setText(String.valueOf(n));

        switch (imgjeuplace) {

            case 0:

                personnagejouer(n, 0, 0, 0, 0,0, 0,0, 0);

                break;
            case 1:


                personnagejouer(0, n, 0, 0, 0, 0, 0, 0, 0);
                break;
            case 2:

                personnagejouer(0, 0, n, 0, 0, 0, 0,0, 0);
                break;
            case 3:

               personnagejouer(0, 0, 0, n, 0, 0, 0, 0, 0);
                break;
            case 4:

                personnagejouer(0, 0, 0, 0, n, 0, 0, 0, 0);
                break;
            case 5:

                personnagejouer(0, 0, 0, 0, 0, n, 0, 0, 0);
                break;
            case 6:

                personnagejouer( 0, 0,0, 0,0 , 0, n, 0, 0);
                break;
            case 7:

                personnagejouer(0, 0, 0, 0, 0, 0, 0, n,0);
                break;
            case 8:

                personnagejouer(0, 0, 0, 0, 0, 0, 0, 0, n);
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
                        jouer(leTheme,modedejeu);
                        ImageView[] imgdelacase = new ImageView[]{img1,img2,img3,img4, img5, img6, img7, img8, img9};



                      imgdelacase[nbdelacase].animate().alpha(1);

                    }
                },  tempsapparition);


            }
            // remet au valeur par defaut
            else {

             jeu = false;
             letempstotal = 60;
             personnagejouer(0,0, 0, 0, 0,0, 0, 0, 0);
             modedejeu = 1;
             eststart = true;

                facile.setVisibility(View.VISIBLE);
                moyen.setVisibility(View.VISIBLE);
                difficile.setVisibility(View.VISIBLE);
                start.setVisibility(View.VISIBLE);
            }

        }


    // affectation des image aux differentes cases
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
//
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

        timerbar.setProgress(letempstotal);

    }}


public void animation (int i){




    ImageView[] imgdelacase = new ImageView[]{img1,img2,img3,img4, img5, img6, img7, img8, img9};
    //uneImage3.animate().translationX(400);

    imgdelacase[i].animate().translationY(500).setDuration(300);

    nbdelacase = i ;

    imgdelacase[i].animate().translationY(300).withStartAction(new Runnable(){
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
            imgdelacase[0].setY(838);
            imgdelacase[1].setY(838);
            imgdelacase[2].setY(838);
            imgdelacase[3].setY(1158);
            imgdelacase[4].setY(1158);
            imgdelacase[5].setY(1158);
            imgdelacase[6].setY(1490);
            imgdelacase[7].setY(1490);
            imgdelacase[8].setY(1490);

            // 838   1158  1490
        }
    } );
}}















