package com.atiscom.retrofitrxjavadatabindingexample;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by Mico on 11/9/2017.
 */

public interface ApiInterface {

    @POST("getcontacts.php")
    Observable<List<ContactModel>> getContacts();

}
