package com.example.teammatch.view.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.teammatch.R;
import com.example.teammatch.modelview.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

public class SoloFragment extends Fragment {

    private ImageButton controller, initiator, duelist, Sentinel;
    private String userRole;
    private ViewPager2 mViewPager2;
    private TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_solo, container, false);
        int[] tabIcons = {R.drawable.controller_icon,
                R.drawable.duelist_icon,
                R.drawable.initiator_icon,
                R.drawable.sentinel_icon};

        // Set up the ViewPager with the sections adapter.
        tabLayout = (TabLayout) view.findViewById(R.id.tabs_up);
        mViewPager2 = view.findViewById(R.id.viewpager);
        mViewPager2.setAdapter(new ViewPagerAdapter(this.getActivity()));
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout, mViewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setIcon(tabIcons[position]);
                        break;
                    case 1:
                        tab.setIcon(tabIcons[position]);
                        break;
                    case 2:
                        tab.setIcon(tabIcons[position]);
                        break;
                    case 3:
                        tab.setIcon(tabIcons[position]);
                        break;
                }
            }

        });
        tabLayoutMediator.attach();
        return view;
    }
}
