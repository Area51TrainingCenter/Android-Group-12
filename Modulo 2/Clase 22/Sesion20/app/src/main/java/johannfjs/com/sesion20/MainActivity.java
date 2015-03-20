package johannfjs.com.sesion20;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import johannfjs.com.application.ConfigureApplication;
import johannfjs.com.sqlite.Querys;
import johannfjs.com.utils.InitViews;


public class MainActivity extends ActionBarActivity {
    public View root;
    EditText txtCorreo;
    EditText txtContrasenia;
    Button btnIngresar;

    Querys querys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        root = findViewById(android.R.id.content).getRootView();
        InitViews.whichClass(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        querys = new Querys(MainActivity.this);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtCorreo.getText().toString().equals("") &&
                        !txtContrasenia.getText().toString().equals("")) {
                    final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                    progressDialog.setMessage("Cargando!");
                    progressDialog.setCancelable(false);
                    progressDialog.show();
                    JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                            "http://johannfjs.com/android/ws/validarUsuario.php?correo=" + txtCorreo.getText().toString() + "&contrasenia=" + txtContrasenia.getText().toString(),
                            new Response.Listener<JSONArray>() {
                                @Override
                                public void onResponse(JSONArray response) {
                                    try {
                                        if (response.length() > 0) {
                                            JSONObject jsonObject = response.getJSONObject(0);
                                            querys.registrarPersona(jsonObject.getString("nombres") + " " + jsonObject.getString("apellidoPaterno") + " " + jsonObject.getString("apellidoMaterno"));
                                            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                                            startActivity(intent);
                                        } else {
                                            Toast.makeText(getApplicationContext(), "Usuario invalido", Toast.LENGTH_SHORT).show();
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    progressDialog.dismiss();
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    progressDialog.dismiss();
                                }
                            }
                    );
                    ConfigureApplication.getInstance().addToRequestQueue(jsonArrayRequest);
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
