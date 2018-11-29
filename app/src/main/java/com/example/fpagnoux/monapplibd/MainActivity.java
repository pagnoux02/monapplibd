package com.example.fpagnoux.monapplibd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText saisie;
    private String pseudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button valider = this.findViewById(R.id.buttValider);
        valider.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        saisie = this.findViewById(R.id.SaisiPseudo);
        pseudo = saisie.getText().toString();

//
    }
}
