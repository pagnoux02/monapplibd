package com.example.fpagnoux.monapplibd;

import android.database.MatrixCursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

public class activityClassement extends AppCompatActivity {
    private TextView test;
    private MySQLiteOpenHelper cmd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classement);

        String leTheme = this.getIntent().getExtras().getString("Theme");

        test = this.findViewById(R.id.viewPseudo);
        test.setText(leTheme);
        System.out.println(cmd.getLesScores());

        // Définition des colonnes
        // NB : SimpleCursorAdapter a besoin obligatoirement d'un ID nommé "_id"
        String[] columns = new String[] { "_id", "col1", "col2" };

        // Définition des données du tableau
        // les lignes ci-dessous ont pour seul but de simuler
        // un objet de type Cursor pour le passer au SimpleCursorAdapter.
        // Si vos données sont issues d'une base SQLite,
        // utilisez votre "cursor" au lieu du "matrixCursor"
        MatrixCursor matrixCursor= new MatrixCursor(columns);
        startManagingCursor(matrixCursor);
        matrixCursor.addRow(new Object[] { 1,"thrthrt","col2:ligne1" });
        matrixCursor.addRow(new Object[] { 2,"col1:ligne2","col2:ligne2" });
        matrixCursor.addRow(new Object[] { 3,"col1:ligne1","col2:ligne1" });
        matrixCursor.addRow(new Object[] { 4,"col1:ligne2","col2:ligne2" });
        matrixCursor.addRow(new Object[] { 5,"col1:ligne1","col2:ligne1" });
        matrixCursor.addRow(new Object[] { 6,"col1:ligne2","col2:ligne2" });
        matrixCursor.addRow(new Object[] { 7,"col1:ligne1","col2:ligne1" });
        matrixCursor.addRow(new Object[] { 8,"col1:ligne2","col2:ligne2" });
        matrixCursor.addRow(new Object[] { 9,"col1:ligne1","col2:ligne1" });
        matrixCursor.addRow(new Object[] { 10,"col1:ligne2","col2:ligne2" });

        // on prendra les données des colonnes 1 et 2...
        String[] from = new String[] {"col1", "col2"};

        // ...pour les placer dans les TextView définis dans "row_item.xml"
        int[] to = new int[] { R.id.textViewCol1, R.id.textViewCol2};

        // création de l'objet SimpleCursorAdapter...
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.row_item, matrixCursor, from, to, 0);

        // ...qui va remplir l'objet ListView
        ListView lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(adapter);
    }
}
