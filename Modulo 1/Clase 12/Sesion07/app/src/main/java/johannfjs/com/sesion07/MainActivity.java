package johannfjs.com.sesion07;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import johannfjs.com.adapters.GrillaAdapter;
import johannfjs.com.models.Image;
import johannfjs.com.utils.Constant;


public class MainActivity extends ActionBarActivity {
    GrillaAdapter adapter;
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
        if (Constant.LISTA_IMAGENES == null)
            Constant.LISTA_IMAGENES = new ArrayList<Image>();
        for (int i = 100; i < 200; i++) {
            Constant.LISTA_IMAGENES.add(new Image(Constant.LISTA_IMAGENES.size(),
                    "http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_" + i + ".jpg"));
        }
        adapter = new GrillaAdapter(getApplicationContext(), R.layout.grid_item, Constant.LISTA_IMAGENES);
        gvGrilla.setAdapter(adapter);

        gvGrilla.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ImagenActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("KEY", position);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
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
