package com.example.itakg.jsonrequestusingvolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    String myURL = "http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button= (Button) findViewById(R.id.get);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, myURL, null,
                        new Response.Listener<JSONObject>() {


                            @Override
                            public void onResponse(JSONObject response) {

                                Log.i("Response:","Response : "+response);


                                try {
                                    String  weather =response.getString("main");
                                    Log.i("MAIN:","INFORMATION IS "+weather);
                                    JSONObject obj=new JSONObject(weather);


                                    String temp=obj.getString("temp");
                                    String press=obj.getString("pressure");
                                    String humid=obj.getString("humidity");
                                    String tempmax=obj.getString("temp_max");
                                    String tempmin=obj.getString("temp_min");


                                    Log.i("TEMPERATURE:","Temerature is: "+temp);
                                    Log.i("PRESSURE:","Pressure is: "+press);
                                    Log.i("HUMIDITY:","Humidity is: "+humid);
                                    Log.i("TEMPERATURE MAX:","Maximum Temerature is: "+tempmax);
                                    Log.i("TEMPERATURE MIN:","Minimum Temerature is: "+tempmin);
                                }

                                catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                try {
                                    String info=response.getString("weather");
                                    Log.i("INFO:","Weather is: "+info);
                                    JSONArray array=new JSONArray(info);
                                    for(int i=0;i<array.length();i++)
                                    {
                                        JSONObject parobj=array.getJSONObject(i);
                                        Log.i("Main:","ID is : "+parobj.getString("id"));
                                        Log.i("Main:","Weather is : "+parobj.getString("main"));
                                        Log.i("Main:","Description : "+parobj.getString("description"));

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

                                Log.i("Error:","Error is : "+error);
                            }
                        }


                );
                MySingelton.getInstance(MainActivity.this).addToRequestQue(jsonObjectRequest);
            }
        });











    }
}
