package com.ram.contacts.models;

import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapter;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

@Generated("com.robohorse.robopojogenerator")
@AutoValue
public abstract class ContactsItem{

	@SerializedName("address")
	public abstract String address();

	@SerializedName("gender")
	public abstract String gender();

	@SerializedName("phone")
	public abstract Phone phone();

	@SerializedName("name")
	public abstract String name();

	@SerializedName("id")
	public abstract String id();

	@SerializedName("email")
	public abstract String email();

	public static TypeAdapter<ContactsItem> typeAdapter(Gson gson) {
		return new AutoValue_ContactsItem.GsonTypeAdapter(gson);
	}
}