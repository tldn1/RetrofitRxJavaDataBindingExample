package com.atiscom.retrofitrxjavadatabindingexample;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mico on 11/9/2017.
 */

public class ContactModel {

    @SerializedName("id")
    private int Id;

    @SerializedName("name")
    private String Name;

    @SerializedName("email")
    private String Email;

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }
}
