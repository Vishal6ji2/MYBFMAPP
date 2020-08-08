package com.example.bfmapp.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.bfmapp.Fragments.CategoryFragment;
import com.example.bfmapp.Fragments.PeopleFragment;

public class SearchTabAdapter extends FragmentStateAdapter {

    public SearchTabAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        if (position == 0) {
            return new PeopleFragment();
        }
        return new CategoryFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
