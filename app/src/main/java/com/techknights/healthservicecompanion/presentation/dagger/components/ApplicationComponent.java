package com.techknights.healthservicecompanion.presentation.dagger.components;

import com.techknights.healthservicecompanion.presentation.application.HealthServiceCompanionApplication;
import com.techknights.healthservicecompanion.presentation.dagger.modules.AddPatientFragmentModule;
import com.techknights.healthservicecompanion.presentation.dagger.modules.ApplicationModule;
import com.techknights.healthservicecompanion.presentation.dagger.modules.ViewPatientFragmentModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by adityathanekar on 15/01/17.
 */

@Component(modules = { ApplicationModule.class }) @Singleton
public interface ApplicationComponent {
    void inject(HealthServiceCompanionApplication target);
    ViewPatientFragmentComponent plus(ViewPatientFragmentModule module);
    AddPatientFragmentComponent plus(AddPatientFragmentModule module);
}
