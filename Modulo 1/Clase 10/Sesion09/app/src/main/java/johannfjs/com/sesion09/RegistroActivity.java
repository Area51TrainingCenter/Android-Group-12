package johannfjs.com.sesion09;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import johannfjs.com.adapters.GrillaAdapter;
import johannfjs.com.models.Imagen;
import johannfjs.com.models.Persona;
import johannfjs.com.utils.Constant;

/**
 * Created by Johann on 11/02/2015.
 */
public class RegistroActivity extends ActionBarActivity {
    EditText txtNombres, txtApellidoPaterno, txtApellidoMaterno;
    Spinner spGenero;
    Button btnRegistrar, btnListar;
    GrillaAdapter adapter;
    ArrayList<Imagen> listaImagen;
    GridView gvGrilla;
    String rutaImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        txtNombres = (EditText) findViewById(R.id.txtNombre);
        txtApellidoPaterno = (EditText) findViewById(R.id.txtApellidoPaterno);
        txtApellidoMaterno = (EditText) findViewById(R.id.txtApellidoMaterno);
        spGenero = (Spinner) findViewById(R.id.spGenero);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        btnListar = (Button) findViewById(R.id.btnListar);
        gvGrilla = (GridView) findViewById(R.id.gvGrilla);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (listaImagen == null) {
            listaImagen = new ArrayList<Imagen>();
            for (int i = 10; i < 30; i++) {
                listaImagen.add(
                        new Imagen(listaImagen.size(), "http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_0" + i + ".jpg"));
            }
        }
        adapter = new GrillaAdapter(getApplicationContext(), listaImagen);
        gvGrilla.setAdapter(adapter);

        if (Constant.LISTA_PERSONA == null)
            Constant.LISTA_PERSONA = new ArrayList<Persona>();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtNombres.getText().toString().trim().equals("")
                        && !txtApellidoPaterno.getText().toString().trim().equals("")
                        && !txtApellidoMaterno.getText().toString().trim().equals("")) {
                    Constant.LISTA_PERSONA.add(
                            new Persona(Constant.LISTA_PERSONA.size(),
                                    txtNombres.getText().toString(),
                                    txtApellidoPaterno.getText().toString(),
                                    txtApellidoMaterno.getText().toString(),
                                    spGenero.getSelectedItem().toString(),
                                    rutaImagen));
                    txtNombres.setText("");
                    txtApellidoPaterno.setText("");
                    txtApellidoMaterno.setText("");
                    spGenero.setSelection(0);
                    txtNombres.requestFocus();
                } else
                    Toast.makeText(getApplicationContext(), "Ingrese todos los campos", Toast.LENGTH_SHORT).show();
            }
        });
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistroActivity.this, ListadoActivity.class);
                startActivity(intent);
            }
        });
        gvGrilla.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                rutaImagen = listaImagen.get(position).getRutaImagen();
            }
        });
    }
}
