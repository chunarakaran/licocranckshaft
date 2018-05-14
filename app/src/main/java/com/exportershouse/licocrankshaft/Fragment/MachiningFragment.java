package com.exportershouse.licocrankshaft.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.exportershouse.licocrankshaft.Adapter.CustomGridViewActivity1;
import com.exportershouse.licocrankshaft.R;

public class MachiningFragment extends Fragment {

    View rootview;
    GridView androidGridView;

    CustomGridViewActivity1 adapterViewAndroid;

    ImageView img1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview=inflater.inflate(R.layout.fragment_machining, container, false);

        getActivity().setTitle("Machining");

        String[] gridViewString = {
              "INDUCTION HARDENING", "STRESS RELIEVING", "CNC GRINDING","ECCENTRIC PIN GRINDING", "VMC MACHINE","DYNAMIC BALANCING"


        } ;

        int[] gridViewImageId = {
                R.drawable.m1, R.drawable.m2, R.drawable.m3, R.drawable.m4, R.drawable.m5,R.drawable.m6


        };

         adapterViewAndroid = new CustomGridViewActivity1(getActivity(), gridViewString, gridViewImageId);
        androidGridView=(GridView)rootview.findViewById(R.id.grid_view_image_text);
        androidGridView.setAdapter(adapterViewAndroid);

        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String path = (String) adapterViewAndroid.getItem(position);

                FragmentTransaction transection=getFragmentManager().beginTransaction();
                MachiningDetailsFragment mfragment=new MachiningDetailsFragment();
                Bundle bundle=new Bundle();
                bundle.putString("position", String.valueOf(position));
                mfragment.setArguments(bundle);
                transection.replace(R.id.content_frame, mfragment);
                transection.addToBackStack(null).commit();
            }
        });


        rootview.setFocusableInTouchMode(true);
        rootview.requestFocus();
        rootview.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
                    // DO WHAT YOU WANT ON BACK PRESSED
                    getFragmentManager().popBackStack();
                    return true;
                } else {
                    return false;
                }
            }
        });



        return rootview;
    }




}
