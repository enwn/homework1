package com.example.mechevo.homework1.home;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MECHEVO on 2019/8/21.
 */

public class MainModel {

    public void requestService(final MainCallBack mainCallBack){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://cdwan.cn/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MainService mainService = retrofit.create(MainService.class);
        Observable<Home> data = mainService.getData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Observer<Home>() {
                     @Override
                     public void onSubscribe(Disposable disposable) {

                     }

                     @Override
                     public void onNext(Home data) {
                         Home.DataBean data1 = data.getData();
                         Log.i("tag", "onNext: "+data1);
                         mainCallBack.success(data1);
                     }

                     @Override
                     public void onError(Throwable t) {
                          mainCallBack.failure(t);
                     }

                     @Override
                     public void onComplete() {

                     }
                 });


    }
}
