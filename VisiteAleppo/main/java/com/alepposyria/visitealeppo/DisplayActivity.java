package com.alepposyria.visitealeppo;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.alepposyria.visitealeppo.Objects.ObjectHistory;
import com.alepposyria.visitealeppo.Objects.ObjectLocation;
import com.flaviofaria.kenburnsview.KenBurnsView;

public class DisplayActivity extends AppCompatActivity {

    public static ObjectLocation location = null;
    public static ObjectHistory history = null;
    public static int types;

    //this is elements to location pages
    KenBurnsView kenBurnsView;
    ImageView imageLocation;
    RatingBar ratingBar;
    TextView title;
    TextView rate;
    TextView address;

    //this is elements to history page (one page)
    TextView context;

    //note: we use some Location pages's variables in history page ;because some variables are Common

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //if user click on any item (card) in Location pages

        if (types == 1){

            //we display details this card in location page ; so we use activity_display XML file
            setContentView(R.layout.activity_display);

            //combine the variables with views in XML file
            kenBurnsView = (KenBurnsView)findViewById(R.id.image);
            imageLocation = (ImageView)findViewById(R.id.location);
            ratingBar = (RatingBar)findViewById(R.id.rating);
            rate = (TextView)findViewById(R.id.Text_rate);
            title = (TextView)findViewById(R.id.Title);
            address = (TextView)findViewById(R.id.address);

            //set values to variables's attributes
            kenBurnsView.setImageResource(location.getPicture());
            imageLocation.setImageResource(location.getLocation());
            ratingBar.setRating(location.getRate());
            ratingBar.setEnabled(false);
            rate.setText(String.valueOf(location.getRate()));
            title.setText(location.getName());
            address.setText(location.getAddress());
        }

        //if user click on any item (card) in history page
        else{

            //we display details this card in history page ; so we use activity_display_history XML file
            setContentView(R.layout.activity_display_history);

            //combine the variables with views in XML file
            kenBurnsView = (KenBurnsView)findViewById(R.id.image_history);
            title = (TextView)findViewById(R.id.Title_history);
            context = (TextView)findViewById(R.id.Context_history);

            //set values to variables's attributes
            kenBurnsView.setImageResource(history.getPicture());
            title.setText(history.getName());
            context.setText(history.getContext());
        }

    }


    //here setter to variables.

    public static void setTypes(int types) {
        DisplayActivity.types = types;
    }

    public static void setLocation(ObjectLocation location) {
        DisplayActivity.location = location;
    }

    public static void setHistory(ObjectHistory history) {
        DisplayActivity.history = history;
    }

    //here getter to variables.

    public static int getTypes() {
        return types;
    }

    public static ObjectLocation getLocation() {
        return location;
    }

    public static ObjectHistory getHistory() {
        return history;
    }

}
