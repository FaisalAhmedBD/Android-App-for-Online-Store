package com.example.faisal.cse_600;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;



public class details extends AppCompatActivity {

    String price,id,name,quantity,imagename;
    int imgresource;
    String ID = null, QUANTITY = null, URL2 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            price = extras.getString("PRICE");
            id = extras.getString("ID");
            name = extras.getString("NAME");
            quantity = extras.getString("QUANTITY");
            imagename = extras.getString("IMAGENAME");
            imgresource=extras.getInt("IMAGEDETAILS");
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.details_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(imagename);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

     //  get_mobile_info_online get_mobile_info_online= (get_mobile_info_online) getIntent().getSerializableExtra("mob");


       // String n=get_mobile_info_online.toString();
        TextView details_id =(TextView)findViewById(R.id.d_id) ;
        TextView details_name =(TextView)findViewById(R.id.d_name) ;
        TextView details_price =(TextView)findViewById(R.id.d_price) ;
        TextView details_quantity =(TextView)findViewById(R.id.d_quantity) ;
        TextView details_image_name =(TextView)findViewById(R.id.d_imagename) ;
        ImageView details_image=(ImageView)findViewById(R.id.d_image);


        details_id.setText("Product ID : "+id);
        details_name.setText("Product Name : "+name);
        details_price.setText(price+" Taka");
        details_quantity.setText("In Stock : "+quantity+" Pieces");
        details_image_name.setText(imagename);
        details_image.setImageResource(imgresource);

    }
    public void buymobile(View view) {
        //  http://faisalahmed.site88.net/updatefaisal.php?id=4&q=50
        // int ID=Integer.parseInt(id);
        //  int QUANTITY=Integer.parseInt(quantity);


        /*try {
            ID = URLEncoder.encode(id, "utf-8");
            QUANTITY = URLEncoder.encode(quantity, "utf-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        */

        //URL = "http://necrecords.16mb.com/complaints.php?username="+query;
      //  URL2 = "http://faisalahmed.site88.net/updatefaisal.php?id=" + ID + "&q=" + QUANTITY;
        //  Toast.makeText(getApplicationContext(), id+" + "+ quantity, Toast.LENGTH_LONG).show();

        BackgroundTask12 backgroundTask = new BackgroundTask12();
        backgroundTask.execute(id, quantity);
        finish();
       /*

        URL url = null;

        try {
            url = new URL(URL2);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }



       HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            Toast.makeText(getApplicationContext(), URL2+" Conntected ", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
       finally {
            urlConnection.disconnect();
            Toast.makeText(getApplicationContext(), "Dis-Conntected ", Toast.LENGTH_LONG).show();
        }
        */


    }

    class BackgroundTask12 extends AsyncTask<String, Void, String> {

        String add_info_url;

        @Override
        protected void onPreExecute() {
            add_info_url = "http://faisalahmed.site88.net/updatefaisal.php" ;
        }

        protected String doInBackground(String... args) {
            String IID, QQUANTITY;
            IID = args[0];
            QQUANTITY = args[1];
            try {
                URL url = new URL(add_info_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String data_string = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(IID, "UTF-8") + "&" +
                        URLEncoder.encode("q", "UTF-8") + "=" + URLEncoder.encode(QQUANTITY, "UTF-8");
                bufferedWriter.write(data_string);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                inputStream.close();
                httpURLConnection.disconnect();

                return "Congratulations,Parchase Successfull";
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
