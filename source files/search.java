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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class search extends AppCompatActivity {

    TextView textView,tt2;
    String Query,D;
    String Json_String;
    JSONObject jsonObject;
    JSONArray jsonArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Toolbar toolbar = (Toolbar) findViewById(R.id.search_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Search Results");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        TextView id=(TextView)findViewById(R.id.search_id);
        TextView name=(TextView)findViewById(R.id.search_name);
        TextView price=(TextView)findViewById(R.id.s_price);
        TextView quantity=(TextView)findViewById(R.id.s_quantity);
        TextView image=(TextView)findViewById(R.id.s_imagename);
        ImageView search_image=(ImageView)findViewById(R.id.s_image);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Query = extras.getString("query");
            D= extras.getString("data");

          //  textView = (TextView) findViewById(R.id.tst);
           // tt2 = (TextView) findViewById(R.id.tst2);
           // textView.setText(Query);
           // tt2.setText(D);
        }


        try {
            jsonObject = new JSONObject(D);
            int count = 0;
            jsonArray = jsonObject.getJSONArray("server response");
            String ID, NAME, PRICE, QUANTITY, IMAGENAME, Building;

            while (count < jsonArray.length()) {

                JSONObject JO = jsonArray.getJSONObject(count);

                ID = JO.getString("id");
                NAME = JO.getString("Name");
                PRICE = JO.getString("Price");
                QUANTITY = JO.getString("Quantity");
                IMAGENAME = JO.getString("image");
              //  Building = JO.getString("building");


                if (NAME.equals(Query))
                {
                     id.setText("Product Id : "+ID);
                  name.setText("Product Name : "+NAME);
                     price.setText("Product Price : "+PRICE);
                     quantity.setText("Product Quantity : "+QUANTITY);
                     image.setText("Product ImageName : "+IMAGENAME);

                    int imageResource = getResources().getIdentifier("com.example.faisal.cse_600:drawable/" + IMAGENAME, null, null);
                    search_image.setImageResource(imageResource);

                    count++;
                }
                else if (ID.equals(Query))
                {
                    id.setText("Product Id : "+ID);
                    name.setText("Product Name : "+NAME);
                    price.setText("Product Price : "+PRICE);
                    quantity.setText("Product Quantity : "+QUANTITY);
                    image.setText("Product ImageName : "+IMAGENAME);

                    int imageResource = getResources().getIdentifier("com.example.faisal.cse_600:drawable/" + IMAGENAME, null, null);
                    search_image.setImageResource(imageResource);

                    count++;
                }
                   count++;


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

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
