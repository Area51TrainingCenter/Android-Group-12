package johannfjs.com.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import johannfjs.com.models.Heroes;
import johannfjs.com.sesion19.R;

/**
 * Created by Johann on 06/03/2015.
 */
public class ListaAdapter extends BaseAdapter {
    Context context;
    ArrayList<Heroes> listaHeroes;

    public ListaAdapter(Context context, ArrayList<Heroes> listaHeroes) {
        this.context = context;
        this.listaHeroes = listaHeroes;
    }

    @Override
    public int getCount() {
        return listaHeroes.size();
    }

    @Override
    public Object getItem(int position) {
        return listaHeroes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listaHeroes.get(position).getId();
    }

    static class ViewHolder {
        TextView lblName, lblLevel, lblId, lblParagonLevel;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.lblId = (TextView) convertView.findViewById(R.id.lblId);
            viewHolder.lblName = (TextView) convertView.findViewById(R.id.lblName);
            viewHolder.lblLevel = (TextView) convertView.findViewById(R.id.lblLevel);
            viewHolder.lblParagonLevel = (TextView) convertView.findViewById(R.id.lblParagonLevel);
        }
        ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.lblId.setText(listaHeroes.get(position).getId() + "");
        viewHolder.lblLevel.setText(listaHeroes.get(position).getLevel() + "");
        viewHolder.lblName.setText(listaHeroes.get(position).getName());
        if (listaHeroes.get(position).isDead())
            viewHolder.lblParagonLevel.setText(listaHeroes.get(position).getParagonLevel() + "");
        else
            viewHolder.lblParagonLevel.setVisibility(View.GONE);
        return convertView;
    }
}
