package com.example.faisal.cse_600;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NavUtils;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ListView listView;
    private MenuItem mSearchAction;
    private boolean isSearchOpened = false;
    private EditText edtSeach;
String Json_string3,Json_string2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Backgroundtask2().execute();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Home");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        String[] foods = {"Electronics", "Gift Items", "Perfume", "Buy Ebooks"};
        int[] image = new int[]{R.drawable.phone, R.drawable.gift, R.drawable.perfume, R.drawable.ebook};
        // ListAdapter myadapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,foods);

        ListAdapter myadapter = new customadapter(this, foods, image);
        // ListAdapter myadapter1 = new customadapter(this, image);
        listView = (ListView) findViewById(R.id.mylist1);
        listView.setAdapter(myadapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                int mypostion = i;
                String itemclickedid = listView.getItemAtPosition(mypostion).toString();

                switch (mypostion) {
                    case 0: {
                        Intent intent = new Intent(MainActivity.this, mobilephones.class
                        );
                        startActivity(intent);
                        break;
                    }
                    default: {

                        Toast.makeText(getApplicationContext(), "Id Clicked : " + itemclickedid, Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }


    class Backgroundtask2 extends AsyncTask<String, String, String> {
        String json_url;

        @Override
        protected void onPreExecute() {
            json_url = "http://faisalahmed.site88.net/fetch.php";
            // flag = (TextView) findViewById(R.id.info);
            // flag.setText("executing");
        }

        @Override
        protected String doInBackground(String... args) {

            try {
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                StringBuilder stringBuilder = new StringBuilder();

                while ((Json_string3 = bufferedReader.readLine()) != null) {

                    stringBuilder.append(Json_string3 + "\n");

                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }


        @Override
        protected void onPostExecute(String result) {

            //TextView textView = (TextView) findViewById(R.id.info);
            // textView.setText(result);
            Json_string2 = result;
            //Toast.makeText(getApplicationContext(), "Data Loaded,You Can Search Products Now", Toast.LENGTH_LONG).show();
        }
    }
/*
    class BackgroundTask12 extends AsyncTask<String, Void, String> {

        String add_info_url;

        @Override
        protected void onPreExecute() {
            add_info_url = "http://faisalahmed.site88.net/searchfaisal2.php" ;
        }

        protected String doInBackground(String... args) {
            String Name;
            Name = args[0];

            try {
                URL url = new URL(add_info_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String data_string = URLEncoder.encode("i", "UTF-8") + "=" + URLEncoder.encode(Name, "UTF-8");

                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                StringBuilder stringBuilder = new StringBuilder();

                while ((Json_string3 = bufferedReader.readLine()) != null) {

                    stringBuilder.append(Json_string3 + "\n");

                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {

                e.printStackTrace();


            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
        }



    }
*/
    //--------------------------------------------------------------------------------------------------------------------------


    public void showcategory() {
        Intent favourate = new Intent(MainActivity.this, favourate.class);
        startActivity(favourate);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search1);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView = (SearchView) searchItem.getActionView();
        searchView.setQueryHint("Search View Hint");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextChange(String newText) {


                return false;
            }

            @Override
            public boolean onQueryTextSubmit(String query) {

                if (Json_string2 == null) {
                    Toast.makeText(getApplicationContext(), "Data Loading...", Toast.LENGTH_LONG).show();
                } else {

                //BackgroundTask12 backgroundTask = new BackgroundTask12();
              //  backgroundTask.execute(query);

                // Do your task here
                Intent intent = new Intent(getApplicationContext(), search.class);
                intent.putExtra("query", query);
                intent.putExtra("data", Json_string2);
                  //  Toast.makeText(getApplicationContext(), " YEEEEEEE "+Json_string2, Toast.LENGTH_LONG).show();
               startActivity(intent);

                }
                return false;
            }

        });

        return true;
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        mSearchAction = menu.findItem(R.id.action_search);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.action_search:
                return true;
            case R.id.default_activity_button:
                Intent favourate = new Intent(MainActivity.this, favourate.class);
                startActivity(favourate);
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            // Handle the camera action
        } else if (id == R.id.deals) {

        } else if (id == R.id.giftcards) {

        } else if (id == R.id.catagory) {
            this.showcategory();
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
