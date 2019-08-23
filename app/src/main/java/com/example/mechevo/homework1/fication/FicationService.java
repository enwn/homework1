package com.example.mechevo.homework1.fication;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by MECHEVO on 2019/8/22.
 */

public interface FicationService{

    //https://cdwan.cn/api/catalog/index
     @GET("catalog/index")
    Observable<Fication>  getData();
}
