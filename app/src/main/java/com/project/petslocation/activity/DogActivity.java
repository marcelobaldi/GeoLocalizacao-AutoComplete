package com.project.petslocation.activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.project.petslocation.R;
import com.project.petslocation.adapter.PlaceAutocompleteAdapter;

public class DogActivity extends AppCompatActivity implements OnMapReadyCallback {
    private AutoCompleteTextView local;
    private PlaceAutocompleteAdapter placeAutocompleteAdapter;
    private static final LatLngBounds LAT_LNG_BOUNDS = new LatLngBounds(new LatLng(-40, -168), new LatLng(71, 136));

    @Override protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog);
        local = findViewById(R.id.txtLocal);

        placeAutocompleteAdapter = new PlaceAutocompleteAdapter(this, Places.getGeoDataClient(this), LAT_LNG_BOUNDS, null);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        if(mapFragment != null)
            mapFragment.getMapAsync(this);

        local.setEnabled(true);
        local.requestFocus();
        local.getText().clear();
        local.setAdapter(placeAutocompleteAdapter);
    }

    @Override public void onMapReady(GoogleMap googleMap) { }
}







//    private void marcarPessoa() {
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                return;
//            }
//            mMap.setMyLocationEnabled(true);
//        }else {
//            mMap.addMarker(new MarkerOptions().position(localUsuario).title("Meu local").icon(BitmapDescriptorFactory.fromResource(R.drawable.localizacao_usuario)));
//        }
//    }
