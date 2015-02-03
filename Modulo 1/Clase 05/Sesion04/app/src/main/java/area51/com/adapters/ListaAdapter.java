package area51.com.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import area51.com.models.Persona;
import area51.com.sesion04.R;
import area51.com.utils.Constant;

/**
 * Created by Johann on 30/01/2015.
 */
public class ListaAdapter extends BaseAdapter {
    Context context;

    public ListaAdapter(Context context) {
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
        TextView lblNombre, lblApellidoPaterno, lblApellidoMaterno, lblEdad, lblSexo;
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
            viewHolder.lblSexo = (TextView) convertView.findViewById(R.id.lblSexo);
            convertView.setTag(viewHolder);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        /*
        Persona obj = (Persona) getItem(position);
        holder.lblNombre.setText(obj.getNombre());
        */
        holder.lblNombre.setText(Constant.LISTA_PERSONA.get(position).getNombre());
        holder.lblApellidoPaterno.setText(Constant.LISTA_PERSONA.get(position).getApellidoPaterno());
        holder.lblApellidoMaterno.setText(Constant.LISTA_PERSONA.get(position).getApellidoMaterno());
        holder.lblEdad.setText(String.valueOf(Constant.LISTA_PERSONA.get(position).getEdad()));
        holder.lblSexo.setText(Constant.LISTA_PERSONA.get(position).getSexo());
        return convertView;
    }
}
