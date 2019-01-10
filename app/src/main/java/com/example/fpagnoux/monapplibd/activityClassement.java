package com.example.fpagnoux.monapplibd;


import android.database.MatrixCursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import java.util.ArrayList;


public class activityClassement extends AppCompatActivity {
    private TextView test;
    private MySQLiteOpenHelper cmd;
    private ArrayList<rank> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classement);

        String[] columns = new String[] { "_id", "col1", "col2" };
        MatrixCursor matrixCursor= new MatrixCursor(columns);
        startManagingCursor(matrixCursor);



        //matrixCursor.addRow(new Object[] { 1,"hugo","400" });
        //matrixCursor.addRow(new Object[] { 2,"francois","300" });
        //matrixCursor.addRow(new Object[] { 3,"maël","200" });
        //matrixCursor.addRow(new Object[] { 4,"steeven","100" });
        //matrixCursor.addRow(new Object[] { 5,"thomas","50" });

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
