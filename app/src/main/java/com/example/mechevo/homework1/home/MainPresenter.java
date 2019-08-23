package com.example.mechevo.homework1.home;

/**
 * Created by MECHEVO on 2019/8/21.
 */

public class MainPresenter {
      private MainView mMainView;
      public  void attachView(MainView mainView){
            this.mMainView=mainView;

      }
       public  void  requestService(){
           MainModel mainModel = new MainModel();
           mainModel.requestService(new MainCallBack() {
               @Override
               public void success(Home.DataBean data1) {
                       mMainView.success(data1);
               }

               @Override
               public void failure(Throwable t) {
                     mMainView.faliure(t);

               }
           });

       }
}
