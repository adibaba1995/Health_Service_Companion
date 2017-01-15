package com.techknights.healthservicecompanion.network;

import android.net.Uri;

import com.techknights.healthservicecompanion.domain.model.Patient;

/**
 * Created by adityathanekar on 15/01/17.
 */

public abstract class PatientService extends BaseService {
    public abstract void addPatient(Uri photo, Patient patient);
}
