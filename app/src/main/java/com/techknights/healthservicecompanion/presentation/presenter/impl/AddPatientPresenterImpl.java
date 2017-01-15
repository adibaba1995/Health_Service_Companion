package com.techknights.healthservicecompanion.presentation.presenter.impl;

import android.net.Uri;

import com.techknights.healthservicecompanion.domain.interactors.base.PatientInteractor;
import com.techknights.healthservicecompanion.domain.model.Patient;
import com.techknights.healthservicecompanion.presentation.presenter.base.AddPatientPresenter;

import javax.inject.Inject;

/**
 * Created by adityathanekar on 15/01/17.
 */

public class AddPatientPresenterImpl extends AddPatientPresenter {

    PatientInteractor interactor;

    @Inject
    public AddPatientPresenterImpl(PatientInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void addPatient(Uri photo, Patient patient) {
        interactor.insert(photo, patient);
    }

    @Override
    public void addPatient(Patient patient) {

    }
}
