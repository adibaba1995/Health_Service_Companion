package com.techknights.healthservicecompanion.network;

import android.net.Uri;
import android.support.design.widget.Snackbar;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.techknights.healthservicecompanion.R;
import com.techknights.healthservicecompanion.domain.model.Patient;

import javax.inject.Inject;

/**
 * Created by adityathanekar on 15/01/17.
 */

public class PatientServiceImpl extends PatientService{

    private DatabaseReference databaseReference;
    private StorageReference storageReference;

    @Inject
    public PatientServiceImpl(DatabaseReference databaseReference, StorageReference storageReference) {
        this.databaseReference = databaseReference;
        this.storageReference = storageReference;
        init();
    }

    private void init() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(getCallbacks() != null)
                    getCallbacks().clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Patient patient = postSnapshot.getValue(Patient.class);
                    if(getCallbacks() != null)
                        getCallbacks().dataChanged(patient);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(getCallbacks() != null)
                    getCallbacks().dataAddedSuccessfully();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void addPatient(Uri photo, final Patient patient) {
        if(photo != null) {
            StorageReference photoRef = storageReference.child(photo.getLastPathSegment());
            photoRef.putFile(photo).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Uri uri = taskSnapshot.getDownloadUrl();
                    patient.setPhoto(uri);
                    databaseReference.push().setValue(patient);
                }
            });
        } else {
            databaseReference.push().setValue(patient);
        }
    }
}
