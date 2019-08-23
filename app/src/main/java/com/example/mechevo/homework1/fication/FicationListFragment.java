package com.example.mechevo.homework1.fication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mechevo.homework1.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class FicationListFragment extends Fragment {


    @BindView(R.id.fica_img)
    ImageView fica_img;
    @BindView(R.id.fica_tv)
    TextView fica_tv;
    @BindView(R.id.fica_ry)
    RecyclerView fica_ry;
    private View view;
    private Unbinder unbinder;
    private FicationList.DataBean.CurrentCategoryBean list;

    public FicationListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fication_list, null);
        unbinder = ButterKnife.bind(this, v);
        EventBus.getDefault().register(this);
        initView();
        return v;
    }

    private void initView() {
           fica_ry.setLayoutManager(new GridLayoutManager(getActivity(),3));


    }

    @Subscribe(threadMode =ThreadMode.MAIN)
    public   void  getData(Integer  id){
       Retrofit retrofit = new Retrofit.Builder()
               .baseUrl("https://cdwan.cn/")
               .addConverterFactory(GsonConverterFactory.create())
               .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
               .build();
       FicationListService ficationListService = retrofit.create(FicationListService.class);
       Observable<FicationList> getdata = ficationListService.getdata(id);
       getdata.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Consumer<FicationList>() {
                     @Override
                     public void accept(FicationList ficationList) throws Exception {
                         list = ficationList.getData().getCurrentCategory();


                     }
                 });

   }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
