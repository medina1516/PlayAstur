//Clase creada para implementar el uso de mapas



/*package es.uniovi.imovil.angel.playastur;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
*/
/**
 * Created by Angel on 30/06/2017.
 */
/*
public class MapaActivity {

    private GoogleMap mMap;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }


    void addGijonMarker() {
        double gijonLatitude = 43.536979;
        double gijonLongitude = -5.664530;
        LatLng gijonLatLong = new LatLng(gijonLatitude, gijonLongitude);

        // TODO: la cadena debería estar en recursos
        MarkerOptions marker = new MarkerOptions().
                position(gijonLatLong)
                .title("Hola, soy Gijón");

        mMap.addMarker(marker);
    }

    private boolean isGooglePlayServicesAvailable() {
        int result = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (result == ConnectionResult.SUCCESS) {
            // El dispositivo tiene los servicios disponibles
            return true;
        }

        // Hay algún problema. Comprobar si lo puede resolver el usuario
        if (!GooglePlayServicesUtil.isUserRecoverableError(result)) {
            // No lo puede resolver el usuario. Mostrar un mensaje
            Toast.makeText(this, Toast.LENGTH_LONG).show();
            // TODO: la cadena debería estar en recursos
            "Se requiere Google Play Services y no es posible utilizarlo",
            return false;
        }

        // Sí lo puede resolver el usuario. Mostrar el diálogo
        Dialog errorDialog = GooglePlayServicesUtil.getErrorDialog(result,
                this, CONNECTION_FAILURE_RESOLUTION_REQUEST);
        if (errorDialog != null) {
            errorDialog.show();
        } else {
            Toast.makeText(this, Toast.LENGTH_LONG).show();
            // TODO: la cadena debería estar en recursos
            "Se requiere Google Play Services y no es posible utilizarlo",
        }
        return false; // De momento, no están disponibles
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CONNECTION_FAILURE_RESOLUTION_REQUEST) {
            // El usuario ha acabado con la gestión del problema en los
            // Google Play Services
            if (resultCode == Activity.RESULT_OK) {
                // Lo ha arreglado. No hace falta que hagamos nada: se hará
                // en el onResume()
            } else {
                // No lo ha arreglado
                Toast.makeText(
                        this,
                        // TODO: la cadena debería estar en recursos
                        "No ha sido posible arreglar el problema. Error: "
                                + resultCode + ". "
                                + "Sin Google Play Services no se puede utilizar la "
                                + "aplicación",
                        Toast.LENGTH_LONG).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void setUpMapIfNeeded() {
        // Comparamos con null para no instanciar el mapa más de una vez
        if (mMap != null) {
            return;
        }

        mMap = ((SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map)).getMap();
        // Check if we were successful in obtaining the map.
        if (mMap == null) {
            // El mapa no ha sido cargado correctamente
            Toast.makeText(this, "No se ha podido cargar el mapa",
                    Toast.LENGTH_LONG).show();
        }
    }


}
*/