package es.uniovi.imovil.angel.playastur;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by Angel on 28/06/2017.
 */

public class PlayaActivity extends AppCompatActivity {
//Clase que permite visualizar la informacion de cada playa en concreto: nombre, descripcion,...


    TextView tv_nombre;
    TextView tv_descripcion;
    ImageView iv_foto;
    String imageHttpAddress;
    private Bitmap loadedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playa);

        Playa playa = MainActivity.arrayPlayas.directorio.get(MainActivity.arrayPlayas.getSelected());


        tv_nombre = (TextView) findViewById(R.id.playa_nombre);
        tv_nombre.setText(playa.getNombre());

        tv_descripcion = (TextView) findViewById(R.id.playa_descripcion);

        tv_descripcion = (TextView) findViewById(R.id.playa_descripcion);
        if (playa.getDescripcion() != null) {
            tv_descripcion.setText(Html.fromHtml(playa.getDescripcion()));
        } else {
            tv_descripcion.setText(R.string.ejemploDescripcionNoDisponible);
        }

       /* if(playa.getFoto()!= null) {
            imageHttpAddress = playa.getFoto();
            iv_foto = (ImageView) findViewById(R.id.playa_foto);
            downloadFile(imageHttpAddress);
        }*/

    }

    void downloadFile(String imageHttpAddress) {
        URL imageUrl = null;
        try {
            imageUrl = new URL(imageHttpAddress);
            HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
            conn.connect();
            loadedImage = BitmapFactory.decodeStream(conn.getInputStream());
            iv_foto.setImageBitmap(loadedImage);
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Error cargando la imagen: " + e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
