package com.example.fpagnoux.monapplibd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class rankAdapter extends BaseAdapter {

    private final Context mContext;
    private final rank[] ranks;

    // 1
    public rankAdapter(Context context, rank[] ranks) {
        this.mContext = context;
        this.ranks = ranks;
    }

    // 2
    @Override
    public int getCount() {
        return ranks.length;
    }

    // 3
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 4
    @Override
    public Object getItem(int position) {
        return null;
    }

    // 5
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView dummyTextView = new TextView(mContext);
        dummyTextView.setText(String.valueOf(position));
        return dummyTextView;
    }

}
