package com.techknights.healthservicecompanion.presentation.view.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.techknights.healthservicecompanion.databinding.FragmentAddPatientBinding;
import com.techknights.healthservicecompanion.domain.model.Patient;
import com.techknights.healthservicecompanion.R;
import com.techknights.healthservicecompanion.presentation.application.HealthServiceCompanionApplication;
import com.techknights.healthservicecompanion.presentation.presenter.base.AddPatientPresenter;
import com.techknights.healthservicecompanion.presentation.view.AddPatientView;
import com.techknights.healthservicecompanion.presentation.view.ViewPatientView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_OK;

/**
 * Created by adityathanekar on 10/01/17.
 */

public class AddPatientFragment extends Fragment implements AddPatientView{

    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.profile_image)
    CircleImageView profileImage;

    private Unbinder unbinder;
    private Uri profileUri;

    @Inject
    AddPatientPresenter presenter;

    private static final int RC_PHOTO_PICKER =  2;

    @Override
    public void onResume() {
        super.onResume();
        presenter.attachView(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((HealthServiceCompanionApplication)getActivity().getApplication()).createAddPatientFragmentComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentAddPatientBinding binding = FragmentAddPatientBinding.inflate(inflater, container, false);
        binding.setHandler(this);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
    }

    public void onClickAddPatient(View view) {
        Patient patient = new Patient(name.getText().toString(), phone.getText().toString());
        presenter.addPatient(patient);
    }

    public void onClickProfile(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/jpeg");
        intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
        startActivityForResult(Intent.createChooser(intent, "Complete action using"), RC_PHOTO_PICKER);
    }

    public void onClickCancel(View view) {
        getActivity().finish();
    }

    @Override
    public void showAddSuccessAcknowledgement() {
        Snackbar.make(coordinatorLayout, R.string.patient_add_success, Snackbar.LENGTH_SHORT).show();
        name.setText("");
        phone.setText("");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_PHOTO_PICKER && resultCode == RESULT_OK) {
            profileUri = data.getData();
            profileImage.setImageURI(profileUri);
        }
    }
}
