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


public class ResturantFragment extends Fragment {

    //instance is variable to give us fragment (RestaurantFragment)
    //recyclerView is variable we can say is adapter to RestaurantFragment's items

    private  static  ResturantFragment instance = null;
    private  RecyclerView recyclerView;

    //this is List of elements to RestaurantFragment
    ArrayList<ObjectLocation> Locations = new ArrayList<ObjectLocation>();

    public ResturantFragment() {
        createListObjectsLocation();
    }

    private void  createListObjectsLocation(){

        //if list (Locations) is empty (the fragment is appeared one time) add items to fragment
        //this condition for fragment if appeared one time ; it run , but in next time  we do not add items again ;because we added in last time , so not run
        if (Locations.isEmpty()){

            //add items to fragment (RestaurantFragment)
            Locations.add(new ObjectLocation(R.drawable.global_restaurant2 , R.drawable.location_sahtian , (float)4 , "Sahtain" , "Aleppo, Syria" ));
            Locations.add(new ObjectLocation(R.drawable.picture_tasty_fast_food , R.drawable.location_tasty_fast_food , (float)4.6 , "Tasty Fast Food" , "Mukambo side mosque kindergarten, Aleppo, Syria"));
            Locations.add(new ObjectLocation(R.drawable.global_restaurant2 , R.drawable.location_aleppo_tourism_forum , (float)3.8 , "Aleppo Tourism Forum" , "Aleppo, Syria"));
            Locations.add(new ObjectLocation(R.drawable.global_restaurant2 , R.drawable.location_alzaeem , (float)4 ,"Alzaeem Restaurant's" , "Abdullah bin Abbas , Aleppo , Syria" ));
            Locations.add(new ObjectLocation(R.drawable.picture_the_light_of_the_martyrs , R.drawable.location_the_light_of_the_martyrs , (float)4 , "The Light of the Martyrs" , "Taha Hussien , Aleppo , Syria"));
        }
    }

    public  static  ResturantFragment getInstance(){

        //First time the fragment is appeared
        if (instance==null)
            return new ResturantFragment();

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
        View view= inflater.inflate(R.layout.fragment_resturant, container, false);

        //combine variable (recyclerView) with views in XML file , and set values in recyclerView's attributes
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //the adapter take list (Location) and value is type for we know this fragment is location or history
        RecyclerAdapter adapter = new RecyclerAdapter(Locations , 1);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        return view;

    }

}
