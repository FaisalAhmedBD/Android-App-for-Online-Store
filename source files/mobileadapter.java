package com.example.faisal.cse_600;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Faisal on 9/27/2016.
 */
public class mobileadapter extends ArrayAdapter {

    List list=new ArrayList();

    public mobileadapter(Context context, int resource) {
        super(context, resource);

    }

    public mobileadapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);

    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row;
        row=convertView;

        productHolder productHolder;

        if(row==null)
        {
            LayoutInflater inflater=(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.row_layout,parent,false);
            productHolder=new productHolder();
            productHolder.tx_id=(TextView)row.findViewById(R.id.p_id) ;
            productHolder.tx_name=(TextView)row.findViewById(R.id.name);
            productHolder.tx_price=(TextView)row.findViewById(R.id.price);
            productHolder.tx_quantity=(TextView)row.findViewById(R.id.quantity);
            productHolder.tx_image=(TextView)row.findViewById(R.id.image);
            productHolder.imageView=(ImageView) row.findViewById(R.id.imagenet);
            row.setTag(productHolder);
        }
        else
        {
            productHolder=(productHolder) row.getTag();
        }

        mobiles mobile=(mobiles) this.getItem(position);
        productHolder.tx_id.setText(mobile.getID());
        productHolder.tx_name.setText(mobile.getNAME());
        productHolder.tx_price.setText("Price : "+mobile.getPRICE());
        productHolder.tx_quantity.setText(mobile.getQUANTITY());
        productHolder.tx_image.setText(mobile.getIMAGE());
        productHolder.imageView.setImageResource(mobile.getRES());

        //  int ide = getResources().getIdentifier("com.example.faisal.cse_600:drawable/" + tx_image, null, null);

        // new DownloadImageTask(productHolder.imageView)
        //  .execute(products.getIMAGE());
        return row;
    }


    static class productHolder
    {
        TextView tx_id, tx_name,tx_price,tx_quantity,tx_image;
        ImageView imageView;
    }

}
