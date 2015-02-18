package johannfjs.com.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import johannfjs.com.fragment.DetalleFragment;
import johannfjs.com.utils.Constant;

/**
 * Created by Johann on 18/02/2015.
 */
public class ImagenAdapter extends FragmentStatePagerAdapter {
    public ImagenAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        DetalleFragment fragment = new DetalleFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("KEY", position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return Constant.LISTA_IMAGENES.size();
    }
}
