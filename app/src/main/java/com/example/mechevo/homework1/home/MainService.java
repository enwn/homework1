package com.example.mechevo.homework1.home;

import com.example.mechevo.homework1.fication.Fication;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by MECHEVO on 2019/8/21.
 */

public interface MainService {
    //https://cdwan.cn/index
    String url="https://cdwan.cn/";
    @GET("api/index/index")
    Observable<Home> getData();
}
