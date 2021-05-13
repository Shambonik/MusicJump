package com.unity3d.player.retrofit;

import com.unity3d.player.model.PostRegistrationUser;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.*;
import retrofit2.Call;

public interface ApiService {
    @POST("/reg")
    Call<ResponseBody> savePost(@Body PostRegistrationUser user);

//    @GET("/reg/h/{id}")
//    Call<Integer> f(@Path("id") Integer id);
}
