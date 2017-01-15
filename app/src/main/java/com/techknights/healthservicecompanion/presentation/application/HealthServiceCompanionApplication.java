package com.techknights.healthservicecompanion.presentation.application;

import android.app.Application;

import com.techknights.healthservicecompanion.presentation.dagger.components.AddPatientFragmentComponent;
import com.techknights.healthservicecompanion.presentation.dagger.components.ApplicationComponent;
import com.techknights.healthservicecompanion.presentation.dagger.components.DaggerApplicationComponent;
import com.techknights.healthservicecompanion.presentation.dagger.components.ViewPatientFragmentComponent;
import com.techknights.healthservicecompanion.presentation.dagger.modules.AddPatientFragmentModule;
import com.techknights.healthservicecompanion.presentation.dagger.modules.ApplicationModule;
import com.techknights.healthservicecompanion.presentation.dagger.modules.ViewPatientFragmentModule;

/**
 * Created by adityathanekar on 11/01/17.
 */

public final class HealthServiceCompanionApplication extends Application {
    private ApplicationComponent applicationComponent;
    private ViewPatientFragmentComponent viewPatientFragmentComponent;
    private AddPatientFragmentComponent addPatientFragmentComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public ViewPatientFragmentComponent createViewPatientFragmentComponent() {
        viewPatientFragmentComponent =  applicationComponent.plus(new ViewPatientFragmentModule());
        return viewPatientFragmentComponent;
    }

    public void releaseViewPatientFragmentComponent() {
        viewPatientFragmentComponent = null;
    }

    public AddPatientFragmentComponent createAddPatientFragmentComponent() {
        addPatientFragmentComponent =  applicationComponent.plus(new AddPatientFragmentModule());
        return addPatientFragmentComponent;
    }

    public void releaseAddPatientFragmentComponent() {
        addPatientFragmentComponent = null;
    }

}
