package com.filano.sikemastekber.Activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.filano.sikemastekber.Fragment.HomeFragment;
import com.filano.sikemastekber.Fragment.ProfileFragment;
import com.filano.sikemastekber.Fragment.ScheduleFragment;
import com.filano.sikemastekber.Fragment.ScheduleRecyclerFragment;
import com.filano.sikemastekber.NotificationHelper;
import com.filano.sikemastekber.R;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bn_main);
        loadFragment(new HomeFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }


    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.nav_home:
                fragment = new HomeFragment();
                break;
            case R.id.nav_schedule:
                fragment = new ScheduleFragment();
                break;
            case R.id.nav_profile:
                fragment = new ProfileFragment();
                break;
        }
        return loadFragment(fragment);
    }

}
