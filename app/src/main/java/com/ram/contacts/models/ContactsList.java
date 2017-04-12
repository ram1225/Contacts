package com.ram.contacts.models;

import java.util.List;
import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapter;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

@Generated("com.robohorse.robopojogenerator")
@AutoValue
public abstract class ContactsList {

	@SerializedName("contacts")
	public abstract List<ContactsItem> contacts();

	public static TypeAdapter<ContactsList> typeAdapter(Gson gson) {
		return new AutoValue_ContactsList.GsonTypeAdapter(gson);
	}
}