package johannfjs.com.examplelogin;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import johannfjs.com.adapters.ListadoAdapter;

/**
 * Created by Johann on 09/02/2015.
 */
public class ListadoActivity extends ActionBarActivity {
    ListadoAdapter adapter;
    ListView lvListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        lvListar = (ListView) findViewById(R.id.lvListar);
        adapter = new ListadoAdapter(getApplicationContext());
        lvListar.setAdapter(adapter);
    }
}
