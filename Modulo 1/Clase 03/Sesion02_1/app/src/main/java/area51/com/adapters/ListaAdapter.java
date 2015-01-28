package area51.com.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import area51.com.models.Persona;
import area51.com.sesion02_1.R;

/**
 * Created by Johann on 28/01/2015.
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
        TextView lblNombre, lblApellidoPaterno, lblApellidoMaterno, lblEdad;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.lblNombre = (TextView) convertView.findViewById(R.id.lblNombre);
            viewHolder.lblApellidoPaterno = (TextView) convertView.findViewById(R.id.lblApellidoPaterno);
            viewHolder.lblApellidoMaterno = (TextView) convertView.findViewById(R.id.lblApellidoMaterno);
            viewHolder.lblEdad = (TextView) convertView.findViewById(R.id.lblEdad);
            convertView.setTag(viewHolder);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.lblNombre.setText(listaPersona.get(position).getNombre());
        holder.lblApellidoPaterno.setText(listaPersona.get(position).getApellidoPaterno());
        holder.lblApellidoMaterno.setText(listaPersona.get(position).getApellidoMaterno());
        holder.lblEdad.setText(String.valueOf(listaPersona.get(position).getEdad()));
        return convertView;
    }
}
