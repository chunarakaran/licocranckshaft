package com.exportershouse.licocrankshaft.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.exportershouse.licocrankshaft.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ContactusFragment extends Fragment implements OnMapReadyCallback {

    MapView mapView;
    GoogleMap mgoogleMap;
    View rootview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview=inflater.inflate(R.layout.fragment_contact, container, false);

        getActivity().setTitle("Contact Us");

        mapView = (MapView)rootview.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);



        return rootview;
    }
    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }
    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mgoogleMap = googleMap;
        LatLng loc = new LatLng(22.246898, 70.673911);
        mgoogleMap.getUiSettings().setZoomControlsEnabled(true);
        mgoogleMap.addMarker(new MarkerOptions().position(loc).title("Licocrankshaft").draggable(true)).isDraggable();
        mgoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(loc, 16));

    }
}
