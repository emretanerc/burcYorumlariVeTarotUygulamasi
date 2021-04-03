package com.etcmobileapps.burcyorumlari2020.Api;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Interface {



    @GET("get/{burc}")
    Call<List<GunlukModel>> gunlukGetir(@Path("burc") String burc);


    @GET("get/{burc}/{mod}")
    Call<List<HayModel>> hayGetir(@Path("burc") String burc,
                                      @Path("mod") String mod);
        ;
}