package area51.com.sesion04;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import area51.com.adapters.ListaAdapter;
import area51.com.models.Persona;
import area51.com.utils.Constant;


public class MainActivity extends ActionBarActivity {
    ListaAdapter adapter;
    ListView lvLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvLista = (ListView) findViewById(R.id.lvLista);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Constant.LISTA_PERSONA == null)
            Constant.LISTA_PERSONA = new ArrayList<Persona>();

        Constant.LISTA_PERSONA.add(new Persona(1, "Nombre", "ApellidoPaterno", "ApellidoMaterno", 30, "Masculino"));

        adapter = new ListaAdapter(getApplicationContext());
        lvLista.setAdapter(adapter);
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
