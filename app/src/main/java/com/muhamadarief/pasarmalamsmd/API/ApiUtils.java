package com.muhamadarief.pasarmalamsmd.API;

/**
 * Created by Muhamad Arief on 14/06/2017.
 */

public class ApiUtils{

    private ApiUtils() {

    }

    //public static final String BASE_URL = "http://192.168.43.73/pasarmalamsmd/";
    public static final String BASE_URL = "http://192.168.142.1/pasarmalamsmd/";

    public static ApiService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }

}
