package com.muhamadarief.pasarmalamsmd.API;

import com.muhamadarief.pasarmalamsmd.model.Pasar;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Muhamad Arief on 14/06/2017.
 */

public interface ApiService {

    @GET("pasarmalam.php")
    Call<List<Pasar>> getPasar();
}
