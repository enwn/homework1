package com.example.mechevo.homework1.fication;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by MECHEVO on 2019/8/22.
 */

public class FicationAdapter  extends FragmentPagerAdapter {
    private  List<Fication.DataBean.CategoryListBean>  list;
    ArrayList<Fragment> fragments;

    public FicationAdapter(FragmentManager fm, List<Fication.DataBean.CategoryListBean> list, ArrayList<Fragment> fragments) {
        super(fm);
        this.list = list;
        this.fragments = fragments;
    }

    public FicationAdapter(FragmentManager fm, List<Fication.DataBean.CategoryListBean> list) {
        super(fm);
        this.list = list;
    }


    @Override
    public Fragment getItem(int position) {
        return   fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getName();
    }
}
