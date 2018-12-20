package com.example.fpagnoux.monapplibd;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.fpagnoux.monapplibd.R.layout.cell;

public class activityClassement extends AppCompatActivity {
    private TextView test;
    private MySQLiteOpenHelper cmd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classement);

        //String leTheme = this.getIntent().getExtras().getString("Theme");
        GridView grid = (GridView)findViewById(R.id.grid_view);
/*
        int i = 0;

        while(i<11){
            for (rank unRank: cmd.getLesScores()
                 ) {
                //grid.setAdapter(); ;
            }
            i+=1;
        }*/
    }
}
