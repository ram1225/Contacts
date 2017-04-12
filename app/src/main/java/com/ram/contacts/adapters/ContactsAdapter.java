package com.ram.contacts.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ram.contacts.R;
import com.ram.contacts.models.ContactsItem;

import java.util.List;

/**
 * Created by Vijay on 11/04/17.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyViewHolder> {

    private List<ContactsItem> mContactsList;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_list_row, parent, false);

        return new MyViewHolder(itemView);
    }


    public ContactsAdapter(List<ContactsItem> mContactsList) {
        this.mContactsList = mContactsList;
    }

    public void setData(List<ContactsItem> mContactsList) {
        this.mContactsList = mContactsList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ContactsItem contact = mContactsList.get(position);
        holder.name.setText(contact.name());
        holder.email.setText(contact.email());

    }

    @Override
    public int getItemCount() {
        return mContactsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, email;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            email = (TextView) view.findViewById(R.id.email);

        }
    }
}
