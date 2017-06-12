package com.boomsya.smartwizard;

public class DataItem {
    public static final int DEFAULT_WEIGHT = 0;

    private int mWeight;
    private String mTitle;
    private Integer mDisplayValue;
    private String mPageKey;

    public DataItem(String title, Integer displayValue, String pageKey) {
        this(title, displayValue, pageKey, DEFAULT_WEIGHT);
    }

    public DataItem(String title, Integer displayValue, String pageKey, int weight) {
        mTitle = title;
        mDisplayValue = displayValue;
        mPageKey = pageKey;
        mWeight = weight;
    }

    public Integer getDisplayValue() {
        return mDisplayValue;
    }

    public void setDisplayValue(Integer displayValue) {
        mDisplayValue = displayValue;
    }

    public String getPageKey() {
        return mPageKey;
    }

    public void setPageKey(String pageKey) {
        mPageKey = pageKey;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public int getWeight() {
        return mWeight;
    }

    public void setWeight(int weight) {
        mWeight = weight;
    }
}
