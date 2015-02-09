package johannfjs.com.examplelogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import johannfjs.com.models.Persona;
import johannfjs.com.utils.Constant;

/**
 * Created by Johann on 09/02/2015.
 */
public class RegistroActivity extends ActionBarActivity {
    EditText txtNombre, txtApellidoPaterno, txtApellidoMaterno;
    Spinner spGenero;
    Button btnRegistrar, btnListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtApellidoPaterno = (EditText) findViewById(R.id.txtApellidoPaterno);
        txtApellidoMaterno = (EditText) findViewById(R.id.txtApellidoMaterno);
        spGenero = (Spinner) findViewById(R.id.spGenero);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        btnListar = (Button) findViewById(R.id.btnListar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Constant.LISTA_PERSONA == null)
            Constant.LISTA_PERSONA = new ArrayList<Persona>();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtNombre.getText().toString().trim().equals("") && !txtApellidoPaterno.getText().toString().trim().equals("") && !txtApellidoMaterno.getText().toString().trim().equals("")) {
                    Constant.LISTA_PERSONA.add(new Persona(Constant.LISTA_PERSONA.size(), txtNombre.getText().toString(), txtApellidoPaterno.getText().toString(), txtApellidoMaterno.getText().toString(), spGenero.getSelectedItem().toString()));
                    Toast.makeText(getApplicationContext(), "Registro exitoso", Toast.LENGTH_SHORT).show();
                    txtNombre.setText("");
                    txtApellidoPaterno.setText("");
                    txtApellidoMaterno.setText("");
                    spGenero.setSelection(0);
                    txtNombre.requestFocus();
                } else {
                    Toast.makeText(getApplicationContext(), "Complete todos los datos", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistroActivity.this, ListadoActivity.class);
                startActivity(intent);
            }
        });
    }
}
