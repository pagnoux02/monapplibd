package com.example.fpagnoux.monapplibd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class activityClassement extends AppCompatActivity {
    private TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classement);

        String lePseudo = this.getIntent().getExtras().getString("Joueur");
        String leTheme = this.getIntent().getExtras().getString("Theme");

        test = this.findViewById(R.id.viewPseudo);
        test.setText(leTheme);




    }
}
