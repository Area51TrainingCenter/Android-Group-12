package johannfjs.com.sesion13;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import johannfjs.com.sqlite.ManageOpenHelper;
import johannfjs.com.utils.Constant;


public class MainActivity extends ActionBarActivity {
    EditText txtNombre;
    EditText txtApellidoPaterno;
    EditText txtApellidoMaterno;
    Button btnRegistrar;

    ManageOpenHelper dbConexion;
    SQLiteDatabase dbProcesos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtApellidoPaterno = (EditText) findViewById(R.id.txtApellidoPaterno);
        txtApellidoMaterno = (EditText) findViewById(R.id.txtApellidoMaterno);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        dbConexion = new ManageOpenHelper(MainActivity.this);
        dbProcesos = dbConexion.getWritableDatabase();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtNombre.getText().toString().trim().equals("") &&
                        !txtApellidoPaterno.getText().toString().trim().equals("") &&
                        !txtApellidoMaterno.getText().toString().trim().equals("")) {
                    //INSERT INTO _tb_persona (nombre,apellidoPaterno,apellidoMaterno)
                    //VALUES ('txtNombre','txtApellidoPaterno','txtApellidoMaterno')
                    String sql = "INSERT INTO " + Constant.TB_PERSONA + "(" +
                            Constant.C_NOMBRE + "," +
                            Constant.C_APELLIDO_PATERNO + "," +
                            Constant.C_APELLIDO_MATERNO + ") VALUES('" +
                            txtNombre.getText().toString() + "','" +
                            txtApellidoPaterno.getText().toString() + "','" +
                            txtApellidoMaterno.getText().toString() + "')";
                    dbProcesos.execSQL(sql);
                    Log.d("TAG", sql);
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
