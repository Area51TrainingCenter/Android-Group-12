package johannfjs.com.sesion09;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import johannfjs.com.adapters.ListadoAdapter;
import johannfjs.com.utils.Constant;

/**
 * Created by Johann on 11/02/2015.
 */
public class ListadoActivity extends ActionBarActivity {
    ListadoAdapter adapter;
    ListView lvListado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        lvListado = (ListView) findViewById(R.id.lvListado);

        adapter = new ListadoAdapter(getApplicationContext(), Constant.LISTA_PERSONA);
        lvListado.setAdapter(adapter);
    }
}
