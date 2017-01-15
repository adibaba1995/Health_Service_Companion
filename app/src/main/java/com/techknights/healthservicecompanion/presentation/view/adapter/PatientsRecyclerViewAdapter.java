package com.techknights.healthservicecompanion.presentation.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techknights.healthservicecompanion.domain.model.Patient;
import com.techknights.healthservicecompanion.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by adityathanekar on 11/01/17.
 */

public class PatientsRecyclerViewAdapter extends RecyclerView.Adapter<PatientsRecyclerViewAdapter.PatientsRecyclerViewHolder> {

    LayoutInflater inflater;
    List<Patient> patientList;

    public PatientsRecyclerViewAdapter(Context context, List<Patient> patientList) {
        inflater = LayoutInflater.from(context);
        this.patientList = patientList;
    }

    @Override
    public PatientsRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        PatientsRecyclerViewHolder holder = new PatientsRecyclerViewHolder(inflater.inflate(R.layout.patients_recycler_view_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(PatientsRecyclerViewHolder holder, int position) {
        Patient patient = patientList.get(position);
        holder.name.setText(patient.getName());
        holder.phone.setText(patient.getPhone());
    }

    @Override
    public int getItemCount() {
        return patientList.size();
    }

    public class PatientsRecyclerViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.phone)
        TextView phone;

        public PatientsRecyclerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
