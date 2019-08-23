package com.example.mechevo.homework1.fication;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MECHEVO on 2019/8/22.
 */

public class FicationModel {

      public Observable<Fication> requestService(){
          Retrofit retrofit = new Retrofit.Builder()
                  .baseUrl("")
                  .addConverterFactory(GsonConverterFactory.create())
                  .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                  .build();
          FicationService ficationService = retrofit.create(FicationService.class);
          Observable<Fication> data = ficationService.getData();
          return data.subscribeOn(Schedulers.io())
                      .observeOn(AndroidSchedulers.mainThread());

      }
}
