package com.example.fpagnoux.monapplibd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String pseudo;
    private int num;
    private ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9;
    private String theme;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button buttClass = this.findViewById(R.id.buttClass);
        buttClass.setOnClickListener(this);

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

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttClass:
                EditText saisie = this.findViewById(R.id.SaisiPseudo);
                pseudo = saisie.getText().toString();
                rank(num);
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
    }

    private void rank(int unNumQ){
        Intent unIntent = new Intent(this, activityClassement.class);
        unIntent.putExtra("Joueur", pseudo);
        unIntent.putExtra("Numero", unNumQ);
        unIntent.putExtra("Theme", theme);
        int cFenetre = 20;
        this.startActivityForResult(unIntent, cFenetre);
    }

}



