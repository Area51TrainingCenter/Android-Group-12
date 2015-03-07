package johannfjs.com.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import johannfjs.com.models.Persona;
import johannfjs.com.sesion17.R;

/**
 * Created by Johann on 04/03/2015.
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
        TextView lblNombre, lblApellidoPaterno, lblApellidoMaterno, lblGenero, lblCorreo;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.lblNombre = (TextView) convertView.findViewById(R.id.lblNombre);
            viewHolder.lblApellidoPaterno = (TextView) convertView.findViewById(R.id.lblApellidoPaterno);
            viewHolder.lblApellidoMaterno = (TextView) convertView.findViewById(R.id.lblApellidoMaterno);
            viewHolder.lblGenero = (TextView) convertView.findViewById(R.id.lblGenero);
            viewHolder.lblCorreo = (TextView) convertView.findViewById(R.id.lblCorreo);
            convertView.setTag(viewHolder);
        }
        ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.lblNombre.setText(listaPersona.get(position).getNombres());
        viewHolder.lblApellidoPaterno.setText(listaPersona.get(position).getApellidoPaterno());
        viewHolder.lblApellidoMaterno.setText(listaPersona.get(position).getApellidoMaterno());
        viewHolder.lblGenero.setText(listaPersona.get(position).getGenero());
        viewHolder.lblCorreo.setText(listaPersona.get(position).getCorreo());
        return convertView;
    }
}