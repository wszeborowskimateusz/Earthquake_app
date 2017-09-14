package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
        TextView magntude = (TextView) listItemView.findViewById(R.id.magnitude_text_view);
        // Get the magnitude from the current Earthquake object and
        // set this text on the name TextView

        //Formating magnitude to [0.0]
        magntude.setText(formatMagnitude(currentEarthquake.getMagitude()));


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
}
