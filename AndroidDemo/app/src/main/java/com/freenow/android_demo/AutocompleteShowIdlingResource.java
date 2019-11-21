package com.freenow.android_demo;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.support.test.espresso.IdlingResource;
import android.widget.AutoCompleteTextView;

class AutocompleteShowIdlingResource implements IdlingResource {

    private Activity activity;
    private @IdRes int resId;
    private ResourceCallback resourceCallback;

    public AutocompleteShowIdlingResource(Activity activity, @IdRes int resId) {
        this.activity = activity;
        this.resId = resId;
    }

    @Override
    public String getName() {
        return this.getClass().getName() + resId;
    }

    @Override
    public boolean isIdleNow() {
        boolean idle = ((AutoCompleteTextView) activity.findViewById(resId)).getAdapter() != null;
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
