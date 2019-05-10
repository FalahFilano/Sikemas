package com.filano.sikemastekber.Retrofit;

import com.filano.sikemastekber.Response.KelasActiveResponse;
import com.filano.sikemastekber.Response.KelasResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("api/kelas_active")
    Call<KelasActiveResponse> getKelasActive();

    @GET("api/kelas")
    Call<KelasResponse> getKelas(@Query("hari") String hari);

}
