package com.parthib.newshub;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter  extends FragmentPagerAdapter {

    int tabcount;
    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){

            case 0 :
                return new HomeFrag();
            case 1:
                return new SportsFrag();
            case 2:
                return new ScienceFrag();
            case 3:
                return new TechFrag();
            case 4:
                return new HealthFrag();
            case 5:
                return new BusinessFrag();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
