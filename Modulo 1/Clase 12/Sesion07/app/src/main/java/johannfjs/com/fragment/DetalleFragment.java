package johannfjs.com.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import johannfjs.com.sesion07.R;
import johannfjs.com.utils.Constant;

/**
 * Created by Johann on 18/02/2015.
 */
public class DetalleFragment extends Fragment {
    protected ImageLoader imageLoader = ImageLoader.getInstance();
    ImageView ivImagenDetalle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.from(getActivity()).inflate(R.layout.fragment_detalle, container, false);
        ivImagenDetalle = (ImageView) rootView.findViewById(R.id.ivImagenDetalle);
        Bundle bundle = getArguments();
        int id_imagen = bundle.getInt("KEY");
        imageLoader.displayImage(Constant.LISTA_IMAGENES.get(id_imagen).getRutaImagen(), ivImagenDetalle);
        return rootView;
    }
}
