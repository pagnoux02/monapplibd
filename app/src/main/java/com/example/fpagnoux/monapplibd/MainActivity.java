package com.example.fpagnoux.monapplibd;

import android.content.Intent;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.Math;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private String pseudo;
    private ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9;
    private ImageView imgborder1,imgborder2,imgborder3,imgborder4,imgborder5,imgborder6,imgborder7,imgborder8,imgborder9;
    private String theme;
    int cFenetre = 20;
    private collectionScore unecollection = new collectionScore();
    private Button buttValider;
    private TextView lepseudo;
    private  int start =1;
    private  int vert = Color.parseColor("#C72C48"), noir = Color.parseColor("#000000"); //The color u want
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button buttClass = this.findViewById(R.id.buttClass);
        buttClass.setOnClickListener(this);

        buttValider = this.findViewById(R.id.buttValider);
        buttValider.setOnClickListener(this);
        buttValider.setEnabled(false);

        img1 = this.findViewById(R.id.avengersView);
        img1.setOnClickListener(this);

        img2 = this.findViewById(R.id.spidermanView);
        img2.setOnClickListener(this);

        img3 = this.findViewById(R.id.supermanView);
        img3.setOnClickListener(this);

        img4 = this.findViewById(R.id.simpsonView);
        img4.setOnClickListener(this);

        img5 = this.findViewById(R.id.tintinView);
        img5.setOnClickListener(this);

        img6 = this.findViewById(R.id.titeufView);
        img6.setOnClickListener(this);

        img7 = this.findViewById(R.id.fairytailView);
        img7.setOnClickListener(this);

        img8 = this.findViewById(R.id.narutoView);
        img8.setOnClickListener(this);

        img9 = this.findViewById(R.id.onepieceView);
        img9.setOnClickListener(this);

        imgborder1 = this.findViewById(R.id.imgbord1);
        imgborder2 = this.findViewById(R.id.imgbord2);
        imgborder3 = this.findViewById(R.id.imgbord3);
        imgborder4 = this.findViewById(R.id.imgbord4);
        imgborder5 = this.findViewById(R.id.imgbord5);
        imgborder6 = this.findViewById(R.id.imgbord6);
        imgborder7 = this.findViewById(R.id.imgbord7);
        imgborder8 = this.findViewById(R.id.imgbord8);
        imgborder9 = this.findViewById(R.id.imgbord9);

        lepseudo = this.findViewById(R.id.SaisiPseudo);
        lepseudo.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {


        TextView affich = this.findViewById(R.id.themeView);
        EditText saisie = this.findViewById(R.id.SaisiPseudo);


        switch (v.getId()) {

            case R.id.SaisiPseudo:
                if (start == 1) {
                    lepseudo.setText("");
                    start = 0;
                }
                break;
            case R.id.buttClass:
                pseudo = saisie.getText().toString();
                rank();
                break;
            case R.id.buttValider:
                pseudo = saisie.getText().toString();
                if (Math.random() > 0.5) {
                    play();
                } else {
                    //playMemo
                    play();

                }
                break;
            case R.id.avengersView:
                theme = "avengers";
                bordercolor(vert, noir, noir, noir, noir, noir, noir, noir, noir);

                break;
            case R.id.spidermanView:
                theme = "spiderman";
                bordercolor(noir, vert, noir, noir, noir, noir, noir, noir, noir);

                break;
            case R.id.supermanView:
                theme = "superman";
                bordercolor(noir, noir, vert, noir, noir, noir, noir, noir, noir);

                break;
            case R.id.simpsonView:
                theme = "simpson";
                bordercolor(noir, noir, noir, vert, noir, noir, noir, noir, noir);

                break;
            case R.id.tintinView:
                theme = "tintin";
                bordercolor(noir, noir, noir, noir, vert, noir, noir, noir, noir);

                break;
            case R.id.titeufView:
                theme = "titeuf";
                bordercolor(noir, noir, noir, noir, noir, vert, noir, noir, noir);

                break;
            case R.id.fairytailView:
                theme = "fairytail";
                bordercolor(noir, noir, noir, noir, noir, noir, vert, noir, noir);

                break;
            case R.id.narutoView:
                theme = "naruto";
                bordercolor(noir, noir, noir, noir, noir, noir, noir, vert, noir);

                break;
            case R.id.onepieceView:
                theme = "onepiece";
                bordercolor(noir, noir, noir, noir, noir, noir, noir, noir, vert);

                break;
        }
        affich.setText(theme);
        buttValider.setEnabled(true);
    }
public void bordercolor( int a ,int b,int c ,int d ,int e  ,int f  ,int g  ,int h  ,int i){ //int a ,int b,int c ,int d ,int e  ,int f  ,int g  ,int h  ,int i


    // lineColorCode.setColorFilter(color);
    imgborder1.setColorFilter(a);
    imgborder2.setColorFilter(b);
    imgborder3.setColorFilter(c);
    imgborder4.setColorFilter(d);
    imgborder5.setColorFilter(e);
    imgborder6.setColorFilter(f);
    imgborder7.setColorFilter(g);
    imgborder8.setColorFilter(h);
    imgborder9.setColorFilter(i);
  /*  imgborder1.setColorFilter(noir);
    imgborder2.setColorFilter(vert);
    imgborder3.setColorFilter(noir);
    imgborder4.setColorFilter(vert);
    imgborder5.setColorFilter(vert);
    imgborder6.setColorFilter(vert);
    imgborder7.setColorFilter(vert);
    imgborder8.setColorFilter(vert);
    imgborder9.setColorFilter(vert);*/

}


    private void rank(){
        Intent unIntent = new Intent(MainActivity.this, activityClassement.class);
        unIntent.putExtra("Joueur", pseudo);
        unIntent.putExtra("Theme", theme);
        this.startActivityForResult(unIntent, cFenetre);
    }

    private void play(){
        Intent unIntent = new Intent(MainActivity.this, reneActivity.class);
        unIntent.putExtra("Joueur", pseudo);
        unIntent.putExtra("Theme", theme);
        this.startActivityForResult(unIntent, cFenetre);
    }



}



