package com.exportershouse.licocrankshaft.Fragment;

import android.content.ClipData;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.exportershouse.licocrankshaft.Adapter.CustomGridViewActivity;
import com.exportershouse.licocrankshaft.R;

import java.util.ArrayList;

public class ProductsFragment extends Fragment {

    View rootview;
    GridView androidGridView;

    CustomGridViewActivity adapterViewAndroid;

    ArrayList<ClipData.Item> gridArray = new ArrayList<ClipData.Item>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview=inflater.inflate(R.layout.products_fragment, container, false);

        getActivity().setTitle("Products");

        String[] gridViewString = {
                "name", "name", "name","name", "name", "name", "name", "name"


        } ;

         int[] gridViewImageId = {
                R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4, R.drawable.p5, R.drawable.p6, R.drawable.p7, R.drawable.p8


        };

        adapterViewAndroid = new CustomGridViewActivity(getActivity(), gridViewString, gridViewImageId);
        androidGridView=(GridView)rootview.findViewById(R.id.grid_view_image_text);
        androidGridView.setAdapter(adapterViewAndroid);

        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String path = (String) adapterViewAndroid.getItem(position);

                FragmentTransaction transection=getFragmentManager().beginTransaction();
                ProductDetailsFragment mfragment=new ProductDetailsFragment();
                Bundle bundle=new Bundle();
                bundle.putString("position", String.valueOf(position));
                mfragment.setArguments(bundle);
                transection.replace(R.id.content_frame, mfragment);
                transection.addToBackStack(null).commit();
            }
        });

        return rootview;
    }



}
