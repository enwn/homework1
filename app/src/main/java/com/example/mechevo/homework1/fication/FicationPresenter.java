package com.example.mechevo.homework1.fication;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by MECHEVO on 2019/8/22.
 */

public class FicationPresenter  {

     public Observable<List<Fication.DataBean.CategoryListBean>> requestService(){
         FicationModel ficationModel = new FicationModel();
         return ficationModel.requestService()
                     .map(new Function<Fication, List<Fication.DataBean.CategoryListBean>>() {
                         @Override
                         public List<Fication.DataBean.CategoryListBean> apply(Fication fication) throws Exception {
                             return fication.getData().getCategoryList();
                         }
                     });
     }
}
