package com.ram.contacts;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ram.contacts.adapters.ContactsAdapter;
import com.ram.contacts.models.ContactsItem;
import com.ram.contacts.models.ContactsList;
import com.ram.contacts.webservice.ApiCall;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mContactsRecyclerView;
    private ContactsAdapter mContactsAdapter;
    private List<ContactsItem> mContactList = new ArrayList<>();

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

        callRetrofit();
    }

    private void callRetrofit() {

        ApiCall apiCall = ApiCall.retrofit.create(ApiCall.class);
        Call<ContactsList> call = apiCall.getContacts();
        call.enqueue(new Callback<ContactsList>() {
            @Override
            public void onResponse(Call<ContactsList> call, Response<ContactsList> response) {
                mContactsAdapter.setData(response.body().contacts());
            }

            @Override
            public void onFailure(Call<ContactsList> call, Throwable t) {
                t.printStackTrace();
            }

        });
    }

}
