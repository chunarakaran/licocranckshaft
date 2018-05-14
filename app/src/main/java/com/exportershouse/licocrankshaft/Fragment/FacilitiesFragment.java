package com.exportershouse.licocrankshaft.Fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.exportershouse.licocrankshaft.Adapter.CustomGridViewActivity1;
import com.exportershouse.licocrankshaft.R;

public class FacilitiesFragment extends Fragment {

    View rootview;

    private TabLayout tabLayout;
    private ViewPager viewPager;

    GridView androidGridView;

    Fragment fragment = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview=inflater.inflate(R.layout.fragment_facilities, container, false);
        getActivity().setTitle("Facilities");

//        tabLayout = (TabLayout)rootview.findViewById(R.id.tabLayout);
//
//        //Adding the tabs using addTab() method
//        tabLayout.addTab(tabLayout.newTab().setText("MACHINING"));
////        tabLayout.addTab(tabLayout.newTab().setText("PACKAGING"));
//        tabLayout.addTab(tabLayout.newTab().setText("QUALITY ASSURANCE"));
//        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//
//        viewPager = (ViewPager)rootview.findViewById(R.id.pager);
//
//        Pager1 adapter = new Pager1(getFragmentManager(), tabLayout.getTabCount());
//
//        viewPager.setAdapter(adapter);
//
//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//
//        tabLayout.setOnTabSelectedListener(this);


        final String[] gridViewString = {
               "MACHINING", "QUALITY ASSURANCE"

        } ;

        int[] gridViewImageId = {
                R.drawable.machine, R.drawable.quality1


        };

        CustomGridViewActivity1 adapterViewAndroid = new CustomGridViewActivity1(getActivity(), gridViewString, gridViewImageId);
        androidGridView=(GridView)rootview.findViewById(R.id.grid_view_image_text);
        androidGridView.setAdapter(adapterViewAndroid);


        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        FragmentTransaction transection=getFragmentManager().beginTransaction();
                        MachiningFragment mfragment=new MachiningFragment();
                        transection.replace(R.id.content_frame, mfragment);
                        transection.addToBackStack(null).commit();
                        break;
                    case 1:
                        transection = getFragmentManager().beginTransaction();
                        QualityFragment qfragment=new QualityFragment();
                        transection.replace(R.id.content_frame, qfragment);
                        transection.addToBackStack(null).commit();
                        break;

                }
            }
        });





        return rootview;
    }

//    @Override
//    public void onTabSelected(TabLayout.Tab tab) {
//        viewPager.setCurrentItem(tab.getPosition());
//
//    }
//
//    @Override
//    public void onTabUnselected(TabLayout.Tab tab) {
//
//    }
//
//    @Override
//    public void onTabReselected(TabLayout.Tab tab) {
//
//    }
}
