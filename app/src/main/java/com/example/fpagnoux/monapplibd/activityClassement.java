package com.example.fpagnoux.monapplibd;


import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;


public class activityClassement extends AppCompatActivity {

    MySQLiteOpenHelper controllerdb = new MySQLiteOpenHelper(this);
    SQLiteDatabase db;
    private ArrayList<String> Id = new ArrayList<String>();
    private ArrayList<String> Pseudo = new ArrayList<String>();
    private ArrayList<String> Score = new ArrayList<String>();
    private ListView lv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classement);

        lv = (ListView) this.findViewById(R.id.lv);

        String[] columns = new String[] { "_id", "col1", "col2" };
        MatrixCursor matrixCursor= new MatrixCursor(columns);
        startManagingCursor(matrixCursor);


        displayData();
    /*    matrixCursor.addRow(new Object[] { 1,"Rang","Score" });
        matrixCursor.addRow(new Object[] { 1,"Challenger","500" });
        matrixCursor.addRow(new Object[] { 2,"Diamand","350" });
        matrixCursor.addRow(new Object[] { 3,"Platine","200" });
        matrixCursor.addRow(new Object[] { 4,"Or","100" });
        matrixCursor.addRow(new Object[] { 5,"Argent","50" });
        matrixCursor.addRow(new Object[] { 5,"Bronze","25" });*/

        // on prendra les données des colonnes 1 et 2...
       /* String[] from = new String[] {"col1", "col2"};*/

        // ...pour les placer dans les TextView définis dans "row_item.xml"
        /*int[] to = new int[] { R.id.textViewCol1, R.id.textViewCol2};*/

        // création de l'objet SimpleCursorAdapter...
       /* SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.row_item, matrixCursor, from, to, 0);*/

        // ...qui va remplir l'objet ListView

       /*lv.setAdapter(adapter);*/
    }
    private void displayData() {
        db = controllerdb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT *  FROM  Rank ORDER BY score DESC LIMIT 10;",null);
        Id.clear();
        Pseudo.clear();
        Score.clear();

        if (cursor.moveToFirst()) {
            do {
                Id.add(cursor.getString(cursor.getColumnIndex("id")));
                Pseudo.add(cursor.getString(cursor.getColumnIndex("pseudo")));
                Score.add(cursor.getString(cursor.getColumnIndex("score")));

            } while (cursor.moveToNext());
        }
        adapter ca = new adapter(activityClassement.this,Id, Pseudo,Score);
        lv.setAdapter(ca);
        //code to set adapter to populate list
        cursor.close();}
}
