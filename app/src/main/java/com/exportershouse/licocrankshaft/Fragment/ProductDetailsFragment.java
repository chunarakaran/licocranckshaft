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

import com.exportershouse.licocrankshaft.R;

import uk.co.senab.photoview.PhotoViewAttacher;

public class ProductDetailsFragment extends Fragment {

    View rootview;

    ImageView picture;

    String path;

    PhotoViewAttacher pAttacher;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview=inflater.inflate(R.layout.productdetails_fragment, container, false);

        getActivity().setTitle("Product Detail");

        Bundle bundle=getArguments();
        path=(bundle.getString("position"));

        picture=(ImageView)rootview.findViewById(R.id.imageView2);

        pAttacher = new PhotoViewAttacher(picture);
        pAttacher.update();



        int position = Integer.parseInt(path);

        int[] gridViewImageId = {
                R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4, R.drawable.p5, R.drawable.p6, R.drawable.p7, R.drawable.p8
        };

        switch (position) {

            case 0:
                BitmapFactory.Options opts = new BitmapFactory.Options();
                opts.inSampleSize = 4;
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), gridViewImageId[0], opts);
                picture.setImageBitmap(bitmap);
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

            case 6:
                opts = new BitmapFactory.Options();
                opts.inSampleSize = 4;
                bitmap = BitmapFactory.decodeResource(getResources(), gridViewImageId[6], opts);
                picture.setImageBitmap(bitmap);
                break;

            case 7:
                opts = new BitmapFactory.Options();
                opts.inSampleSize = 4;
                bitmap = BitmapFactory.decodeResource(getResources(), gridViewImageId[7], opts);
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
