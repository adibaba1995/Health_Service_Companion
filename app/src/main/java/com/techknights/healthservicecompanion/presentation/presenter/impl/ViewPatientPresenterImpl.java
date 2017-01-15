package com.techknights.healthservicecompanion.presentation.presenter.impl;


import com.techknights.healthservicecompanion.domain.interactors.base.Interactor;
import com.techknights.healthservicecompanion.domain.interactors.base.PatientInteractor;
import com.techknights.healthservicecompanion.domain.model.Data;
import com.techknights.healthservicecompanion.domain.model.Patient;
import com.techknights.healthservicecompanion.presentation.presenter.base.ViewPatientPresenter;
import com.techknights.healthservicecompanion.presentation.view.ViewPatientView;

import javax.inject.Inject;

/**
 * Created by adityathanekar on 15/01/17.
 */

public class ViewPatientPresenterImpl extends ViewPatientPresenter {

    PatientInteractor interactor;

    @Inject
    public ViewPatientPresenterImpl(PatientInteractor interactor) {
        this.interactor = interactor;
        interactor.setCallback(new Interactor.Callback() {
            @Override
            public void dataChanged(Data data) {
                ViewPatientView view = getView().get();
                if(view != null)
                    view.dataChanged((Patient)data);
            }

            @Override
            public void dataAddedSuccessfully() {

            }

            @Override
            public void clear() {
                ViewPatientView view = getView().get();
                if(view != null)
                    view.clearList();
            }
        });
    }

}
