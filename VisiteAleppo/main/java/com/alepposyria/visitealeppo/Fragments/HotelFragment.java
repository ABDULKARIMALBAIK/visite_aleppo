package com.alepposyria.visitealeppo.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alepposyria.visitealeppo.Adapter.RecyclerAdapter;
import com.alepposyria.visitealeppo.Objects.ObjectLocation;
import com.alepposyria.visitealeppo.R;

import java.util.ArrayList;


public class HotelFragment extends Fragment {

    //instance is variable to give us fragment (HotelFragment)
    //recyclerView is variable we can say is adapter to HotelFragment's items

    private static HotelFragment instance = null;
    private  RecyclerView recyclerView;

    //this is List of elements to HotelFragment
    ArrayList<ObjectLocation> Locations = new ArrayList<ObjectLocation>();

    public HotelFragment() {
        createListObjectLocation();
    }

    private  void createListObjectLocation(){

        //if list (Locations) is empty (the fragment is appeared one time) add items to fragment
        //this condition for fragment if appeared one time ; it run , but in next time  we do not add items again ;because we added in last time , so not run
        if (Locations.isEmpty()){

            //add items to fragment (HotelFragment)
            Locations.add(new ObjectLocation(R.drawable.picture_sheraton_aleppo , R.drawable.location_sheraton_aleppo , (float)4.1 , "Sheraton Aleppo" , "Aleppo, Syria"));
            Locations.add(new ObjectLocation(R.drawable.picture_beit_wakil , R.drawable.location_beit_wakil , (float)4.8 , "Beit Wakil" , "Aleppo, Syria"));
            Locations.add(new ObjectLocation(R.drawable.picture_martini_dar_zamaria_hotel , R.drawable.location_martini_dar_zamaria_hotel , (float)4.5 , "Martini Dar Zamaria Hotel" , "Aleppo, Syria"));
            Locations.add(new ObjectLocation(R.drawable.picture_mirage_palace , R.drawable.location_mirage_palace , (float)4.6 , "Mirage Palace" , "Al Mutanabbi Street, Aleppo PO BOX 278, Syria"));
            Locations.add(new ObjectLocation(R.drawable.picture_ramsis_hotel_aleppo , R.drawable.location_ramsis_hotel_aleppo , (float)4.6 , "Ramsis Hotel Aleppo" , "Aleppo, Syria"));
        }
    }

    public  static  HotelFragment getInstance(){

        //First time the fragment is appeared
        if (instance==null)
            return new HotelFragment();

        //not First time the fragment is appeared
        else
            return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hotel, container, false);

        //combine variable (recyclerView) with views in XML file , and set values in recyclerView's attributes
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //the adapter take list (Location) and value is type for we know this fragment is location or history
        RecyclerAdapter adapter = new RecyclerAdapter(Locations , 1);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        return view;
    }


}
