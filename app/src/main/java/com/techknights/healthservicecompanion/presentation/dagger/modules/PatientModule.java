package com.techknights.healthservicecompanion.presentation.dagger.modules;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.techknights.healthservicecompanion.domain.interactors.base.PatientInteractor;
import com.techknights.healthservicecompanion.domain.interactors.impl.PatientInteractorImpl;
import com.techknights.healthservicecompanion.network.PatientService;
import com.techknights.healthservicecompanion.network.PatientServiceImpl;
import com.techknights.healthservicecompanion.presentation.dagger.scopes.FragmentScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by adityathanekar on 15/01/17.
 */

@Module
public class PatientModule {

    @Provides
    @Named("NODE_NAME")
    String provideNodeName() {
        return "patients";
    }

    @Provides
    @Named("STORAGE_NAME")
    String provideStorageName() {
        return "patient_photos";
    }

    @FragmentScope
    @Provides
    DatabaseReference provideDatabaseReference(FirebaseDatabase firebaseDatabase, @Named("NODE_NAME")String nodeName) {
        return firebaseDatabase.getReference().child(nodeName);
    }

    @FragmentScope
    @Provides
    StorageReference provideStorageReference(FirebaseStorage firebaseStorage, @Named("STORAGE_NAME")String storageName) {
        return firebaseStorage.getReference().child(storageName);
    }

    @FragmentScope
    @Provides
    PatientService providePatientService(DatabaseReference databaseReference, StorageReference storageReference) {
        return new PatientServiceImpl(databaseReference, storageReference);
    }

    @FragmentScope
    @Provides
    PatientInteractor providePatientInteractor(PatientService service) {
        return new PatientInteractorImpl(service);
    }

}
