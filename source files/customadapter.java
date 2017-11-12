package com.example.faisal.cse_600;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class customadapter extends ArrayAdapter<String> {
int []im=new int[14];

    public customadapter(Context context, String[] foods, int[] image) {

        super(context, R.layout.custom_row,foods);
        im=image;
    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater faiisalsInflater= LayoutInflater.from(getContext());
        View customview=faiisalsInflater.inflate(R.layout.custom_row,parent,false);
        String singleFoodItem=getItem(position);
        TextView ruet=(TextView)customview.findViewById(R.id.mytext);
        ImageView myimage=(ImageView)customview.findViewById(R.id.myimage);

        ruet.setText(singleFoodItem);
        myimage.setImageResource(im[position]);
        return customview;

    }
}
