package johannfjs.com.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

import johannfjs.com.models.Imagen;
import johannfjs.com.sesion09.R;

/**
 * Created by Johann on 13/02/2015.
 */
public class GrillaAdapter extends ArrayAdapter<Imagen> {
    protected ImageLoader imageLoader = ImageLoader.getInstance();
    Context context;
    ArrayList<Imagen> listaImagen;

    public GrillaAdapter(Context context, ArrayList<Imagen> objects) {
        super(context, R.layout.grid_item, objects);
        this.context = context;
        this.listaImagen = objects;
    }

    static class ViewHolder {
        ImageView ivImagen;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.ivImagen = (ImageView) convertView.findViewById(R.id.ivImagen);
            convertView.setTag(viewHolder);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        imageLoader.displayImage(listaImagen.get(position).getRutaImagen(), holder.ivImagen);
        return convertView;
    }
}
