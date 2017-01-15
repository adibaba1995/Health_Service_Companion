package com.techknights.healthservicecompanion.presentation.view.activity;

import android.support.v4.app.Fragment;

import com.techknights.healthservicecompanion.presentation.view.fragment.AddPatientFragment;

/**
 * Created by adityathanekar on 10/01/17.
 */

public class AddPatientActivity extends SingleFragmentActivity {

    @Override
    public Fragment newInstance() {
        return new AddPatientFragment();
    }

}
