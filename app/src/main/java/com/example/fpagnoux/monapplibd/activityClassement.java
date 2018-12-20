package com.example.fpagnoux.monapplibd;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;
import java.util.ArrayList;


public class activityClassement extends AppCompatActivity {
    private TextView test;
    private MySQLiteOpenHelper cmd;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classement);

        //String leTheme = this.getIntent().getExtras().getString("Theme");

       /* GridView gridView = (GridView)findViewById(R.id.grid_view);
        rankAdapter RankAdapter = new rankAdapter(this, convert(cmd.getLesScores()));
        gridView.setAdapter(RankAdapter);*/
    }
    public rank[] convert(ArrayList<rank> uneListe) {
        int i = 0;
        rank[] desRanks = {};
        while (i < 11) {
            desRanks = uneListe.toArray(new rank[i]);
            i += 1;
        }
        return desRanks;
    }
}
