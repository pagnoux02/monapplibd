package com.example.fpagnoux.monapplibd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class reneActivity  extends AppCompatActivity implements View.OnClickListener{
    Random rand = new Random();
    int n = rand.nextInt(4);

    private int[] imgdujeu = new int[] {android.R.drawable.star_on,android.R.drawable.star_big_off,android.R.drawable.star_big_on};

    private ImageView img1 ,img2 ,img3,img4,img5,img6,img7,img8,img9;
    private TextView text;
    private int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rene_la_bd);

        text = (TextView)findViewById(R.id.txtscore);

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
            case R.id.imgjeu1 :
                score++;
                text.setText(String.valueOf(score));
                break;
            case R.id.imgjeu2:
                score=score+15;
                text.setText(String.valueOf(score));
                break;
            case R.id.imgjeu3 :
                score=score+30;
                text.setText(String.valueOf(score));
                break;
            case R.id.imgjeu4 :
                score=score+30;
                text.setText(String.valueOf(score));
                break;
            case R.id.imgjeu5:
                score=score+45;
                text.setText(String.valueOf(score));
                break;
            case R.id.imgjeu6 :
                score=score+60;
                text.setText(String.valueOf(score));
                break;

            case R.id.imgjeu7 :
                score=score+75;
                text.setText(String.valueOf(score));
                break;
            case R.id.imgjeu8:
                score=score+90;
                text.setText(String.valueOf(score));
                break;
            case R.id.imgjeu9 :
                score=score+105;
                text.setText(String.valueOf(score));
                break;



        }
    }


}
