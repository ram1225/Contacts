package com.ram.contacts.models;

import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapter;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

@Generated("com.robohorse.robopojogenerator")
@AutoValue
public abstract class Phone{

	@SerializedName("mobile")
	public abstract String mobile();

	@SerializedName("office")
	public abstract String office();

	@SerializedName("home")
	public abstract String home();

	public static TypeAdapter<Phone> typeAdapter(Gson gson) {
		return new AutoValue_Phone.GsonTypeAdapter(gson);
	}
}