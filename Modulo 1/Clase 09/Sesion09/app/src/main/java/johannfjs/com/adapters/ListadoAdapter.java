package johannfjs.com.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

import johannfjs.com.models.Persona;
import johannfjs.com.sesion09.R;

/**
 * Created by Johann on 11/02/2015.
 */
public class ListadoAdapter extends BaseAdapter {
    protected ImageLoader imageLoader = ImageLoader.getInstance();
    Context context;
    ArrayList<Persona> listaPersona;

    public ListadoAdapter(Context context, ArrayList<Persona> listaPersona) {
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
        TextView lblNombres, lblApellidoPaterno, lblApellidoMaterno, lblGenero;
        ImageView ivImagen;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.lblNombres = (TextView) convertView.findViewById(R.id.lblNombre);
            viewHolder.lblApellidoPaterno = (TextView) convertView.findViewById(R.id.lblApellidoPaterno);
            viewHolder.lblApellidoMaterno = (TextView) convertView.findViewById(R.id.lblApellidoMaterno);
            viewHolder.lblGenero = (TextView) convertView.findViewById(R.id.lblGenero);
            viewHolder.ivImagen = (ImageView) convertView.findViewById(R.id.ivImagen);
            convertView.setTag(viewHolder);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.lblNombres.setText(listaPersona.get(position).getNombres());
        holder.lblApellidoPaterno.setText(listaPersona.get(position).getApellidoPaterno());
        holder.lblApellidoMaterno.setText(listaPersona.get(position).getApellidoMaterno());
        holder.lblGenero.setText(listaPersona.get(position).getGenero());
        //imageLoader.displayImage(listaPersona.get(position).getURL, holder.ivImagen);
        return convertView;
    }
}

