package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Mateusz on 14/09/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake>{

    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(@NonNull Context context,  @NonNull List<Earthquake> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_item, parent, false);
        }

        // Get the {@link Earthquake} object located at this position in the list
        final Earthquake currentEarthquake = getItem(position);


        // Find the TextView in the eqrthquake_item.xml layout with the ID magnitude_text_view
        TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitude_text_view);
        // Get the magnitude from the current Earthquake object and
        // set this text on the name TextView

        //Formating magnitude to [0.0]
        magnitude.setText(formatMagnitude(currentEarthquake.getMagitude()));


        String location = currentEarthquake.getLocation();
        String formatedLocationOffset="";
        String formatedPrimaryLocation=location;

        if(location.contains(LOCATION_SEPARATOR)) {
            String [] parts = location.split(LOCATION_SEPARATOR);
            formatedLocationOffset = parts[0] + LOCATION_SEPARATOR;
            formatedPrimaryLocation = parts[1];
        }
        else formatedLocationOffset = getContext().getString(R.string.near_the);;

        // Find the TextView in the eqrthquake_item.xml layout with the ID location_text_view
        TextView primaryLocation = (TextView) listItemView.findViewById(R.id.primary_location_text_view);
        // Get the location from the current Earthquake object and
        // set this text on the number TextView
        primaryLocation.setText(formatedPrimaryLocation);

        // Find the TextView in the eqrthquake_item.xml layout with the ID location_text_view
        TextView locationOffset = (TextView) listItemView.findViewById(R.id.location_offset_text_view);

        // Get the location from the current Earthquake object and
        // set this text on the number TextView
        locationOffset.setText(formatedLocationOffset);


        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());

        // Find the TextView in the eqrthquake_item.xml layout with the ID date_text_view
        TextView date = (TextView) listItemView.findViewById(R.id.date_text_view);

        String formatedDate = formatDate(dateObject);

        date.setText(formatedDate);

        // Find the TextView in the eqrthquake_item.xml layout with the ID date_text_view
        TextView time = (TextView) listItemView.findViewById(R.id.time_text_view);

        String formatedTime = formatTime(dateObject);

        time.setText(formatedTime);



        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }


    private int getMagnitudeColor(double magnitude){
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
