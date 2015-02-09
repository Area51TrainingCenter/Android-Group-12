package johannfjs.com.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import johannfjs.com.examplelogin.R;
import johannfjs.com.utils.Constant;

/**
 * Created by Johann on 09/02/2015.
 */
public class ListadoAdapter extends BaseAdapter {
    Context context;

    public ListadoAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Constant.LISTA_PERSONA.size();
    }

    @Override
    public Object getItem(int position) {
        return Constant.LISTA_PERSONA.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Constant.LISTA_PERSONA.get(position).getId();
    }

    static class ViewHolder {
        ImageView ivImagen;
        TextView lblNombre, lblApellidoPaterno, lblApellidoMaterno, lblGenero;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.ivImagen = (ImageView) convertView.findViewById(R.id.ivImagen);
            viewHolder.lblNombre = (TextView) convertView.findViewById(R.id.lblNombre);
            viewHolder.lblApellidoPaterno = (TextView) convertView.findViewById(R.id.lblApellidoPaterno);
            viewHolder.lblApellidoMaterno = (TextView) convertView.findViewById(R.id.lblApellidoMaterno);
            viewHolder.lblGenero = (TextView) convertView.findViewById(R.id.lblGenero);
            convertView.setTag(viewHolder);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.lblNombre.setText(Constant.LISTA_PERSONA.get(position).getNombre());
        holder.lblApellidoPaterno.setText(Constant.LISTA_PERSONA.get(position).getApellidoPaterno());
        holder.lblApellidoMaterno.setText(Constant.LISTA_PERSONA.get(position).getApellidoMaterno());
        holder.lblGenero.setText(Constant.LISTA_PERSONA.get(position).getGenero());
        return convertView;
    }
}
