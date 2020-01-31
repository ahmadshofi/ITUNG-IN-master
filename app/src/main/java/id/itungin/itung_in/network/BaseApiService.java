package id.itungin.itung_in.network;

import id.itungin.itung_in.login.LoginResponse;
import id.itungin.itung_in.register.RegisterResponse;
import id.itungin.itung_in.tampil.DataResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BaseApiService {

    @FormUrlEncoded
    @POST("user/login")
    Call<LoginResponse> loginRequest(@Field("username") String username,
                                     @Field("password") String password);


    @FormUrlEncoded
    @POST("user/register")
    Call<RegisterResponse> registerRequest(@Field("username") String username,
                                           @Field("nama") String nama,
                                           @Field("password") String password,
                                           @Field("email")String email);


    @GET("pemasukkan/tampilsemua")
    Call<DataResponse> getList();
}
