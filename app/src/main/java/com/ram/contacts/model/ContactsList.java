package com.ram.contacts.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContactsList {

@SerializedName("contacts")
@Expose
private List<Contact> contacts = null;

public List<Contact> getContacts() {
return contacts;
}

public void setContacts(List<Contact> contacts) {
this.contacts = contacts;
}

}