package com.techknights.healthservicecompanion.domain.interactors.base;

import android.net.Uri;

import com.techknights.healthservicecompanion.domain.model.Data;
import com.techknights.healthservicecompanion.domain.model.Patient;
import com.techknights.healthservicecompanion.network.BaseService;
import com.techknights.healthservicecompanion.network.PatientService;

import javax.inject.Inject;

/**
 * Created by adityathanekar on 15/01/17.
 */

public abstract class PatientInteractor extends Interactor<Patient> {
    public abstract void insert(Uri photo, Patient patient);
}
