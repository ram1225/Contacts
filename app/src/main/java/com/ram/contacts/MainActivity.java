package com.ram.contacts;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.ram.contacts.adapters.ContactsAdapter;
import com.ram.contacts.model.Contact;
import com.ram.contacts.model.ContactsList;
import com.ram.contacts.webservice.ApiCall;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mContactsRecyclerView;
    private ContactsAdapter mContactsAdapter;
    private List<Contact> mContactList = new ArrayList<>();
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContactsRecyclerView = (RecyclerView) findViewById(R.id.contact_recycler_view);
        mContactsAdapter = new ContactsAdapter(mContactList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mContactsRecyclerView.setLayoutManager(mLayoutManager);
        mContactsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mContactsRecyclerView.setAdapter(mContactsAdapter);


        // Calling progressDialog
        /*pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setIndeterminate(true);
        pDialog.setMessage("Please wait... data is loading...");
        pDialog.show();*/
        callRetrofit();
        // fetchContactData();
    }

    private void callRetrofit() {
        ApiCall apiCall = ApiCall.retrofit.create(ApiCall.class);
        Call<ContactsList> call = apiCall.getContacts();
        call.enqueue(new Callback<ContactsList>() {
            @Override
            public void onResponse(Call<ContactsList> call, Response<ContactsList> response) {
                //mContactList = response.body().getContacts();
                //mContactsAdapter.notifyDataSetChanged();
                //pDialog.dismiss();

                mContactsAdapter.setData(response.body().getContacts());

            }

            @Override
            public void onFailure(Call<ContactsList> call, Throwable t) {
                //pDialog.dismiss();
                t.printStackTrace();
            }


        });
    }

//    private void fetchContactData() {
//
//       /* Contact mContact = new Contact("Mad Max: Fury Road", "Action & Adventure");
//        mContactList.add(mContact);
//
//        mContact = new Contact("Inside Out", "Animation, Kids & Family");
//        mContactList.add(mContact);
//
//        mContact = new Contact("Star Wars: Episode VII - The Force Awakens", "Action");
//        mContactList.add(mContact);
//*/
//
//        new AsyncTask() {
//            ProgressDialog pDialog = new ProgressDialog(MainActivity.this);
//            StringBuilder stringResponse = new StringBuilder();
//
//            @Override
//            protected void onPreExecute() {
//                super.onPreExecute();
//                pDialog.setIndeterminate(true);
//                pDialog.setMessage("Please wait... data is being downloaded...");
//                pDialog.show();
//            }
//
//            @Override
//            protected void onPostExecute(Object o) {
//                super.onPostExecute(o);
//                if (stringResponse.length() > 0) {
//                    try {
//                        JSONObject jObj = new JSONObject(stringResponse.toString());
//                        JSONArray contacts = jObj.getJSONArray("contacts");
//
//                        for (int i = 0; i < contacts.length(); i++) {
//                            String name = contacts.getJSONObject(i).get("name").toString();
//                            String email = contacts.getJSONObject(i).get("email").toString();
//                            //Contact mContact = new Contact(name, email);//TODO remove
//                            //mContactList.add(mContact);//TODO remove
//                        }
//                    } catch (Exception e) {
//
//                    }
//
//                }
//                mContactsAdapter.notifyDataSetChanged();
//                pDialog.dismiss();
//            }
//
//            @Override
//            protected Object doInBackground(Object[] params) {
//                stringResponse.setLength(0);
//                URL url;
//                BufferedReader reader = null;
//                HttpURLConnection urlConnection = null;
//                try {
//                    url = new URL("http://api.androidhive.info/contacts/");
//
//                    urlConnection = (HttpURLConnection) url.openConnection();
//
//
//                    reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//
//                    String line = null;
//
//                    // Read Server Response
//                    while ((line = reader.readLine()) != null) {
//                        // Append server response in string
//                        stringResponse.append(line + "");
//                    }
//
//                    Log.v("Test", stringResponse + "");
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                } finally {
//                    if (urlConnection != null) {
//                        urlConnection.disconnect();
//                    }
//                }
//                return null;
//            }
//
//
//        }.execute();
//
//
//    }
}
