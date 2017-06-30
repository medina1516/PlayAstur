package es.uniovi.imovil.angel.playastur;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Angel on 30/06/2017.
 */

public class PlayaAdapter extends BaseAdapter implements Filterable {
    //Esta clase es necesaria para poder buscar playas determindadas a partir del listado que contiene a todas

    ArrayList<Playa> mDirectorio;
    ArrayList<Playa> mStringFilterList;
    ValueFilter valueFilter = new ValueFilter();
    public LayoutInflater mInflater;

    static class ViewHolder {
        public TextView nombrePlaya;
        public View mRootView;
    }

    public PlayaAdapter(Context context, ArrayList<Playa> directorio) {

        if (context == null || directorio == null) {
            throw new IllegalArgumentException();
        }
        this.mStringFilterList = new ArrayList<>();
        this.mDirectorio = new ArrayList<>(directorio.size());
        for (int i = 0; i < directorio.size(); i++) {
            mDirectorio.add(directorio.get(i));
            mStringFilterList.add(directorio.get(i));
        }
        this.mDirectorio = directorio;
        this.mStringFilterList = directorio;

        this.mInflater = LayoutInflater.from(context);

    }


    @Override
    public int getCount() {
        return mStringFilterList.size();
    }

    @Override
    public Object getItem(int position) {
        return mStringFilterList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;
        ViewHolder viewHolder;

        if (rowView == null) {
            rowView = mInflater.inflate(R.layout.list_item_playa, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.nombrePlaya = (TextView) rowView.findViewById(R.id.nameTextView);
            rowView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) rowView.getTag();
        }

        Playa pl = (Playa) getItem(position);
        viewHolder.nombrePlaya.setText(pl.getNombre() + "");
        return rowView;
    }

    public void addPlaya(Playa pl) {
        if (pl == null) {
            throw new IllegalArgumentException();
        }
        mDirectorio.add(pl);
        notifyDataSetChanged();
    }

    public Filter getFilter() {
        if (valueFilter == null) {
            valueFilter = new ValueFilter();
        }
        return valueFilter;
    }


    private class ValueFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if (constraint != null && constraint.length() > 0) {
                List filterList = new ArrayList();
                for (int i = 0; i < mDirectorio.size(); i++) {
                    if ((mDirectorio.get(i).getNombre().toUpperCase()).contains(constraint.toString().toUpperCase())) {
                        filterList.add(mDirectorio.get(i));
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = mStringFilterList.size();
                results.values = mStringFilterList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mStringFilterList = (ArrayList) results.values;
            notifyDataSetChanged();
        }

    }


}
