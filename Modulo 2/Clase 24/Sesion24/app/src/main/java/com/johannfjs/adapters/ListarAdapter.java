package com.johannfjs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.johannfjs.models.Empresa;
import com.johannfjs.sesion24.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by johannfjs on 23/03/15.
 */
public class ListarAdapter extends BaseAdapter {
    Context context;
    ArrayList<Empresa> listaEmpresa;

    public ListarAdapter(Context context, ArrayList<Empresa> listaEmpresa) {
        this.context = context;
        this.listaEmpresa = listaEmpresa;
    }

    @Override
    public int getCount() {
        return listaEmpresa.size();
    }

    @Override
    public Object getItem(int position) {
        return listaEmpresa.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder{
        TextView lblEmpresa,lblRuc;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_list,parent,false);
            ViewHolder viewHolder=new ViewHolder();
            viewHolder.lblEmpresa=(TextView)convertView.findViewById(R.id.lblRazonSocial);
            viewHolder.lblRuc=(TextView)convertView.findViewById(R.id.lblRuc);
            convertView.setTag(viewHolder);
        }
        ViewHolder viewHolder=(ViewHolder)convertView.getTag();
        viewHolder.lblEmpresa.setText(listaEmpresa.get(position).getNombreEmpresa());
        viewHolder.lblEmpresa.setTextSize(20f);
        viewHolder.lblRuc.setText(listaEmpresa.get(position).getRuc());
        return convertView;
    }
}
