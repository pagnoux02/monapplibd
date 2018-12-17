package com.example.fpagnoux.monapplibd;

import android.database.MatrixCursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class activityClassement extends AppCompatActivity {
    private TextView test;
    private MySQLiteOpenHelper cmd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classement);

        String leTheme = this.getIntent().getExtras().getString("Theme");

        ListView Lv = findViewById(R.id.lv);
        // Définition des colonnes
        // NB : SimpleCursorAdapter a besoin obligatoirement d'un ID nommé "_id"
        String[] columns = new String[] { "_id", "col1", "col2", "col3" };

        // Définition des données du tableau
        // les lignes ci-dessous ont pour seul but de simuler
        // un objet de type Cursor pour le passer au SimpleCursorAdapter.
        // Si vos données sont issues d'une base SQLite,
        // utilisez votre "cursor" au lieu du "matrixCursor"
        MatrixCursor matrixCursor= new MatrixCursor(columns);
        startManagingCursor(matrixCursor);
        matrixCursor.addRow(new Object[] { 1,"1","Octar Belmoktar","10000000" });
        matrixCursor.addRow(new Object[] { 2,"2","Ben Laden","9999999" });
        matrixCursor.addRow(new Object[] { 3,"3","XxxDarkMaelitoxxX","55555" });
        matrixCursor.addRow(new Object[] { 4,"4","Manger avec les pieds","44444" });
        matrixCursor.addRow(new Object[] { 5,"5","loul","33333" });
        matrixCursor.addRow(new Object[] { 6,"6","Je suis francais pur souche","22222" });
        matrixCursor.addRow(new Object[] { 7,"7","abdel kader","11111" });
        matrixCursor.addRow(new Object[] { 8,"8","frere kouachi","10000" });
        matrixCursor.addRow(new Object[] { 9,"9","kalash nikoff","9995" });
        matrixCursor.addRow(new Object[] { 10,"10","Je suis clair de lune","9990" });

        // on prendra les données des colonnes 1 et 2...
        String[] from = new String[] {"col1", "col2", "col3"};

        // ...pour les placer dans les TextView définis dans "row_item.xml"
        int[] to = new int[] { R.id.textViewCol1, R.id.textViewCol2, R.id.textViewCol3};

        // création de l'objet SimpleCursorAdapter...
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.row_item, matrixCursor, from, to, 0);

        // ...qui va remplir l'objet ListView
        /*ArrayAdapter<rank> arrayAdapter = new ArrayAdapter<rank>(
                this,
                android.R.layout.activity_list_item,
                cmd.getLesScores());*/

        Lv.setAdapter(adapter);
    }
}
