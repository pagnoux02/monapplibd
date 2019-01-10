package com.example.fpagnoux.monapplibd;

import android.content.Intent;

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
    private String theme;
    int cFenetre = 20;
    private collectionScore unecollection = new collectionScore();
    private Button buttValider;

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

        unecollection.insertion_Score(getApplicationContext());

    }

    @Override
    public void onClick(View v) {
        TextView affich = this.findViewById(R.id.themeView);
        EditText saisie = this.findViewById(R.id.SaisiPseudo);
        switch (v.getId()) {
            case R.id.buttClass:
                pseudo = saisie.getText().toString();
                rank();
                break;
            case R.id.buttValider:
                pseudo = saisie.getText().toString();
                if((Math.random() * 6)==0) {
                    play();
                }
                else{
                    play();
                }
                break;
            case R.id.avengersView:
                theme = "avengers";
                break;
            case R.id.spidermanView:
                theme = "spiderman";
                break;
            case R.id.supermanView:
                theme = "superman";
                break;
            case R.id.simpsonView:
                theme = "simpson";
                break;
            case R.id.tintinView:
                theme = "tintin";
                break;
            case R.id.titeufView:
                theme = "titeuf";
                break;
            case R.id.fairytailView:
                theme = "fairytail";
                break;
            case R.id.narutoView:
                theme = "naruto";
                break;
            case R.id.onepieceView:
                theme = "onepiece";
                break;
        }
        affich.setText(theme);
        buttValider.setEnabled(true);
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



