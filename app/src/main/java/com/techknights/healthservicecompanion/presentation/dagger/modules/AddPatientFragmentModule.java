package com.techknights.healthservicecompanion.presentation.dagger.modules;

import com.techknights.healthservicecompanion.domain.interactors.base.PatientInteractor;
import com.techknights.healthservicecompanion.presentation.dagger.scopes.FragmentScope;
import com.techknights.healthservicecompanion.presentation.presenter.base.AddPatientPresenter;
import com.techknights.healthservicecompanion.presentation.presenter.base.ViewPatientPresenter;
import com.techknights.healthservicecompanion.presentation.presenter.impl.AddPatientPresenterImpl;
import com.techknights.healthservicecompanion.presentation.presenter.impl.ViewPatientPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by adityathanekar on 15/01/17.
 */

@Module
public class AddPatientFragmentModule {

    @FragmentScope
    @Provides
    AddPatientPresenter provideAddPatientPresenter(PatientInteractor interactor) {
        return new AddPatientPresenterImpl(interactor);
    }

}
