package com.exportershouse.licocrankshaft.Fragment;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.exportershouse.licocrankshaft.Adapter.RecyclerAdapter;
import com.exportershouse.licocrankshaft.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Locale;


public class HomeFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private SliderLayout mDemoSlider;
    View rootview;

    Fragment fragment = null;


    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    int RecyclerViewItemPosition ;


    ProgressDialog dialog;
    RequestQueue requestQueue;


    WebView about;

    String URL;
    String aboutus;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview=inflater.inflate(R.layout.fragment_home, container, false);



        getActivity().setTitle("Home");

        mDemoSlider = (SliderLayout) rootview.findViewById(R.id.slider);




//        HashMap<String,String> url_maps = new HashMap<String, String>();



//        url_maps.put("Ashish", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
//        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
//        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
//        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("WELCOME Shri Lakshmi Spares Pvt. Ltd.",R.drawable.slider1);
        file_maps.put("QUALITY WORK",R.drawable.slider2);
        file_maps.put("Cutting Edge Technology",R.drawable.lico_video);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getContext());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }

        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Tablet);
//        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setCustomIndicator((PagerIndicator) rootview.findViewById(R.id.custom_indicator));
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);


        about = (WebView) rootview.findViewById(R.id.details);
        URL = getString(R.string.url);


        dialog = new ProgressDialog(getContext());
        dialog.setMessage("Loading....");
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL+"api/about_us",
                new Response.Listener<JSONObject>() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
                    @Override
                    public void onResponse(JSONObject response) {


                        try {

                            JSONArray jsonArray = response.getJSONArray("about_us");
//                            JSONObject jOb = response.getJSONObject("id");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                //image = jsonObject.getString("banner");
                                aboutus = jsonObject.getString("description");
                            }


                            //imurl = "http://oliveworld.co.in/images/page/"+image;

                            //Toast.makeText(getContext(),aboutus,Toast.LENGTH_LONG).show();

                            //Picasso.with(getContext()).load(imurl).into(img);

                            String justifyTag = "<html><body style='text-align:justify;'>%s</body></html>";
                            String dataString = String.format(Locale.US, justifyTag, aboutus);

                            about.loadDataWithBaseURL("", dataString, "text/html", "UTF-8", "");


//                            about.loadData(aboutus, "text/html", null);
                            dialog.dismiss();


                        } catch (JSONException e) {
                            dialog.dismiss();
                            Log.e("VOLLEY", "ERROR");
                        }

                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        dialog.dismiss();
                        AlertDialog ad = new AlertDialog.Builder(getContext())
                                .create();
                        ad.setCancelable(true);
                        ad.setTitle("Sorry");
                        ad.setMessage("Somthing Went Wrong,\nPlease Try Again After Sometime.");
                        ad.setButton(getContext().getString(R.string.okay), new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int which) {

//                                FragmentManager frag = getActivity().getSupportFragmentManager();
//                                MainFragment mainFragment = new MainFragment();
//                                frag.beginTransaction().replace(R.id.FragContainer,mainFragment).addToBackStack(null).commit();
                            }
                        });

                        ad.show();
                        Log.e("VOLLEY", "ERROR");

                    }
                }
        );

        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        requestQueue.add(jsonObjectRequest);









        recyclerView = (RecyclerView) rootview.findViewById(R.id.recyclerview1);

        layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);


//        // Implementing Click Listener on RecyclerView.
//        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
//
//            GestureDetector gestureDetector = new GestureDetector(getActivity(), new GestureDetector.SimpleOnGestureListener() {
//
//                @Override
//                public boolean onSingleTapUp(MotionEvent motionEvent) {
//
//                    return true;
//                }
//
//            });
//
//
//            @Override
//            public boolean onInterceptTouchEvent(RecyclerView Recyclerview, MotionEvent motionEvent)
//            {
//
//
//                rootview = Recyclerview.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
//
//                if(rootview != null && gestureDetector.onTouchEvent(motionEvent)) {
//
//                    //Getting RecyclerView Clicked Item value.
//                    RecyclerViewItemPosition = Recyclerview.getChildAdapterPosition(rootview);
//
////                    FragmentTransaction transection=getFragmentManager().beginTransaction();
////
////                    switch (RecyclerViewItemPosition)
////                    {
////                        case 0:
////
////                            MachiningFragment mfragment=new MachiningFragment();
////                            transection.replace(R.id.content_frame, mfragment);
////                            transection.addToBackStack(null).commit();
////
////                            break;
////                        case 1:
////                            PackagingFragment pfragment=new PackagingFragment();
////                            transection.replace(R.id.content_frame, pfragment);
////                            transection.addToBackStack(null).commit();
////                            break;
////                        case 2:
////                            QualityFragment qfragment=new QualityFragment();
////                            transection.replace(R.id.content_frame, qfragment);
////                            transection.addToBackStack(null).commit();
////                            break;
////
////                    }
//
//
//
//
//
//                    }
//
//                return false;
//            }
//
//            @Override
//            public void onTouchEvent(RecyclerView Recyclerview, MotionEvent motionEvent) {
//
//            }
//
//            @Override
//            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//
//            }
//        });





        return rootview;
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
