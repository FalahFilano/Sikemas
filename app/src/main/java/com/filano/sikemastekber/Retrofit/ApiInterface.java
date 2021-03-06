package com.filano.sikemastekber.Retrofit;

import com.filano.sikemastekber.Response.KehadiranResponse;
import com.filano.sikemastekber.Response.KelasActiveResponse;
import com.filano.sikemastekber.Response.ListKelasActiveResponse;
import com.filano.sikemastekber.Response.KelasResponse;
import com.filano.sikemastekber.Response.LoginResponse;
import com.filano.sikemastekber.Response.LogoutResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("api/auth/login")
    Call<LoginResponse> login(@Field("no_identitas") String no_identitas,
                              @Field("password") String password);

    @Headers("Accept: application/json")
    @GET("api/auth/logout")
    Call<LogoutResponse> logout(@Header("Authorization") String token);

    @Headers("Accept: application/json")
    @GET("api/kelas")
    Call<KelasResponse> getKelas(@Header("Authorization") String token,
                                 @Query("hari") String hari);

    @Headers("Accept: application/json")
    @GET("api/kelas_active")
    Call<ListKelasActiveResponse> getKelasActive(@Header("Authorization") String token);

    @Headers("Accept: application/json")
    @GET("api/dosen/kelas")
    Call<KelasResponse> getKelasDosen(@Header("Authorization") String token,
                                      @Query("hari") String hari);

    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("api/dosen/kelas_active/store")
    Call<KelasActiveResponse> aktifkanKelas(@Header("Authorization") String token,
                                            @Field("kelas_id") Integer kelas_id);

    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("api/dosen/kelas_active/update")
    Call<KelasActiveResponse> matikanKelas(@Header("Authorization") String token,
                                            @Field("kelas_id") Integer kelas_id);

    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("api/kehadiran/store")
    Call<KehadiranResponse> absen(@Header("Authorization") String token,
                                  @Field("kelas_active_id") Integer kelas_active_id);

    @Headers("Accept: application/json")
    @GET("api/kehadiran")
    Call<ListKelasActiveResponse> getDetailKehadiran(@Header("Authorization") String token,
                                                     @Query("kelas_id") Integer kelas_id);
}
