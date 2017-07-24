package com.boomsya.smartwizard;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWizardModel implements ModelCallbacks {

    private List<ModelCallbacks> mListeners = new ArrayList<ModelCallbacks>();
    private PageList mRootPageList;

    public AbstractWizardModel(Context appContext) {
    	mRootPageList = onNewRootPageList(appContext);
    }

    /**
     * Override this to define a new wizard model.
     */
    protected abstract PageList onNewRootPageList(Context context);

    @Override
    public void onPageDataChanged(Page page) {
        // can't use for each because of concurrent modification (review fragment
        // can get added or removed and will register itself as a listener)
        for (int i = 0; i < mListeners.size(); i++) {
            mListeners.get(i).onPageDataChanged(page);
        }
    }

    @Override
    public void onPageTreeChanged() {
        // can't use for each because of concurrent modification (review fragment
        // can get added or removed and will register itself as a listener)
        for (int i = 0; i < mListeners.size(); i++) {
            mListeners.get(i).onPageTreeChanged();
        }
    }

    public Page findByKey(String key) {
        return mRootPageList.findByKey(key);
    }

    public Page findByClassName(Class classname) {
        return mRootPageList.findByClassName(classname);
    }

    public Integer PagesCount() {
        return mRootPageList.size();
    }

    public void load(Bundle savedValues) {
        for (String key : savedValues.keySet()) {
            mRootPageList.findByKey(key).resetData(savedValues.getBundle(key));
        }
    }

    public void registerListener(ModelCallbacks listener) {
        mListeners.add(listener);
    }

    public Bundle save() {
        Bundle bundle = new Bundle();
        for (Page page : getCurrentPageSequence()) {
            bundle.putBundle(page.getKey(), page.getData());
        }
        return bundle;
    }

    /**
     * Gets the current list of wizard steps, flattening nested (dependent) pages based on the
     * user's choices.
     */
    public List<Page> getCurrentPageSequence() {
        ArrayList<Page> flattened = new ArrayList<Page>();
        mRootPageList.flattenCurrentPageSequence(flattened);
        return flattened;
    }

    public void unregisterListener(ModelCallbacks listener) {
        mListeners.remove(listener);
    }
}
