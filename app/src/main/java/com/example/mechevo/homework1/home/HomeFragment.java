package com.example.mechevo.homework1.home;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.mechevo.homework1.R;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements MainView {


    @BindView(R.id.banner)
    Banner ban;
    private View view;
    private Unbinder unbinder;
   // private List<Data.DataBean.BannerBean> banner;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, null);

        unbinder = ButterKnife.bind(this, v);
        MainPresenter mainPresenter = new MainPresenter();
        mainPresenter.attachView(this);
        mainPresenter.requestService();

        return v;
    }


    private void initBanner() {
       // ban.setImages(banner);
        ban.setImageLoader(new ImageBanner()).start();


    }


    @Override
    public void success(Home.DataBean data1) {
       // banner = data1.getBanner();
      //  Log.i("tag", "success: "+banner.size());
       // initBanner();


    }


    @Override
    public void faliure(Throwable t) {
        Log.i("tag", "faliure: "+t);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public   class  ImageBanner extends ImageLoader{

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(getActivity()).load(path).into(imageView);
        }
    }
}
