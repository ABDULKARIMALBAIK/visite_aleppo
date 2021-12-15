package com.alepposyria.visitealeppo.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.alepposyria.visitealeppo.Fragments.BankFragment;
import com.alepposyria.visitealeppo.Fragments.HotelFragment;
import com.alepposyria.visitealeppo.Fragments.ResturantFragment;
import com.alepposyria.visitealeppo.Fragments.historyFragment;
import com.alepposyria.visitealeppo.Fragments.monumentFragment;

/**
 * Created by Lenovo on 08/08/2018.
 */

public class AdapterPages extends FragmentPagerAdapter {

    //declare variables
    private HotelFragment hotel = null;
    private ResturantFragment resturant = null;
    private BankFragment bank = null;
    private monumentFragment monument = null;
    private historyFragment history = null;

    //constructor
    public AdapterPages(FragmentManager fm) {
        super(fm);
    }


    //this method to get fragment that we want to display on screen
    @Override
        public Fragment getItem(int position) {
            switch (position) {

                //display HotelFragment
                case 0: {
                    hotel = HotelFragment.getInstance();
                    return hotel;
                }
                //display RestaurantFragment
                case 1: {
                    resturant = ResturantFragment.getInstance();
                    return resturant;
                }
                //display BankFragment
                case 2: {
                    bank = BankFragment.getInstance();
                    return bank;
                }
                //display monumentFragment
                case 3: {
                    monument = monumentFragment.getInstance();
                    return monument;
                }
                //display historyFragment
                case 4: {
                    history = historyFragment.getInstance();
                    return history;
                }
                default:
                    return null;
            }
    }

    //numbers of fragments will add to HomeActivity
    @Override
    public int getCount() {
        return 5;
    }


}
