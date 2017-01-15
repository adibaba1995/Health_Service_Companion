package com.techknights.healthservicecompanion.presentation.view;

import com.techknights.healthservicecompanion.domain.model.Patient;

/**
 * Created by adityathanekar on 15/01/17.
 */

public interface ViewPatientView extends BaseView {
    void dataChanged(Patient patient);
    void clearList();
}
