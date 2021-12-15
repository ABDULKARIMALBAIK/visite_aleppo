package com.alepposyria.visitealeppo.Fragments;

import android.app.Activity;
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


public class BankFragment extends Fragment {

    //instance is variable to give us fragment (BankFragment)
    //recyclerView is variable we can say is adapter to BankFragment's items

    private static BankFragment instance = null;
    private  RecyclerView recyclerView;

    //this is List of elements to BankFragment
    ArrayList<ObjectLocation> Locations = new ArrayList<ObjectLocation>();

    public BankFragment() {
        createListObjectsLocation();
    }

    private void createListObjectsLocation() {

        //if list (Locations) is empty (the fragment is appeared one time) add items to fragment
        //this condition for fragment if appeared one time ; it run , but in next time  we do not add items again ;because we added in last time , so not run

        if (Locations.isEmpty()){

            //add items to fragment (BankFragment)
            Locations.add(new ObjectLocation(R.drawable.global_bank,R.drawable.location_commercial_bank_of_syria_no_4, 3 ,"Commercial Bank of Syria NO 4","Al Mutanabbi St, Aleppo, Syria"));
            Locations.add(new ObjectLocation(R.drawable.picture_haram , R.drawable.location_haram_comany_for_money_transfers,5 , "Haram Company for Money Transfers" , "Bab Al Faraj St, Aleppo, Syria"));
            Locations.add(new ObjectLocation(R.drawable.picture_central_bank_of_syria_aleppo_branch , R.drawable.location_central_bank_of_syria_aleppo_branch , (float) 3.8 , "Central Bank of Syria Aleppo branch" , "Aleppo, Syria"));
            Locations.add(new ObjectLocation(R.drawable.global_bank , R.drawable.location_syria_international_islamic_bank , (float)4.8 , "Syria International Islamic Bank","seif aldaula , Aleppo, Syria"));
            Locations.add(new ObjectLocation(R.drawable.global_bank , R.drawable.location_bank_of_syria_and_overseas , (float)3.8 , "Bank of Syria and Overseas" , "Cairo , Aleppo, Syria"));
        }

    }

    public static   BankFragment getInstance(){

        //First time the fragment is appeared
        if (instance == null)
            return new BankFragment();

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
        View view = inflater.inflate(R.layout.fragment_bank, container, false);

        //combine variable (recyclerView) with views in XML file , and set values in recyclerView's attributes
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview3);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //the adapter take list (Location) and value is type for we know this fragment is location or history
        RecyclerAdapter adapter = new RecyclerAdapter(Locations , 1);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        return view;
    }


}


