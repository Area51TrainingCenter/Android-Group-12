package johannfjs.com.examplelogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    EditText txtCorreo, txtContrasenia;
    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        txtContrasenia = (EditText) findViewById(R.id.txtContrasenia);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtCorreo.getText().toString().trim().equals("johannfjs@gmail.com") && txtContrasenia.getText().toString().trim().equals("12345")) {
                    Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Datos incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
