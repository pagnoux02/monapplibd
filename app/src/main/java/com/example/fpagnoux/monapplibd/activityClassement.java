package com.example.fpagnoux.monapplibd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class activityClassement extends AppCompatActivity {
    private TextView test;
    private TextView afficher;
    private collectionScores bdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classement);

        String leTheme = this.getIntent().getExtras().getString("Theme");

        test = this.findViewById(R.id.viewPseudo);
        test.setText(leTheme);

        afficher = this.findViewById(R.id.affiche);
        afficher.setText(bdd.nb_elements());




    }
}
