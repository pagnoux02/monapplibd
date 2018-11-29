package com.example.fpagnoux.monapplibd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView img ;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rene_la_bd);
        text = (TextView)findViewById(R.id.txtscore);


    }

    //public void click()
    //{
     //   img = (ImageView)findViewById(R.id.imgjeu1);
      //  img.setOnClickListener(new View.OnClickListener() {

          //  @Override public void onClick(View v) {



          //      text.setText("A vous de jouer  ...");
         //   }
        //});
    //}


}
