package es.uniovi.imovil.angel.playastur;

import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Angel on 28/06/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    //Clase necesaria a la hora de obtener y mostrar datos del JSON

    public LayoutInflater inflater = null;
    Playas playas;

    public final class ViewHolder extends RecyclerView.ViewHolder {

        TextView Name;
        TextView direccion;

        public ViewHolder(View itemView) {
            super(itemView);

            Name = (TextView) itemView.findViewById(R.id.nameTextView);
            direccion = (TextView) itemView.findViewById(R.id.direccionTextView);
        }
    }

    public RecyclerViewAdapter(Context context, Playas playas) {

        if (context == null || playas == null) {
            throw new IllegalArgumentException();
        }

        this.playas = playas;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = inflater.inflate(R.layout.list_item_playa, parent, false);
        return new ViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.Name.setText(playas.directorio.get(position).getNombre());
        String categorias = "";
       /* if(playas.directorio.get(position).getCategorias() != null) {
            for (int i = 0; i < playas.directorio.get(position).getCategorias().length; i++) {
                categorias += playas.directorio.get(position).getCategorias()[i].categoria + " ";
            }
        }*/
        holder.direccion.setText(categorias);
    }

    @Override
    public int getItemCount() {
        return playas.directorio.size();
    }

}
