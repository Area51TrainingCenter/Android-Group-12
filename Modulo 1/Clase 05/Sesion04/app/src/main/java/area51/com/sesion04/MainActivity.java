package area51.com.sesion04;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import area51.com.adapters.ListaAdapter;
import area51.com.models.Persona;
import area51.com.utils.Constant;


public class MainActivity extends ActionBarActivity {
    ListaAdapter adapter;
    ListView lvLista;
    EditText txtNombre;
    EditText txtApellidoPaterno;
    EditText txtApellidoMaterno;
    EditText txtEdad;
    Spinner spSexo;
    Button btnGrabar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvLista = (ListView) findViewById(R.id.lvLista);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtApellidoPaterno = (EditText) findViewById(R.id.txtApellidoPaterno);
        txtApellidoMaterno = (EditText) findViewById(R.id.txtApellidoMaterno);
        txtEdad = (EditText) findViewById(R.id.txtEdad);
        spSexo = (Spinner) findViewById(R.id.spSexo);
        btnGrabar = (Button) findViewById(R.id.btnGrabar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Constant.LISTA_PERSONA == null)
            Constant.LISTA_PERSONA = new ArrayList<Persona>();

        //Constant.LISTA_PERSONA.add(new Persona(1, "Nombre", "ApellidoPaterno", "ApellidoMaterno", 30, "Masculino"));

        adapter = new ListaAdapter(getApplicationContext());
        lvLista.setAdapter(adapter);

        btnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtNombre.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Campo nombre requerido", Toast.LENGTH_SHORT).show();
                    txtNombre.setError("Campo requerdio");
                } else if (txtApellidoPaterno.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Campo nombre requerido", Toast.LENGTH_SHORT).show();
                    txtApellidoPaterno.setError("Campo requerdio");
                } else {
                    Constant.LISTA_PERSONA.add(new Persona(
                            Constant.LISTA_PERSONA.size(),
                            txtNombre.getText().toString(),
                            txtApellidoPaterno.getText().toString(),
                            txtApellidoMaterno.getText().toString(),
                            Integer.parseInt(txtEdad.getText().toString()),
                            spSexo.getSelectedItem().toString()));
                    adapter.notifyDataSetChanged();
                }
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
