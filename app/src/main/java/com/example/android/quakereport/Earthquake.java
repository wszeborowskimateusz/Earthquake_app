package com.example.android.quakereport;

/**
 * Created by Mateusz on 14/09/2017.
 */

public class Earthquake {

    //The magnitude of the Earthquake
    private double mMagitude;

    //The location of the Earthquake
    private String mLocation;

    /** Time of the earthquake */
    private long mTimeInMilliseconds;

    //The magnitude of the Earthquake
    private String mURL;

    public String getmURL() {
        return mURL;
    }

    public Earthquake(double mMagitude, String mLocation, long mTime,String url) {
        this.mMagitude = mMagitude;
        this.mLocation = mLocation;
        this.mTimeInMilliseconds = mTime;
        this.mURL = url;
    }

    public double getMagitude() {
        return mMagitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }
}
