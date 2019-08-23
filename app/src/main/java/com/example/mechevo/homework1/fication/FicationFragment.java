package com.example.mechevo.homework1.fication;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManagerNonConfig;
import android.support.v4.view.ViewPager;
import android.util.EventLog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mechevo.homework1.R;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import q.rorbin.verticaltablayout.VerticalTabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class FicationFragment extends Fragment {


    @BindView(R.id.fica_tab)
    VerticalTabLayout fica_tab;
    @BindView(R.id.fica_vp)
    ViewPager fica_vp;
    private View view;
    private Unbinder unbinder;

    public FicationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fication2, null);
        unbinder = ButterKnife.bind(this, v);
        initData();
        return v;
    }

    private void initData() {
        FicationPresenter ficationPresenter = new FicationPresenter();
       ficationPresenter.requestService()
                    .subscribe(new Observer<List<Fication.DataBean.CategoryListBean>>(){
                        @Override
                        public void onSubscribe(Disposable disposable) {

                        }

                        @Override
                        public void onNext(List<Fication.DataBean.CategoryListBean> categoryListBeans) {
                            ArrayList<Fragment> fragments = new ArrayList<>();
                            for (int i = 0; i <categoryListBeans.size() ; i++) {

                                FicationListFragment ficationListFragment = new FicationListFragment();

                                int id = categoryListBeans.get(i).getId();
                                EventBus.getDefault().post(id);

                                fragments.add(ficationListFragment);


                            }

                            FicationAdapter ficationAdapter = new FicationAdapter(getChildFragmentManager(), categoryListBeans, fragments);
                            fica_vp.setAdapter(ficationAdapter);
                            fica_tab.setupWithViewPager(fica_vp);


                        }

                        @Override
                        public void onError(Throwable throwable) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
