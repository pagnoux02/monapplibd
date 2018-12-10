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


import java.util.List;
import java.util.Random;
import java.util.Timer;

public class reneActivity  extends AppCompatActivity implements View.OnClickListener {
    // creation d'un nombre aleatoir
    Random rand = new Random();
    int n = rand.nextInt(3);

    //liste avec les 3 image ( pour l'aleatoir ) + 1 image de base
    private int[] imgdujeu = new int[]{android.R.drawable.sym_def_app_icon, android.R.drawable.star_big_off, android.R.drawable.star_big_on, android.R.drawable.checkbox_off_background};


    private ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9;
    private ImageView imgpnt1,imgpnt2,imgptn3;

    // private ImageView listimgaview[] = img1 ,img2 ,img3,img4,img5,img6,img7,img8,img9;

    //   private List l = new LinkedList(img1,img2,img3,img4,img5,img6,img7,img8,img9);
    private TextView text;
    private int score = 0;
    private String theme;
    private Button start;
    private Boolean jeu = false;

    private int i ;


    private TextView Timer;
    private int letempstotal = 60;

    private int place, imgalea ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rene_la_bd);

        text = (TextView) findViewById(R.id.txtscore);
        start = (Button) findViewById(R.id.btnstart);


        Timer = (TextView) findViewById(R.id.txttimer);
        // text.setText(String.valueOf( listimgaview[1]));
        start.setOnClickListener(this);




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


    }
    //attribution des points par images
public void pointparimg(int i){
    String ok = "img"+i;
  ImageView[] imgdelacase = new ImageView[]{img1,img2,img3,img4, img5, img6, img7, img8, img9};

    if ((int) imgdelacase[i].getTag() == android.R.drawable.sym_def_app_icon) {
        score = score + -5;
    }
    if ((int) imgdelacase[i].getTag() == android.R.drawable.star_big_off) {
        score = score + 5;
    }
    if ((int) imgdelacase[i].getTag() == android.R.drawable.star_big_on) {
        score = score + 15;
    }
    text.setText(String.valueOf(score));
}

    //fonction qui s'active quand il y a un click
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            // verification du clique sur le bouton start
            case R.id.btnstart:
                letimer();
                jouer(1);

                break;
        }

        if (jeu == true) {


            switch (v.getId()) {
                    // atribution du score en fonction de l'image et de la place

                case R.id.imgjeu1:
                    pointparimg(0);
                    jeu = false;
                    break;
                case R.id.imgjeu2:
                    pointparimg(1);
                    jeu = false;
                    break;
                case R.id.imgjeu3:
                    pointparimg(2);
                    jeu = false;
                    break;
                case R.id.imgjeu4:
                    pointparimg(3);
                    jeu = false;
                    break;
                case R.id.imgjeu5:
                    pointparimg(4);
                    jeu = false;
                    break;
                case R.id.imgjeu6://
                    pointparimg(5);
                    jeu = false;
                    break;
                case R.id.imgjeu7:
                    pointparimg(6);
                    jeu = false;
                    break;
                case R.id.imgjeu8:
                    pointparimg(7);
                    jeu = false;
                    break;
                case R.id.imgjeu9:
                    pointparimg(8);
                    jeu = false;
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
            if (letempstotal > 0 ) {

                Handler unHandler = new Handler();
                unHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        jouer(1);

                    }
                }, 4000);


            }
            else {
             jeu = false;
             letempstotal = 60;

            }

        }



    // affectation des image au differente case
    public void personnagejouer(int monimg1, int monimg2, int monimg3, int monimg4, int monimg5, int monimg6, int monimg7, int monimg8, int monimg9) {


        img1.setImageResource(imgdujeu[monimg1]);
        //affectation d'un tag pui permet de faire une comparaison par la suite
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


}







