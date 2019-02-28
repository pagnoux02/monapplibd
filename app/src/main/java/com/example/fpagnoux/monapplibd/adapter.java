package com.example.fpagnoux.monapplibd;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.lang.ref.SoftReference;
import java.util.ArrayList;

/**
 * Created by Shree on 10/22/2016.
 */
public class adapter extends BaseAdapter {
    private Context mContext;
    MySQLiteOpenHelper controldbontroldb;
    SQLiteDatabase db;
    private ArrayList<String> Id = new ArrayList<String>();
    private ArrayList<String> Pseudo = new ArrayList<String>();
    private ArrayList<String> Score = new ArrayList<String>();

    public adapter(Context  context,ArrayList<String> Id,ArrayList<String> Pseudo, ArrayList<String> Score)
    {
        this.mContext = context;
        this.Id = Id;
    this.Pseudo = Pseudo;
    this.Score = Score;
    }
    @Override
    public int getCount() {
        return Id.size();
    }
    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final    viewHolder holder;
       controldbontroldb   =new MySQLiteOpenHelper(mContext);
        LayoutInflater layoutInflater;
        if (convertView == null) {
            layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.okinvi, null);
            holder = new viewHolder();
            holder.id = (TextView) convertView.findViewById(R.id.tvid);
            holder.pseudo = (TextView) convertView.findViewById(R.id.tvname);
            holder.score = (TextView) convertView.findViewById(R.id.tvmailid);

            convertView.setTag(holder);
        } else {
            holder = (viewHolder) convertView.getTag();
        }
        holder.id.setText(Id.get(position));
        holder.pseudo.setText(Pseudo.get(position));
        holder.score.setText(Score.get(position));

        return convertView;
    }
    public class viewHolder {
        TextView id;
        TextView pseudo;
        TextView score;

    }
}