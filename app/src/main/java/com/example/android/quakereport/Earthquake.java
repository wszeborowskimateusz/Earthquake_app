package com.example.android.quakereport;

/**
 * Created by Mateusz on 14/09/2017.
 */

public class Earthquake {

    //The magnitude of the Earthquake
    private String mMagitude;

    //The location of the Earthquake
    private String mLocation;

    /** Time of the earthquake */
    private long mTimeInMilliseconds;

    public Earthquake(String mMagitude, String mLocation, long mTime) {
        this.mMagitude = mMagitude;
        this.mLocation = mLocation;
        this.mTimeInMilliseconds = mTime;
    }

    public String getMagitude() {
        return mMagitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }
}
