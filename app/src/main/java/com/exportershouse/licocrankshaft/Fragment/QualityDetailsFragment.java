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

public class QualityDetailsFragment extends Fragment {

    View rootview;

    ImageView picture;

    String pos;

    TextView textView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview=inflater.inflate(R.layout.qualitydetails_fragment, container, false);

        getActivity().setTitle("QUALITY ASSURANCE");

        Bundle bundle=getArguments();
        pos=(String.valueOf(bundle.getString("position")));

        picture=(ImageView)rootview.findViewById(R.id.imageView2);
        textView=(TextView)rootview.findViewById(R.id.vission1);

        int result = Integer.parseInt(pos);

        if (result==1) {

            int imageid = R.drawable.quality2;
            BitmapFactory.Options opts = new BitmapFactory.Options();
            opts.inSampleSize = 4;
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imageid, opts);
            picture.setImageBitmap(bitmap);
        }
        else
        {
            int imageid = R.drawable.quality1;
            BitmapFactory.Options opts = new BitmapFactory.Options();
            opts.inSampleSize = 4;
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imageid, opts);
            picture.setImageBitmap(bitmap);

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
