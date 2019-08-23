package com.example.mechevo.homework1;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mechevo.homework1.fication.FicationFragment;
import com.example.mechevo.homework1.home.HomeFragment;
import com.example.mechevo.homework1.mine.MyFragment;
import com.example.mechevo.homework1.shopping.ShoppingFragment;
import com.example.mechevo.homework1.special.SpecialFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager vp;
    private TabLayout tab;
    private DrawerLayout dra;
    private ArrayList<String> title;
    private ArrayList<Integer> img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTab();
        initView();


    }

    private void initTab() {
        title = new ArrayList<>();
        title.add("首页");
        title.add("专题");
        title.add("分类");
        title.add("购物车");
        title.add("我的");

        img = new ArrayList<>();
        img.add(R.drawable.selector1);
        img.add(R.drawable.selector2);
        img.add(R.drawable.selector3);
        img.add(R.drawable.selector4);
        img.add(R.drawable.selector5);
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        vp = (ViewPager) findViewById(R.id.vp);
        tab = (TabLayout) findViewById(R.id.tab);
        dra = (DrawerLayout) findViewById(R.id.dra);

        setSupportActionBar(toolbar);

        ArrayList<Fragment> list = new ArrayList<>();
        HomeFragment homeFragment = new HomeFragment();
        SpecialFragment specialFragment = new SpecialFragment();
        FicationFragment ficationFragment = new FicationFragment();
        ShoppingFragment shoppingFragment = new ShoppingFragment();
        MyFragment myFragment = new MyFragment();
        list.add(homeFragment);
        list.add(specialFragment);
        list.add(ficationFragment);
        list.add(shoppingFragment);
        list.add(myFragment);

        MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager(), list);
        vp.setAdapter(mainAdapter);
        tab.setupWithViewPager(vp);

        for (int i = 0; i <list.size() ; i++) {
            TabLayout.Tab tabAt = tab.getTabAt(i);
            tabAt.setCustomView(tabView(i));

        }


    }

    public View tabView(int i) {
        View v = LayoutInflater.from(this).inflate(R.layout.main_tab, null);
        ImageView imag = v.findViewById(R.id.tab_img);
        TextView tv = v.findViewById(R.id.tab_tv);

        imag.setBackgroundResource(img.get(i));
        tv.setText(title.get(i));

         return  v;
    }
}
