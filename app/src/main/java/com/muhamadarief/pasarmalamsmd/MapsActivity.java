package com.muhamadarief.pasarmalamsmd;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.muhamadarief.pasarmalamsmd.model.Pasar;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    public static final String TAG = "MapsActivity";

    private GoogleMap mMap;
    private Pasar mPasar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mPasar = (Pasar)getIntent().getSerializableExtra("data");
        Log.d(TAG, mPasar.getNama_lokasi());
        if (mPasar == null) {
            throw new IllegalArgumentException("Must pass DATA_PASAR");
        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Toast.makeText(this, ""+mPasar.getNama_lokasi(), Toast.LENGTH_SHORT).show();

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

        Double lat = mPasar.getLattitude();
        Double lng = mPasar.getLongitude();

        LatLng pasar = new LatLng(lat, lng);
        mMap.addMarker(new MarkerOptions().position(pasar));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pasar, 17));

        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                View view = getLayoutInflater().inflate(R.layout.info_window_marker, null);

                TextView txt_nama_pasar = (TextView) view.findViewById(R.id.txt_nama_pasar);
                TextView txt_hari = (TextView) view.findViewById(R.id.txt_hari);
                TextView txt_jam = (TextView) view.findViewById(R.id.txt_jam);

                txt_nama_pasar.setText(mPasar.getNama_lokasi());
                txt_jam.setText(mPasar.getJam());
                txt_hari.setText(mPasar.getHari());

                return view;
            }
        });

       /* LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/

    }
}
