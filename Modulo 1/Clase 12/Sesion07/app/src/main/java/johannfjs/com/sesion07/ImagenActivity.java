package johannfjs.com.sesion07;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import johannfjs.com.adapters.ImagenAdapter;

/**
 * Created by Johann on 18/02/2015.
 */
public class ImagenActivity extends FragmentActivity {
    ViewPager viewPager;
    ImagenAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Bundle bundle = getIntent().getExtras();
        int id_imagen = bundle.getInt("KEY");
        adapter = new ImagenAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(id_imagen);
    }
}
