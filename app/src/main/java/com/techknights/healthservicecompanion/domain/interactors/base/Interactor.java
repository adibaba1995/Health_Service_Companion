package com.techknights.healthservicecompanion.domain.interactors.base;

import com.techknights.healthservicecompanion.domain.model.Data;

/**
 * Created by adityathanekar on 15/01/17.
 */

public abstract class Interactor<T extends Data> {
    private Callback callback;

    public abstract void insert(T data);

    public abstract void update(T data);

    public abstract void delete(T data);

    public interface Callback {
        void dataChanged(Data data);
        void dataAddedSuccessfully();
        void clear();
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public Callback getCallback() {
        return callback;
    }
}
