package com.exportershouse.licocrankshaft.Adapter;

/**
 * Created by Shrey on 05-03-2018.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.exportershouse.licocrankshaft.Fragment.AboutusFragment;
import com.exportershouse.licocrankshaft.Fragment.CertificateFragment;
import com.exportershouse.licocrankshaft.Fragment.MissionFragment;


//Extending FragmentStatePagerAdapter
public class Pager extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public Pager(FragmentManager fm, int tabCount) {
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
                AboutusFragment tab1 = new AboutusFragment();
                return tab1;
            case 1:
                MissionFragment tab2 = new MissionFragment();
                return tab2;
            case 2:
                CertificateFragment tab3 = new CertificateFragment();
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