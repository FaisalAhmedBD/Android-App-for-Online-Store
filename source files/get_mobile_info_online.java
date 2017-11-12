package com.example.faisal.cse_600;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;


public class get_mobile_info_online extends AppCompatActivity implements Serializable {

    String Json_String;
    JSONObject jsonObject;
    JSONArray jsonArray;
    mobileadapter mobileadapter;
    ListView listView;
    TextView textView;
    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_mobile_info_online);


        Toolbar toolbar = (Toolbar) findViewById(R.id.get_mobile_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Mobiles");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Json_String = extras.getString("mobile");
        }
        //  textView=(TextView)findViewById(R.id.textView4);
        // textView.setText(Json_String);

        mobileadapter = new mobileadapter(this, R.layout.row_layout);

        listView = (ListView) findViewById(R.id.mobilelist);
        listView.setFocusable(false);
        listView.setAdapter(mobileadapter);


        //-----------------------------------------------------------------------------------------------------------------------------------------


        try {
            jsonObject = new JSONObject(Json_String);
            int count = 0;
            jsonArray = jsonObject.getJSONArray("server response");
            String id, quantity, name, price, image;


            while (count < jsonArray.length()) {

                JSONObject JO = jsonArray.getJSONObject(count);

                id = JO.getString("id");
                name = JO.getString("Name");
                price = JO.getString("Price");
                quantity = JO.getString("Quantity");
                image = JO.getString("image");

             /*   if (image.equals("samsung_galaxy_j7_2016")) {

                    Toast.makeText(getApplicationContext(), "baler : "+image , Toast.LENGTH_LONG).show();
                    int imageResource = getResources().getIdentifier("com.example.faisal.cse_600:drawable/samsung_galaxy_j7_2016", null, null);
                    mobiles m = new mobiles(id, name, price, quantity, image, imageResource);

                    mobileadapter.add(m);
                    count++;
                }
                else  if (image.equals("iphone_6_gold_back")) {

                    Toast.makeText(getApplicationContext(), "baler : "+image , Toast.LENGTH_LONG).show();
                    int imageResource = getResources().getIdentifier("com.example.faisal.cse_600:drawable/iphone_6_gold_back", null, null);
                    mobiles m = new mobiles(id, name, price, quantity, image, imageResource);

                    mobileadapter.add(m);
                    count++;
                }
*/
               // value = getResources().getIdentifier("com.example.faisal.cse_600:drawable/" + image, null, null);
                int imageResource = getResources().getIdentifier("com.example.faisal.cse_600:drawable/" + image,  null, null);
                //int imageResource3 = getResources().getIdentifier(image, "drawable", getPackageName());

               // Toast.makeText(getApplicationContext(), "Original : " + String.valueOf(imageResource), Toast.LENGTH_LONG).show();
               // Toast.makeText(getApplicationContext(), "First : " + image, Toast.LENGTH_LONG).show();
               // Toast.makeText(getApplicationContext(), "Second : " + String.valueOf(imageResource3), Toast.LENGTH_LONG).show();

                mobiles m = new mobiles(id, name, price, quantity, image, imageResource);

               mobileadapter.add(m);
                count++;


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                int mypostion = i;
                String itemclickedid = listView.getItemAtPosition(mypostion).toString();
                final View selectedView = view;

                String str = listView.getItemAtPosition(i).toString();
               // Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();

                //Access view object v here
                TextView price = (TextView) selectedView.findViewById(R.id.price);
                TextView id = (TextView) selectedView.findViewById(R.id.p_id);
                TextView name = (TextView) selectedView.findViewById(R.id.name);
                TextView quantity = (TextView) selectedView.findViewById(R.id.quantity);
                TextView imagename = (TextView) selectedView.findViewById(R.id.image);
                ImageView details_image = (ImageView) selectedView.findViewById(R.id.d_image);

                String PRICE = (String) price.getText();
                String ID = (String) id.getText();
                String NAME = (String) name.getText();
                String QUANTITY = (String) quantity.getText();
                String IMAGE_NAME = (String) imagename.getText();

                   int imageResource = getResources().getIdentifier("com.example.faisal.cse_600:drawable/" +IMAGE_NAME , null, null);
                //int imageResource = getResources().getIdentifier("com.example.faisal.cse_600:drawable/iphone_6_gold_back", null, null);


                Intent m_details = new Intent(getApplicationContext(), details.class
                );
                // get_mobile_info_online get_mobile_info_online=new get_mobile_info_online();

                m_details.putExtra("PRICE", PRICE);
                m_details.putExtra("ID", ID);
                m_details.putExtra("NAME", NAME);
                m_details.putExtra("QUANTITY", QUANTITY);
                m_details.putExtra("IMAGENAME", IMAGE_NAME);
                m_details.putExtra("IMAGEDETAILS", imageResource);

                startActivity(m_details);


            }
        });


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
