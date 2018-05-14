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

import com.exportershouse.licocrankshaft.Adapter.CustomGridViewActivity1;
import com.exportershouse.licocrankshaft.R;

public class QualityFragment extends Fragment {

    View rootview;
    GridView androidGridView;

    Fragment fragment = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview=inflater.inflate(R.layout.fragment_quality, container, false);

        getActivity().setTitle("Quality Control");

        final String[] gridViewString = {
                "QUALITY ASSURANCE", "CRACK DETECTION MACHINE"

        } ;

        int[] gridViewImageId = {
                R.drawable.quality1, R.drawable.quality2


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
                        QualityDetailsFragment mfragment=new QualityDetailsFragment();
                        Bundle bundle=new Bundle();
                        bundle.putString("position", String.valueOf(position));
                        mfragment.setArguments(bundle);
                        transection.replace(R.id.content_frame, mfragment);
                        transection.addToBackStack(null).commit();
                        break;
                    case 1:
                        transection = getFragmentManager().beginTransaction();
                        mfragment = new QualityDetailsFragment();
                        bundle = new Bundle();
                        bundle.putString("position", String.valueOf(position));
                        mfragment.setArguments(bundle);
                        transection.replace(R.id.content_frame, mfragment);
                        transection.addToBackStack(null).commit();
                        break;

                }
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
