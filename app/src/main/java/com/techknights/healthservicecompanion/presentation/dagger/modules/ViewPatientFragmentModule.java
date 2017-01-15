package com.techknights.healthservicecompanion.presentation.dagger.modules;

import com.techknights.healthservicecompanion.domain.interactors.base.PatientInteractor;
import com.techknights.healthservicecompanion.presentation.dagger.scopes.FragmentScope;
import com.techknights.healthservicecompanion.presentation.presenter.base.ViewPatientPresenter;
import com.techknights.healthservicecompanion.presentation.presenter.impl.ViewPatientPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by adityathanekar on 15/01/17.
 */

@Module
public class ViewPatientFragmentModule {

    @FragmentScope
    @Provides
    ViewPatientPresenter provideViewPatientPresenter(PatientInteractor interactor) {
        return new ViewPatientPresenterImpl(interactor);
    }

}
