package com.alepposyria.visitealeppo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.alepposyria.visitealeppo.DisplayActivity;
import com.alepposyria.visitealeppo.Objects.ObjectHistory;
import com.alepposyria.visitealeppo.Objects.ObjectLocation;
import com.alepposyria.visitealeppo.R;

import java.util.ArrayList;

import static android.R.attr.type;


/**
 * Created by Lenovo on 09/08/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CardItem> {

    //declare variable and lists
    //Locations is list we use it if types's value is 1
    //History is list we use it if types;s value is 0

    private ArrayList<ObjectLocation> Locations = null;
    private ArrayList<ObjectHistory> History = null;
    private int types;

    //this constructor we use it if fragment is (all fragment without historyFragment)
    public RecyclerAdapter(ArrayList<ObjectLocation> Locations , int types) {
        this.types = types;

        //for first time
        if (this.Locations==null)
            this.Locations = Locations;
    }

    //this constructor we use it if fragment is historyFragment
    //two constructor ? because we use fragments do not have same of views
    public RecyclerAdapter(int types , ArrayList<ObjectHistory> History) {
        this.types = types;

        //for first time
        if (this.History==null)
            this.History = History;
    }

    @Override
    public CardItem onCreateViewHolder(ViewGroup parent, int viewType) {

        // Inflate the layout for this fragment
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card , parent , false);
        return new CardItem(view);
    }

    //to set values in attributes to any item in recyclerView
    @Override
    public void onBindViewHolder(CardItem holder, int position) {

        //the item in Location page (any fragment without historyFragment)
        if (types == 1){
            holder.text.setText(Locations.get(position).getName());
            holder.Image.setImageResource(Locations.get(position).getPicture());
            holder.rate.setRating(Locations.get(position).getRate());
            holder.rate.setEnabled(false);
            holder.itemLocation = Locations.get(position);
            holder.types = types;
        }

        //the item in history page (historyFragment)
        else {
            holder.text.setText(History.get(position).getName());
            holder.Image.setImageResource(History.get(position).getPicture());
            holder.itemHistory = History.get(position);
            holder.types = types;
            holder.rate.setVisibility(View.GONE);
        }

    }

    //number of items in the page (fragment)
    @Override
    public int getItemCount() {

        //the page is location page (any fragment without historyFragment)
        if (types == 1)
            return Locations.size();

         //the page is history page (historyFragment)
        else
            return History.size();

    }


    //this class Represent one item's elements (views) in page (fragment) by recyclerView

    public  static  class CardItem extends RecyclerView.ViewHolder implements  View.OnClickListener{

        //declare variables
        Context context;
        public ImageView Image;
        public TextView text;
        public RatingBar rate;
        public ObjectLocation itemLocation= null;
        public ObjectHistory itemHistory = null;
        public int types;

        //constructor to set values in one item's attribute
        public CardItem(View itemView) {
            super(itemView);
            Image= (ImageView)itemView.findViewById(R.id.image);
            text = (TextView)itemView.findViewById(R.id.text);
            rate = (RatingBar)itemView.findViewById(R.id.rate);
            context = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            //the page is location page (any fragment without historyFragment)
            if (types == 1)
                //we set item's data in page of details (activity_display)
                DisplayActivity.setLocation(itemLocation);

             //the page is history page (historyFragment)
            else
                //we set item's data in page of details (activity_display_history)
                DisplayActivity.setHistory(itemHistory);

            //type of item (from Location page or history page)
            DisplayActivity.setTypes(types);

            //start activity.
            Intent intent = new Intent(view.getContext() , DisplayActivity.class);
            context.startActivity(intent);
        }
    }
}
