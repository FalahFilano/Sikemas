package com.filano.sikemastekber.Activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.filano.sikemastekber.Fragment.DosenHomeFragment;
import com.filano.sikemastekber.Fragment.DosenScheduleFragment;
import com.filano.sikemastekber.Fragment.HomeFragment;
import com.filano.sikemastekber.Fragment.ProfileFragment;
import com.filano.sikemastekber.Fragment.ScheduleFragment;
import com.filano.sikemastekber.R;

public class DosenMainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen_main);
        bottomNavigationView = findViewById(R.id.bn_main);
        loadFragment(new DosenHomeFragment());
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
                fragment = new DosenHomeFragment();
                break;
            case R.id.nav_schedule:
                fragment = new DosenScheduleFragment();
                break;
            case R.id.nav_profile:
                fragment = new ProfileFragment();
                break;
        }
        return loadFragment(fragment);
    }
}
