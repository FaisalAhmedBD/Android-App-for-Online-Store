package com.example.faisal.cse_600;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



public class catagorylistadapter  extends ArrayAdapter<String> {

    public catagorylistadapter(Context context, String[] foods) {

        super(context, R.layout.catagorylist,foods);

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater faiisalsInflater= LayoutInflater.from(getContext());

        View customview=faiisalsInflater.inflate(R.layout.catagorylist,parent,false);
        String singleFoodItem=getItem(position);
        TextView ruet=(TextView)customview.findViewById(R.id.catagoryrowtext);

        ruet.setText(singleFoodItem);
        return customview;

    }
}
