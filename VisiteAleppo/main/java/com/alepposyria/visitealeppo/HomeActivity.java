package com.alepposyria.visitealeppo;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TableLayout;
import android.widget.Toast;

import com.alepposyria.visitealeppo.Adapter.AdapterPages;

public class HomeActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //combine the variables with views in XML file

        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        viewPager = (ViewPager)findViewById(R.id.ControlPages);

        //here set adapter to viewPager

        AdapterPages adapter = new AdapterPages(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        //here set viewPager to tabLayout for combine tabLayout with viewPager
        //and set icons to tabLayout

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.mipmap.hotel);
        tabLayout.getTabAt(1).setIcon(R.mipmap.icon_restaurant);
        tabLayout.getTabAt(2).setIcon(R.mipmap.icon_bank);
        tabLayout.getTabAt(3).setIcon(R.mipmap.ic_monu);
        tabLayout.getTabAt(4).setIcon(R.mipmap.icon_history);

    }
}
