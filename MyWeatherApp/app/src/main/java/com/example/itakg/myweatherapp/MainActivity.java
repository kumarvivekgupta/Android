package com.example.itakg.myweatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

   private EditText city;
    private Button getWeather;
  private String myCity;
    private String baseURL;
    private String APIKey;
private String myURL;
    public static   String temp;
    public static   String tempmax;
    public static   String tempmin;
    public static   String des;
    public static   String main;
    public static   String press;
    public static String humid;
    public static TextView mainT;
    public static TextView desT;
    public static TextView T;
    public static TextView humidT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city= (EditText) findViewById(R.id.city);
        getWeather= (Button) findViewById(R.id.getWeather);
        mainT= (TextView) findViewById(R.id.main);
        desT= (TextView) findViewById(R.id.des);
        T= (TextView) findViewById(R.id.temp);
        humidT= (TextView) findViewById(R.id.humid);
        getWeather.setOnClickListener(this);
        baseURL= "http://api.openweathermap.org/data/2.5/weather?q=";
        APIKey="&appid=f9324bceed9d507daa01563e94062d2b";
    }

    @Override
    public void onClick(View v) {
       myCity=  city.getText().toString();
        Log.i("City:","city is "+myCity);




            myURL=baseURL+myCity+APIKey;

           final JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, myURL, null,

                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.i("Output","weather is "+response);

                            try {
                                String main=response.getString("main");
                                JSONObject jso= new JSONObject(main);
                                 temp=jso.getString("temp");
                                 tempmin=jso.getString("temp_min");
                                 tempmax=jso.getString("temp_max");
                                 press=jso.getString("pressure");
                                 humid=jso.getString("humidity");
                                double d=Double.parseDouble(temp);
                                d=d-273.0;
                                temp=String.valueOf(d);
                                temp=temp.substring(0,4);
                                T.setText("Temperature : "+temp+" Deg.Celsius");
                                humidT.setText("Humidity : "+humid);
                                Log.i("Output","weather is "+temp);
                                Log.i("Output","weather is "+tempmax);
                                Log.i("Output","weather is "+tempmin);
                                Log.i("Output","weather is "+press);
                                Log.i("Output","weather is "+humid);





                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            try {
                                String weather=response.getString("weather");
                                Log.i("INFO:","Weather is: "+weather);
                                JSONArray array=new JSONArray(weather);
                                for(int i=0;i<array.length();i++)
                                {
                                    JSONObject parobj=array.getJSONObject(i);
                                     main=parobj.getString("main");
                                     des=parobj.getString("description");
                                    mainT.setText("Weather : "+main);
                                    desT.setText("Description : "+des);
                                    Log.i("Main:","Weather is : "+main);
                                    Log.i("Main:","Description : "+des);

                                }

                            }

                            catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Log.i("Output","Error is "+error);
                        }
                    }


            );
            MySingelton.getInstance(MainActivity.this).addToRequestQue(jsonObjectRequest);




        }

    }

