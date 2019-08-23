package com.example.mechevo.homework1.fication;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by MECHEVO on 2019/8/22.
 */

public interface FicationListService {
    //https://cdwan.cn/api/catalog/current
     @GET("api/catalog/current")
     Observable<FicationList>  getdata(@Query("id") int id);
}
