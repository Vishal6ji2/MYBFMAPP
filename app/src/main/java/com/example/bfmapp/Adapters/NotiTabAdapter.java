package com.example.bfmapp.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.bfmapp.Fragments.AllFragment;
import com.example.bfmapp.Fragments.ProposalFragment;
import com.example.bfmapp.Fragments.SentFragment;

import java.util.ArrayList;

public class NotiTabAdapter extends FragmentStateAdapter {

//    ArrayList<String> arrayList = new ArrayList<>();
//    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();

    public NotiTabAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0:
                return new AllFragment();
            case 1:
                return new ProposalFragment();
            default:
                return new SentFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
