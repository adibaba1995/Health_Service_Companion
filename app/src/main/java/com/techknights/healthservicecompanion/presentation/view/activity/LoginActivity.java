package com.techknights.healthservicecompanion.presentation.view.activity;

import android.support.v4.app.Fragment;

import com.techknights.healthservicecompanion.presentation.view.fragment.LoginFragment;

/**
 * Created by adityathanekar on 09/01/17.
 */

public class LoginActivity extends SingleFragmentActivity {

    @Override
    public Fragment newInstance() {
        return new LoginFragment();
    }

}
