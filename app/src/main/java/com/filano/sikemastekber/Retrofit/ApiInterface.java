package com.filano.sikemastekber.Retrofit;

import com.filano.sikemastekber.Response.KelasActiveResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("api/kelas_active")
    Call<KelasActiveResponse> getKelasActive();

}
