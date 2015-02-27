package johannfjs.com.sesion15;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

import johannfjs.com.adapters.ListaAdapter;
import johannfjs.com.models.Persona;
import johannfjs.com.sqlite.Querys;


public class MainActivity extends ActionBarActivity {
    EditText txtNombre, txtApellido;
    Spinner spGenero;
    Button btnRegistrar;
    ListView lvLista;
    ArrayList<Persona> listaPersona;
    ListaAdapter adapter;

    Querys querys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtApellido = (EditText) findViewById(R.id.txtApellido);
        spGenero = (Spinner) findViewById(R.id.spGenero);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        lvLista = (ListView) findViewById(R.id.lvLista);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        //int height = metrics.heightPixels;
        int width = metrics.widthPixels;

        txtNombre.setLayoutParams(new LinearLayout.LayoutParams(width / 2, ViewGroup.LayoutParams.WRAP_CONTENT));
        txtApellido.setLayoutParams(new LinearLayout.LayoutParams(width / 2, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    @Override
    protected void onResume() {
        super.onResume();
        querys = new Querys(MainActivity.this);

        listaPersona = new ArrayList<Persona>();
        listaPersona = querys.listarTodos();
        adapter = new ListaAdapter(getApplicationContext(), listaPersona);
        lvLista.setAdapter(adapter);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtNombre.getText().toString().trim().equals("") &&
                        !txtApellido.getText().toString().trim().equals("")) {
                    querys.insertarPersona(txtNombre.getText().toString(),
                            txtApellido.getText().toString(),
                            spGenero.getSelectedItem().toString());
                    listaPersona = querys.listarTodos();
                    adapter = new ListaAdapter(getApplicationContext(), listaPersona);
                    lvLista.setAdapter(adapter);
                    limpiarCampos();
                }
            }
        });
        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                dialogo.setTitle("Opciones").setItems(R.array.opciones, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                txtNombre.setText(listaPersona.get(position).getNombre());
                                txtApellido.setText(listaPersona.get(position).getApellido());
                                break;
                            case 1:
                                querys.eliminarPersona(listaPersona.get(position).getId());
                                listaPersona = querys.listarTodos();
                                adapter = new ListaAdapter(getApplicationContext(), listaPersona);
                                lvLista.setAdapter(adapter);
                                break;
                        }
                    }
                });
            }
        });
    }

    public void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        spGenero.setSelection(0);
        txtNombre.requestFocus();
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
