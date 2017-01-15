package com.techknights.healthservicecompanion.presentation.dagger.components;

import com.techknights.healthservicecompanion.presentation.dagger.modules.PatientModule;
import com.techknights.healthservicecompanion.presentation.dagger.modules.ViewPatientFragmentModule;
import com.techknights.healthservicecompanion.presentation.dagger.scopes.FragmentScope;
import com.techknights.healthservicecompanion.presentation.view.fragment.ViewPatientFragment;

import dagger.Subcomponent;

/**
 * Created by adityathanekar on 15/01/17.
 */

@FragmentScope
@Subcomponent(modules = {ViewPatientFragmentModule.class, PatientModule.class })
public interface ViewPatientFragmentComponent {
    void inject(ViewPatientFragment target);
}
