package com.ram.contacts.webservice;

import com.ram.contacts.model.Contact;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by nag on 4/11/17.
 */

public interface ApiCall {

    //Base : http://api.androidhive.info/
    // Relative path : contacts

    @GET("contacts/")
    Call<List<Contact>> getContacts();

    //Retrofit
    HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient)
            .build();

}


//https://github.com/shelajev/Retrofit2SampleApp/tree/master/app/src/main/java/zeroturnaround/org/jrebel4androidgettingstarted/service