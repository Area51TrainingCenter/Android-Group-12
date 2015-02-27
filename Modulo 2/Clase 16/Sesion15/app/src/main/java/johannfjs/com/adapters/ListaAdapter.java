package johannfjs.com.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import johannfjs.com.models.Persona;
import johannfjs.com.sesion15.R;

/**
 * Created by Johann on 27/02/2015.
 */
public class ListaAdapter extends BaseAdapter {
    Context context;
    ArrayList<Persona> listaPersona;

    public ListaAdapter(Context context, ArrayList<Persona> listaPersona) {
        this.context = context;
        this.listaPersona = listaPersona;
    }

    @Override
    public int getCount() {
        return listaPersona.size();
    }

    @Override
    public Object getItem(int position) {
        return listaPersona.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listaPersona.get(position).getId();
    }

    static class ViewHolder {
        TextView lblNombre, lblApellido, lblGenero;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.itel_list, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.lblNombre = (TextView) convertView.findViewById(R.id.lblNombre);
            viewHolder.lblApellido = (TextView) convertView.findViewById(R.id.lblApellido);
            viewHolder.lblGenero = (TextView) convertView.findViewById(R.id.lblGenero);
            convertView.setTag(viewHolder);
        }
        ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.lblNombre.setText(listaPersona.get(position).getNombre());
        viewHolder.lblApellido.setText(listaPersona.get(position).getApellido());
        viewHolder.lblGenero.setText(listaPersona.get(position).getGenero());
        return convertView;
    }
}
