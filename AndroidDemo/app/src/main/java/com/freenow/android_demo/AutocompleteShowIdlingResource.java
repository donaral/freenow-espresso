package com.freenow.android_demo;

import android.app.Activity;
import android.support.test.espresso.IdlingResource;
import android.widget.AutoCompleteTextView;

class AutocompleteShowIdlingResource implements IdlingResource {

    private AutoCompleteTextView autoCompleteTextView;
    private ResourceCallback resourceCallback;

    public AutocompleteShowIdlingResource(Activity activity) {
        this.autoCompleteTextView = activity.findViewById(R.id.textSearch);
    }

    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public boolean isIdleNow() {
        boolean idle = autoCompleteTextView.getAdapter() != null;
        if (idle) {
            resourceCallback.onTransitionToIdle();
        }
        return idle;
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        this.resourceCallback = callback;
    }
}
