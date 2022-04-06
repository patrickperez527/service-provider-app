package com.np.onei.utils;

import android.content.Context;
import android.os.AsyncTask;

import org.apache.http.NameValuePair;

import java.util.ArrayList;

class MyAsyncTask extends AsyncTask<String,String,String> {

    ArrayList<NameValuePair> nameValuePair;
    String resp;
    String urlstr;
    MyAsyncTask(Context _cnt,String url, ArrayList<NameValuePair> nameValuePair)
    {
        this.nameValuePair=nameValuePair;
        urlstr=url;
    }
    @Override
    protected String doInBackground(String... strings) {

        try{

            resp=CustomHttpClient.executeHttpPost(urlstr,nameValuePair);


        }catch (Exception e)
        {


        }
        return resp;
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected void onPostExecute(String s) {

    }
}