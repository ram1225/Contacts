package com.ram.contacts.webservice;

import com.ram.contacts.model.ContactsList;

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

    @GET("contacts/")
    Call<ContactsList> getContacts();


    //Retrofit
    OkHttpClient.Builder builder = new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
    OkHttpClient httpClient = builder.build();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://api.androidhive.info/")
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}