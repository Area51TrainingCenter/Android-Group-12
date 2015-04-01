package com.johannfjs.sesion27;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MainActivity extends ActionBarActivity {
    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        map.setMyLocationEnabled(true);
        ponerPin();
        obtenerPosicion();
    }

    private void obtenerPosicion() {
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria, true);
        Location location = locationManager.getLastKnownLocation(provider);
        map.addMarker(new MarkerOptions().position(new LatLng(location.getLatitude(), location.getLongitude())).
                title("Posicion").snippet("Posicion").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));

    }

    private void ponerPin() {
        map.addMarker(new MarkerOptions().position(new LatLng(-11, 12)).
                title("Aca estamos").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-11, 12), 15));
        map.animateCamera(CameraUpdateFactory.zoomTo(15));
    }

    @Override
    protected void onResume() {
        super.onResume();
        map.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {
                map.clear();
                map.addMarker(new MarkerOptions().position(new LatLng(location.getLatitude(), location.getLongitude())).
                        title("Aca estamos 2").snippet("Descripcion").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
            }
        });
        map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                map.addMarker(new MarkerOptions().position(latLng).
                        title("Aca estamos 2").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
                Toast.makeText(getApplicationContext(), "Posicion: " + latLng.latitude + " & " + latLng.longitude, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.mapa1) {
            map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            return true;
        } else if (id == R.id.mapa2) {
            map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            return true;
        } else if (id == R.id.mapa3) {
            map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            return true;
        } else if (id == R.id.mapa4) {
            map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
