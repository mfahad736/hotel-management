package com.appybuilder.alioffical.insurancebazar.Activitise.Adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class fragmentAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    public fragmentAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int postion) {
//        HomeActivity obj=new HomeActivity();
//        Bundle bundle=new Bundle();
//        postion=postion++;
//        bundle.putString("Message","Page No is "+postion);
       // obj.;
        return mFragmentList.get(postion);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();

    }

    public void addFragment(Fragment fragment) {
        mFragmentList.add(fragment);
    }
}
