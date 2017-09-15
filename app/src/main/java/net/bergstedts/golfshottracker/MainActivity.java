package net.bergstedts.golfshottracker;

import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {

    private static final float LOCATION_TRACKING_MIN_DISTANCE = 15f;
    private static final float ACCEPTED_ACCURACY = 50f;

     // fused location api
    private FusedLocationProviderClient mFusedLocationClient;
    private LocationRequest mLocationRequest;
    private LocationCallback mLocationCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner ClubSpinner = (Spinner) findViewById(R.id.ClubSpinner);
        ArrayAdapter<CharSequence> ClubAdapter = ArrayAdapter.createFromResource(this, R.array.Clubs, android.R.layout.simple_spinner_item);
        ClubAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ClubSpinner.setAdapter(ClubAdapter);

        Spinner LieSpinner = (Spinner) findViewById(R.id.LieSpinner);
        ArrayAdapter<CharSequence> LieAdapter = ArrayAdapter.createFromResource(this, R.array.Lies, android.R.layout.simple_spinner_item);
        LieAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        LieSpinner.setAdapter(LieAdapter);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            // ...
                        }
                    }
                });

            }
}
