package es.uniovi.imovil.angel.playastur;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by Angel on 30/06/2017.
 */

public class PlayasListFragmentFiltrar extends Fragment implements AdapterView.OnItemClickListener {
//Esta es la segunda clase necesaria para poder realizar filtrado en las busquedas

    public interface Callbacks {
        public void onpSelected(Playa pl);
    }

    private PlayaAdapter mAdapter = null;
    private Callbacks mCallback = null;
    Toolbar toolbar;

    public static PlayasListFragmentFiltrar newInstance() {

        PlayasListFragmentFiltrar fragment = new PlayasListFragmentFiltrar();
        return fragment;
    }

    public PlayasListFragmentFiltrar() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.activity_main, container, false);

        ListView lvItems = (ListView) rootView.findViewById(R.id.recycler_view);
        // con MainAtivity.pedirJSON no sirve, hay que obtener los datos de otra manera
        //seria necesario un metodo que pudiera retornar un ArrayList<Playa>
        //mAdapter = new PlayaAdapter(getActivity(), MainActivity.pedirJSON());
        lvItems.setAdapter(mAdapter);
        lvItems.setOnItemClickListener(this);
        toolbar = (Toolbar) rootView.findViewById(R.id.navigation);
        toolbar.setTitle("Lista de playas");
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
        return rootView;

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Esto permite inflar el menu y anyadir acciones al action bar, si existe
        inflater.inflate(R.menu.navigation, menu);
        android.support.v7.widget.SearchView busqueda = (android.support.v7.widget.SearchView) menu.findItem(R.id.action_search).getActionView();

        busqueda.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            /*case R.id.action_map:
                action(R.string.action_map);
                Intent intentMapa = new Intent(getContext(), MapaActivity.class);
                startActivity(intentMapa);
                return true;*/
            case R.id.action_search:
                action(R.string.action_search);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void action(int resid) {
        Toast.makeText(getContext(), getText(resid), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Playa pla = (Playa) parent.getItemAtPosition(position);
        mCallback.onpSelected(pla);
    }


}
