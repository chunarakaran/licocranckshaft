package com.exportershouse.licocrankshaft.Fragment;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
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
import com.exportershouse.licocrankshaft.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

public class MissionFragment extends Fragment {

    View rootview;

    ProgressDialog dialog;
    RequestQueue requestQueue;


    WebView mission,vision;

    String URL;
    String strmission,strvision;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview=inflater.inflate(R.layout.fragment_mission, container, false);

        mission = (WebView) rootview.findViewById(R.id.mission);
        vision = (WebView) rootview.findViewById(R.id.vision);
        URL = getString(R.string.url);

        dialog = new ProgressDialog(getContext());
        dialog.setMessage("Loading....");
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL+"api/view_mission_vision",
                new Response.Listener<JSONObject>() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
                    @Override
                    public void onResponse(JSONObject response) {


                        try {

                            JSONArray jsonArray = response.getJSONArray("view_mission_vision");
//                            JSONObject jOb = response.getJSONObject("id");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                //image = jsonObject.getString("banner");
                                strmission = jsonObject.getString("mission_description");
                                strvision = jsonObject.getString("vision_description");
                            }


                            //imurl = "http://oliveworld.co.in/images/page/"+image;

                            //Toast.makeText(getContext(),aboutus,Toast.LENGTH_LONG).show();

                            //Picasso.with(getContext()).load(imurl).into(img);

                            String justifyTag = "<html><body style='text-align:justify;'>%s</body></html>";
                            String dataString = String.format(Locale.US, justifyTag, strmission);
                            mission.loadDataWithBaseURL("", dataString, "text/html", "UTF-8", "");

                            String justifyTag1 = "<html><body style='text-align:justify;'>%s</body></html>";
                            String dataString1 = String.format(Locale.US, justifyTag1, strvision);
                            vision.loadDataWithBaseURL("", dataString1, "text/html", "UTF-8", "");



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




        return rootview;
    }

}
