package es.uniovi.imovil.angel.playastur;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
//Esta es la clase principal, donde se incluyen varias de las funcionalidades mas importantes

    //URL para poder descargar el JSON
    public final String URL = "http://datos.gijon.es/doc/turismo/playas.json";

    public static Playas arrayPlayas;

    private TextView mTextMessage;

    //Uso de fragmentos
    private RecyclerViewAdapter adapter = null;
    private RecyclerView recyclerView = null;
    private RecyclerView.LayoutManager layoutManager = null;


    //Distintas opciones del bottom navigation, aunque en este momento no se emplea ninguna
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pedirJSON();

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Esto permite inflar el menu y anyadir acciones al action bar, si existe
        //se emplea navigation, que viene dado por la activity predefinida escogida (Bottom Navigation)
        getMenuInflater().inflate(R.menu.navigation, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public void pedirJSON() {
        //metodo para poder descargar los datos del JSON y hacer uso de ellos
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONObject datos = response.getJSONObject("directorios");
                    Gson gson = new Gson();
                    arrayPlayas = gson.fromJson(datos.toString(), Playas.class);

                    //System.out.println(arrayPlayas.directorio.get(1).getNombre());

                    recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

                    adapter = new RecyclerViewAdapter(MainActivity.this, arrayPlayas);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                    recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(MainActivity.this, recyclerView, new RecyclerItemClickListener
                            .OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {

                            Intent miIntent = new Intent(recyclerView.getContext(), PlayaActivity.class);
                            startActivity(miIntent);
                            arrayPlayas.setSelected(position);

                        }

                        @Override
                        public void onItemLongClick(View view, int position) {
                            //handle longClick if any

                        }
                    }));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Para poner una alerta de que no hay red.
            }
        });
        requestQueue.add(jsonObjectRequest);


    }

    ;

}
