package com.example.android.quakereport;

/**
 * Created by Mateusz on 14/09/2017.
 */

public class Earthquake {

    //The magnitude of the Earthquake
    private String mMagitude;

    //The location of the Earthquake
    private String mLocation;

    //The date of the Earthquake
    private String mDate;

    public Earthquake(String mMagitude, String mLocation, String mDate) {
        this.mMagitude = mMagitude;
        this.mLocation = mLocation;
        this.mDate = mDate;
    }

    public String getMagitude() {
        return mMagitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getDate() {
        return mDate;
    }
}
