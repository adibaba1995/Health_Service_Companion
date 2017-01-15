package com.techknights.healthservicecompanion.domain.interactors.impl;

import android.net.Uri;

import com.techknights.healthservicecompanion.domain.interactors.base.PatientInteractor;
import com.techknights.healthservicecompanion.domain.model.Data;
import com.techknights.healthservicecompanion.domain.model.Patient;
import com.techknights.healthservicecompanion.network.BaseService;
import com.techknights.healthservicecompanion.network.PatientService;

import javax.inject.Inject;

/**
 * Created by adityathanekar on 15/01/17.
 */

public class PatientInteractorImpl extends PatientInteractor {
    PatientService patientService;

    @Inject
    public PatientInteractorImpl(PatientService patientService) {
        this.patientService = patientService;
        patientService.setCallbacks(new BaseService.Callbacks() {
            @Override
            public void dataChanged(Data data) {
                if (getCallback() != null)
                    getCallback().dataChanged(data);
            }

            @Override
            public void clear() {
                if (getCallback() != null)
                    getCallback().clear();
            }

            @Override
            public void dataAddedSuccessfully() {
                if (getCallback() != null)
                    getCallback().dataAddedSuccessfully();
            }
        });
    }

    @Override
    public void insert(Patient data) {
        insert(null, data);
    }

    @Override
    public void update(Patient data) {

    }

    @Override
    public void delete(Patient data) {

    }

    @Override
    public void insert(Uri photo, Patient patient) {
        patientService.addPatient(photo, patient);
    }
}
