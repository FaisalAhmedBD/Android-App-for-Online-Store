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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class favourate  extends AppCompatActivity {
    private ListView listView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourate);

        Toolbar toolbar = (Toolbar) findViewById(R.id.fav_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Catagories");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String[] foods = {"Appliances","Baby","Beauty","Books","Car & Motorbike","Clothing & Accessories",
                "Computer & Accessories","Electronics","Furniture","Gift Cards","Grocery & Gourmet Foods",
        "Health & Personal Care","Home & Kitchen","Industrial & Scientific","Jewellery","Kindle Store","Luggage & Bags",
        "Movies & Tv Shows","Music","Musical Instruments","Office Products","Pet Supplies","Shoes & Handbags","Software",
        "Sports, Fitness & Outdoors","Toys & Games","Watches"};
        // ListAdapter myadapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,foods);

        ListAdapter myadapter = new catagorylistadapter(this, foods);
        // ListAdapter myadapter1 = new customadapter(this, image);
        listView2=(ListView)findViewById(R.id.favlist);
        listView2.setAdapter(myadapter);

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                int mypostion=i;

                switch (mypostion){
                    case 0:
                        String itemclickedid=listView2.getItemAtPosition(mypostion).toString();

                        Toast.makeText(getApplicationContext(),"Id Clicked : "+itemclickedid,Toast.LENGTH_LONG).show();

                        break;
                    case 1:
                        Intent booksintent = new Intent(favourate.this,booklist.class);
                        startActivity(booksintent);
                        break;
                    case 2:
                        Intent favourate = new Intent(favourate.this, MainActivity.class);
                        startActivity(favourate);
                        break;
                    default:
                        break;
                }
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
