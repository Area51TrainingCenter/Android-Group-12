package johannfjs.com.sesion17;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import johannfjs.com.adapters.ListaAdapter;
import johannfjs.com.asyntask.ManageAsynTask;
import johannfjs.com.models.Persona;


public class MainActivity extends ActionBarActivity {
    Button btnTraer;
    TextView lblTexto;
    ListView lvLista;
    ArrayList<Persona> listaPersona;
    ListaAdapter adapter;

    ManageAsynTask manage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTraer = (Button) findViewById(R.id.btnTraer);
        lblTexto = (TextView) findViewById(R.id.lblTexto);
        lvLista = (ListView) findViewById(R.id.lvLista);
    }

    @Override
    protected void onResume() {
        super.onResume();

        listaPersona = new ArrayList<Persona>();

        manage = new ManageAsynTask(MainActivity.this);
        btnTraer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manage.listar("http://johannfjs.com/android/ws/index.php");
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

    public void resultadoListarTodo(String s) {
        //lblTexto.setText(s);
        try {
            JSONArray jsonArray = new JSONArray(s);
            if (jsonArray.length() > 0) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    listaPersona.add(new Persona(jsonObject.getInt("id"),
                            jsonObject.getString("nombres"),
                            jsonObject.getString("apellidoPaterno"),
                            jsonObject.getString("apellidoMaterno"),
                            jsonObject.getString("genero"),
                            jsonObject.getString("correo"),
                            jsonObject.getString("contrasenia")));
                    /*
                    Log.d("TAG", "nombre->" + jsonObject.getString("nombres"));
                    Log.d("TAG", "apellido paterno->" + jsonObject.getString("apellidoPaterno"));
                    Log.d("TAG", "apellido materno->" + jsonObject.getString("apellidoMaterno"));
                    Log.d("TAG", "genero->" + jsonObject.getString("genero"));
                    */
                }
                adapter = new ListaAdapter(getApplicationContext(), listaPersona);
                lvLista.setAdapter(adapter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
