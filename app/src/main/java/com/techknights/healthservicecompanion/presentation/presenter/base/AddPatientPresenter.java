package com.techknights.healthservicecompanion.presentation.presenter.base;

import android.net.Uri;

import com.techknights.healthservicecompanion.domain.model.Patient;
import com.techknights.healthservicecompanion.presentation.view.AddPatientView;

/**
 * Created by adityathanekar on 15/01/17.
 */

public abstract class AddPatientPresenter extends BasePresenter<AddPatientView> {
    public abstract void addPatient(Uri photo, Patient patient);
    public abstract void addPatient(Patient patient);
}
