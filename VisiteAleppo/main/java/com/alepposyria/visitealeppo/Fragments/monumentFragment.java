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


public class monumentFragment extends Fragment {

    //instance is variable to give us fragment (monumentFragment)
    //recyclerView is variable we can say is adapter to monumentFragment's items

    private  static  monumentFragment instance = null;
    private  RecyclerView recyclerView;

    //this is List of elements to monumentFragment
    ArrayList<ObjectLocation> Locations = new ArrayList<ObjectLocation>();

    public monumentFragment() {
        CreateListObjectsLocation();
    }

    public  void CreateListObjectsLocation(){

        //if list (Locations) is empty (the fragment is appeared one time) add items to fragment
        //this condition for fragment if appeared one time ; it run , but in next time  we do not add items again ;because we added in last time , so not run

        if(Locations.isEmpty()){

            //add items to fragment (BankFragment)
            Locations.add(new ObjectLocation(R.drawable.citadel_splash , R.drawable.location_citadel_aleppo , (float)5 , "Amphitheatre" , "Hawl Al Qalaa St, Aleppo, Syria"));
            Locations.add(new ObjectLocation(R.drawable.picture_iron_gate , R.drawable.location_iron_gate , (float)4.7 , "Bab al-Hadid" , "Bab Al Hadid St, Aleppo, Syria"));
            Locations.add(new ObjectLocation(R.drawable.picture_antakya_gate , R.drawable.location_antakya_gate , (float)4.6 , "Bab Antakeya" , "Aleppo, Syria"));
            Locations.add(new ObjectLocation(R.drawable.picture_red_gate , R.drawable.location_red_gate , (float)4.2 , "Bab al-Ahmar" , "Jibb Al Quebeh, Aleppo, Syria"));
            Locations.add(new ObjectLocation(R.drawable.picture_matbakh_al_ajami , R.drawable.location_matbakh_al_ajami , (float)4.3 , "Matbakh al Ajami" , "Al Jamaa Al Umawi St, Aleppo, Syria"));
            Locations.add(new ObjectLocation(R.drawable.picture_victory_gate , R.drawable.location_victory_gate , (float)4.2 , "Bab al-Nasr" , "Noureddin Zinki St, Aleppo, Syria"));
        }
    }

    public  static  monumentFragment getInstance(){

        //First time the fragment is appeared
        if (instance == null)
            return  new monumentFragment();

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
        View view = inflater.inflate(R.layout.fragment_monument, container, false);

        //combine variable (recyclerView) with views in XML file , and set values in recyclerView's attributes
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview4);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //the adapter take list (Location) and value is type for we know this fragment is location or history
        RecyclerAdapter adapter = new RecyclerAdapter(Locations , 1);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        return view;
    }

}
