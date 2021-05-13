package com.unity3d.player.retrofit;

import com.unity3d.player.model.PostRegistrationUser;
import retrofit2.http.*;
import retrofit2.Call;

public interface ApiService {
    @POST("/reg")
    Call<String> savePost(@Body PostRegistrationUser user);

//    @GET("/reg/h/{id}")
//    Call<Integer> f(@Path("id") Integer id);
}
