package com.exportershouse.licocrankshaft.Adapter;

/**
 * Created by Shrey on 05-03-2018.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.exportershouse.licocrankshaft.Fragment.MachiningFragment;
import com.exportershouse.licocrankshaft.Fragment.QualityFragment;


//Extending FragmentStatePagerAdapter
public class Pager1 extends FragmentStatePagerAdapter {


    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public Pager1(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
//                MachiningFragment tab1 = new MachiningFragment();
                return new MachiningFragment();
//            case 1:
//                PackagingFragment tab2 = new PackagingFragment();
//                return tab2;
            case 1:
                QualityFragment tab3 = new QualityFragment();
                return tab3;
            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}