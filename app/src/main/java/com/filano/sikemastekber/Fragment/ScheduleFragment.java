package com.filano.sikemastekber.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.filano.sikemastekber.R;

import java.util.ArrayList;
import java.util.List;

public class ScheduleFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    public ScheduleFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_schedule, container, false);
        viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(Color.parseColor("#4DFFFFFF"), Color.parseColor("#ffffff"));
        return rootView;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new ScheduleRecyclerFragment(), "Senin");
        adapter.addFragment(new ScheduleRecyclerFragment(), "Selasa");
        adapter.addFragment(new ScheduleRecyclerFragment(), "Rabu");
        adapter.addFragment(new ScheduleRecyclerFragment(), "Kamis");
        adapter.addFragment(new ScheduleRecyclerFragment(), "Jumat");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private final List<ScheduleRecyclerFragment> mScheduleRecyclerFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public ScheduleRecyclerFragment getItem(int position) {
            return mScheduleRecyclerFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mScheduleRecyclerFragmentList.size();
        }

        public void addFragment(ScheduleRecyclerFragment scheduleRecyclerFragment, String title) {
            mScheduleRecyclerFragmentList.add(scheduleRecyclerFragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}