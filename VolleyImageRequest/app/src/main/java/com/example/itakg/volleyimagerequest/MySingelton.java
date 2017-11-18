package com.example.itakg.volleyimagerequest;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by itakg on 7/9/2017.
 */

public class MySingelton {
    private static MySingelton mInstance;
    private RequestQueue requestQueue;
    private static Context mcontext;
    private MySingelton(Context context)
    {
        mcontext=context;
        requestQueue=getRequestQueue();
    }
    public RequestQueue getRequestQueue()
    {
        if(requestQueue==null)
        {
            requestQueue= Volley.newRequestQueue(mcontext);
        }
        return  requestQueue;
    }

    public static synchronized MySingelton getInstance(Context context)
    {
        if(mInstance==null)
        {
            mInstance=new MySingelton(context);
        }
        return mInstance;
    }

    public void addRequestQueue(Request request)
    {
        requestQueue.add(request);
    }





}
