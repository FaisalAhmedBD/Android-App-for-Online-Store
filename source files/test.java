package com.example.faisal.cse_600;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class test extends AppCompatActivity {
    String price,id,name,quantity,imagename;
    int im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            price = extras.getString("PRICE");
            id = extras.getString("ID");
            name = extras.getString("NAME");
            quantity = extras.getString("QUANTITY");
            imagename = extras.getString("IMAGENAME");

            im=extras.getInt("IMAGEDETAILS");
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.test_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(imagename);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView details_id =(TextView)findViewById(R.id.t1) ;
        TextView details_name =(TextView)findViewById(R.id.t2) ;
        TextView dr =(TextView)findViewById(R.id.gg) ;
        TextView qqq =(TextView)findViewById(R.id.ggquantity) ;
        ImageView p=(ImageView)findViewById(R.id.pic) ;

        details_id.setText("Product ID : "+id);
        details_name.setText("Product NAME : "+name);
        dr.setText(price);
        qqq.setText("In Stock : "+ quantity+" Pieces");
        p.setImageResource(im);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;

            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.default_activity_button:
                Intent favourate = new Intent(this, favourate.class);
                startActivity(favourate);
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

}
