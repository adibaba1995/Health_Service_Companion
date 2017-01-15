package com.techknights.healthservicecompanion.presentation.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techknights.healthservicecompanion.domain.model.Patient;
import com.techknights.healthservicecompanion.presentation.application.HealthServiceCompanionApplication;
import com.techknights.healthservicecompanion.presentation.presenter.base.ViewPatientPresenter;
import com.techknights.healthservicecompanion.presentation.view.ViewPatientView;
import com.techknights.healthservicecompanion.presentation.view.adapter.PatientsRecyclerViewAdapter;
import com.techknights.healthservicecompanion.R;
import com.techknights.healthservicecompanion.databinding.FragmentViewPatientBinding;
import com.techknights.healthservicecompanion.presentation.view.activity.AddPatientActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by adityathanekar on 10/01/17.
 */

public class ViewPatientFragment extends Fragment implements ViewPatientView{

    @BindView(R.id.patientsRecyclerView)
    RecyclerView patientsRecyclerView;

    private Unbinder unbinder;

    private PatientsRecyclerViewAdapter adapter;

    private List<Patient> patientList;

    @Inject
    ViewPatientPresenter presenter;

    @Override
    public void onResume() {
        super.onResume();
        presenter.attachView(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((HealthServiceCompanionApplication)getActivity().getApplication()).createViewPatientFragmentComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentViewPatientBinding binding =  FragmentViewPatientBinding.inflate(inflater, container, false);
        binding.setHandler(this);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        init();
    }

    private void init() {
        patientList = new ArrayList<>();
        adapter = new PatientsRecyclerViewAdapter(getActivity(), patientList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        patientsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        patientsRecyclerView.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), layoutManager.getOrientation());
        patientsRecyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((HealthServiceCompanionApplication) getActivity().getApplication()).releaseViewPatientFragmentComponent();
    }

    public void fabClicked(View view) {
        Intent intent = new Intent(getActivity(), AddPatientActivity.class);
        startActivity(intent);
    }

    @Override
    public void dataChanged(Patient patient) {
        patientList.add(patient);
        adapter.notifyItemChanged(patientList.size() - 1);
    }

    @Override
    public void clearList() {
        patientList.clear();
        adapter.notifyDataSetChanged();
    }
}
