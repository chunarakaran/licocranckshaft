package com.exportershouse.licocrankshaft.Fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.exportershouse.licocrankshaft.R;

public class MachiningDetailsFragment extends Fragment {

    View rootview;

    ImageView picture;

    String pos;

    TextView rc1,rc2,rc3;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview=inflater.inflate(R.layout.machiningdetails_fragment, container, false);

        getActivity().setTitle("Machining");

        Bundle bundle=getArguments();
        pos=(String.valueOf(bundle.getString("position")));

        picture=(ImageView)rootview.findViewById(R.id.imageView2);


//
//        rc1=(TextView)rootview.findViewById(R.id.rc1);
//        rc2=(TextView)rootview.findViewById(R.id.rc2);
//        rc3=(TextView)rootview.findViewById(R.id.rc3);

        int[] gridViewImageId = {
                R.drawable.m1, R.drawable.m2, R.drawable.m3, R.drawable.m4, R.drawable.m5,R.drawable.m6


        };



        int position = Integer.parseInt(pos);

        switch (position) {

            case 0:
                BitmapFactory.Options opts = new BitmapFactory.Options();
                opts.inSampleSize = 4;
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), gridViewImageId[0], opts);
                picture.setImageBitmap(bitmap);
//                rc1.setText("1");
//                rc2.setText("Induction Hardening");
//                rc3.setText("Inductotherm");
                break;
            case 1:
                opts = new BitmapFactory.Options();
                opts.inSampleSize = 4;
                bitmap = BitmapFactory.decodeResource(getResources(), gridViewImageId[1], opts);
                picture.setImageBitmap(bitmap);
                break;
            case 2:
                opts = new BitmapFactory.Options();
                opts.inSampleSize = 4;
                bitmap = BitmapFactory.decodeResource(getResources(), gridViewImageId[2], opts);
                picture.setImageBitmap(bitmap);
                break;

            case 3:
                opts = new BitmapFactory.Options();
                opts.inSampleSize = 4;
                bitmap = BitmapFactory.decodeResource(getResources(), gridViewImageId[3], opts);
                picture.setImageBitmap(bitmap);
                break;

            case 4:
                opts = new BitmapFactory.Options();
                opts.inSampleSize = 4;
                bitmap = BitmapFactory.decodeResource(getResources(), gridViewImageId[4], opts);
                picture.setImageBitmap(bitmap);
                break;

            case 5:
                opts = new BitmapFactory.Options();
                opts.inSampleSize = 4;
                bitmap = BitmapFactory.decodeResource(getResources(), gridViewImageId[5], opts);
                picture.setImageBitmap(bitmap);
                break;
        }



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
