package com.example.faisal.cse_600;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class mobilephones extends AppCompatActivity {

    private List<nwMovie> movieList = new ArrayList<>();
   // private List<nwMovie> tList = new ArrayList<>();
  //  private List<tv> tvList = new ArrayList<>();
    private RecyclerView recyclerView, tv_recyclerView;
    private MoviesAdapter mAdapter;
   // private MoviesAdapter tAdapter;
   // private tvadapter tvAdapter;

    String Json_string, Json_string2;

    TextView flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mobilephones_layout);
        new Backgroundtask2().execute();

        Toolbar myToolbar = (Toolbar) findViewById(R.id.electronics_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Electronics");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setFocusable(false);
       // tv_recyclerView = (RecyclerView) findViewById(R.id.recycler_view2);
       // tv_recyclerView.setFocusable(false);
        mAdapter = new MoviesAdapter(movieList);
       // tvAdapter = new tvadapter(tvList);

        recyclerView.setHasFixedSize(true);
      //  tv_recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager tvLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(mLayoutManager);
       // tv_recyclerView.setLayoutManager(tvLayoutManager);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL));
      //  tv_recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL));

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //tv_recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(mAdapter);
       // tv_recyclerView.setAdapter(tvAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                nwMovie movie = movieList.get(position);
               // Toast.makeText(getApplicationContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
                final View selectedView = view;
                //Access view object v here
                TextView id  = (TextView) selectedView.findViewById(R.id.title);
                TextView name = (TextView) selectedView.findViewById(R.id.genre);
                TextView price=(TextView) selectedView.findViewById(R.id.year);
                 TextView quantity=(TextView) selectedView.findViewById(R.id.quaa);
                TextView imagename = (TextView) selectedView.findViewById(R.id.qqqq);
                // ImageView details_image=(ImageView) selectedView.findViewById(R.id.d_image);

                String PRICE = (String) price.getText();
                String ID = (String) id.getText();
                 String NAME=(String)name.getText();
                String QUANTITY=(String)quantity.getText();
                String IMAGE_NAME = (String) imagename.getText();

                int imageResource = getResources().getIdentifier("com.example.faisal.cse_600:drawable/" + IMAGE_NAME, null, null);


                Intent m_details = new Intent(getApplicationContext(), test.class
                );
                // get_mobile_info_online get_mobile_info_online=new get_mobile_info_online();

                m_details.putExtra("PRICE", PRICE);
                m_details.putExtra("ID", ID);
                  m_details.putExtra("NAME",NAME);
                  m_details.putExtra("QUANTITY",QUANTITY);
                  m_details.putExtra("IMAGENAME",IMAGE_NAME);
                m_details.putExtra("IMAGEDETAILS", imageResource);

                startActivity(m_details);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        //------------------------------------------------------------------------------------------------------------------------------

       /*  tv_recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), tv_recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
               tv tv = tvList.get(position);
                 Toast.makeText(getApplicationContext(), tv.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
               final View selectedView = view;
                //Access view object v here
                TextView id  = (TextView) selectedView.findViewById(R.id.title);
                TextView name = (TextView) selectedView.findViewById(R.id.genre);
                TextView price=(TextView) selectedView.findViewById(R.id.year);
                TextView quantity=(TextView) selectedView.findViewById(R.id.quaa);
                TextView imagename = (TextView) selectedView.findViewById(R.id.qqqq);
                // ImageView details_image=(ImageView) selectedView.findViewById(R.id.d_image);

                String PRICE = (String) price.getText();
                String ID = (String) id.getText();
                String NAME=(String)name.getText();
                String QUANTITY=(String)quantity.getText();
                String IMAGE_NAME = (String) imagename.getText();

                int imageResource = getResources().getIdentifier("com.example.faisal.cse_600:drawable/" + IMAGE_NAME, null, null);


                Intent m_details = new Intent(getApplicationContext(), test.class
                );
                // get_mobile_info_online get_mobile_info_online=new get_mobile_info_online();

                m_details.putExtra("PRICE", PRICE);
                m_details.putExtra("ID", ID);
                m_details.putExtra("NAME",NAME);
                m_details.putExtra("QUANTITY",QUANTITY);
                m_details.putExtra("IMAGENAME",IMAGE_NAME);
                m_details.putExtra("IMAGEDETAILS", imageResource);

                startActivity(m_details);
            }

            @Override
            public void onLongClick(View view, int position) {

            }

        }));*/
        //------------------------------------------------------------------------------------------------------------------------------

        prepareMovieData();
     //   preparetvData();

    }

    public void canoncamera(View view)
    {
        Intent intent=new Intent(this,canon.class);
        startActivity(intent);
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


    private void prepareMovieData() {
        int imageResource = getResources().getIdentifier("com.example.faisal.cse_600:drawable/" + "galaxy_s6", null, null);

        // Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015","iphone",imageResource);
        nwMovie movie = new nwMovie("1", "Samsung Galaxy S6", " 34,900", "22","galaxy_s6", imageResource);
        movieList.add(movie);



        imageResource = getResources().getIdentifier("com.example.faisal.cse_600:drawable/" + "iphone_6_gold_back", null, null);
        movie = new nwMovie("2", "iphone 7", "88,000", "29", "iphone_6_gold_back", imageResource);
        movieList.add(movie);

        imageResource = getResources().getIdentifier("com.example.faisal.cse_600:drawable/" + "galaxy_s6", null, null);
        movie = new nwMovie("3", "Samsung Galaxy S7", "74,900", "32", "galaxy_s6", imageResource);
        movieList.add(movie);


        imageResource = getResources().getIdentifier("com.example.faisal.cse_600:drawable/" + "samsung_galaxy_j7_2016", null, null);
        movie = new nwMovie("4", "Samsung Galaxy j7 (2016)", "22,900", "102", "samsung_galaxy_j7_2016", imageResource);
        movieList.add(movie);


        mAdapter.notifyDataSetChanged();
    }
/*
    private void preparetvData() {

        int imageResource = getResources().getIdentifier("com.example.faisal.cse_600:drawable/" + "sony_bravia1", null, null);

        // Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015","iphone",imageResource);
          tv tv = new tv ("101", "Sony BRAVIA KD49X8309CBU", " 69,900","sony_bravia1", imageResource);
        tvList.add(tv);

        imageResource = getResources().getIdentifier("com.example.faisal.cse_600:drawable/" + "samsung_1", null, null);
        tv = new tv ("102", "Samsung UE49KU6100", "48,000", "samsung_1", imageResource);
        tvList.add(tv);

        imageResource = getResources().getIdentifier("com.example.faisal.cse_600:drawable/" + "samsung_2", null, null);
        tv = new tv  ("3", "Sony BRAVIA KDL55W755CBU", "74,900","samsung_2", imageResource);
        tvList.add(tv);


        //imageResource = getResources().getIdentifier("com.example.faisal.cse_600:drawable/" + "oppo_f1_plus", null, null);
      //  tv = new nwMovie  ("4", "Samsung Galaxy j7 (2016)", "22,900","20", "samsung_galaxy_j7_2016", imageResource);
      //  tList.add(tv);


        tvAdapter.notifyDataSetChanged();
    }
*/
    public void getJson(View view) {
        new Backgroundtask2().execute();
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

                while ((Json_string = bufferedReader.readLine()) != null) {

                    stringBuilder.append(Json_string + "\n");

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

        }
    }

    public void parsrJson(View view)

    {

        if (Json_string2 == null) {
            Toast.makeText(getApplicationContext(), "Loading", Toast.LENGTH_LONG).show();
        } else {


            //Toast.makeText(getApplicationContext(), Json_string2, Toast.LENGTH_LONG).show();
            // Intent intent=new Intent(getApplicationContext(),test.class);
            //intent.putExtra("Json_data",Json_string2);
            //startActivity(intent);
            Intent mobile = new Intent(this, get_mobile_info_online.class);
            mobile.putExtra("mobile", Json_string2);
            startActivity(mobile);

        }

    }

}

