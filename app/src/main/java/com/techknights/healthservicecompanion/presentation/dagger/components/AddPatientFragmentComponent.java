package com.techknights.healthservicecompanion.presentation.dagger.components;

import com.techknights.healthservicecompanion.presentation.dagger.modules.AddPatientFragmentModule;
import com.techknights.healthservicecompanion.presentation.dagger.modules.PatientModule;
import com.techknights.healthservicecompanion.presentation.dagger.scopes.FragmentScope;
import com.techknights.healthservicecompanion.presentation.view.fragment.AddPatientFragment;

import dagger.Subcomponent;

/**
 * Created by adityathanekar on 15/01/17.
 */

@FragmentScope
@Subcomponent(modules = {AddPatientFragmentModule.class, PatientModule.class })
public interface AddPatientFragmentComponent {
    void inject(AddPatientFragment target);
}