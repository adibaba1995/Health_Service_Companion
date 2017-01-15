package com.techknights.healthservicecompanion.presentation.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.techknights.healthservicecompanion.presentation.view.fragment.ViewDoctorFragment;
import com.techknights.healthservicecompanion.presentation.view.fragment.ViewPatientFragment;

/**
 * Created by adityathanekar on 10/01/17.
 */

public class ManipulateUserContainerPagerAdapter extends FragmentPagerAdapter {
    private static final int NUM_PAGES = 2;

    public ManipulateUserContainerPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ViewPatientFragment();
            case 1:
                return new ViewDoctorFragment();
            default:
                return new Fragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "PATIENT";
            case 1:
                return "DOCTOR";
            default:
                return "";
        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
