package johannfjs.com.sesion07;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;

import johannfjs.com.adapters.GrillaAdapter;
import johannfjs.com.models.Image;


public class MainActivity extends ActionBarActivity {
    GrillaAdapter adapter;
    ArrayList<Image> listaImagen;
    GridView gvGrilla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gvGrilla = (GridView) findViewById(R.id.gvGrilla);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (listaImagen == null)
            listaImagen = new ArrayList<Image>();
        for (int i = 100; i < 200; i++) {
            listaImagen.add(new Image(listaImagen.size(),
                    "http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_"+i+".jpg"));
        }
        adapter = new GrillaAdapter(getApplicationContext(), R.layout.grid_item, listaImagen);
        gvGrilla.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
