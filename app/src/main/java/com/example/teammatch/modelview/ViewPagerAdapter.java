package com.example.teammatch.modelview;

import com.example.teammatch.view.Fragment.ControllerFragment;
import com.example.teammatch.view.Fragment.DuelistFragment;
import com.example.teammatch.view.Fragment.InitiatorFragment;
import com.example.teammatch.view.Fragment.SentinelFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new ControllerFragment();
            case 1:
                return new DuelistFragment();
            case 2:
                return new InitiatorFragment();
            case 3:
                return new SentinelFragment();
            default:
                return new ControllerFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
