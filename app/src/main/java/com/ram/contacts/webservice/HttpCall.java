package com.ram.contacts.webservice;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Vijay on 11/04/17.
 */
/*
public class HttpCall {

    private URL url;
    HttpURLConnection urlConnection = null;
    try
    {
        url = new URL("http://api.androidhive.info/contacts/");

        urlConnection = (HttpURLConnection) url.openConnection();

        InputStream in = urlConnection.getInputStream();

        InputStreamReader isw = new InputStreamReader(in);

        int data = isw.read();
        while (data != -1) {
            char current = (char) data;
            data = isw.read();
            System.out.print(current);
        }
    }catch(Exception e)
    {
        e.printStackTrace();
    } finally    {
        if (urlConnection != null) {
            urlConnection.disconnect();
        }
    }
}*/
