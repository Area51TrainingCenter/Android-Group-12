package com.johannfjs.sesion31;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    EditText txtUsuario, txtClave;
    Button btnIngresar, btnLogin, btnParseFacebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtClave = (EditText) findViewById(R.id.txtClave);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnParseFacebook = (Button) findViewById(R.id.btnParseFacebook);
    }


    private void getData() {
        /*
        Request.executeMeRequestAsync(ParseFacebookUtils.getSession(), new Request.GraphUserCallback() {

            @Override
            public void onCompleted(GraphUser user, Response response) {
                if (user != null) {
                    // Display the parsed user info

                    String email = (String) response.getGraphObject().getProperty("email");

                }
            }
        });
        */
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnParseFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseFacebookUtils.initialize(getResources().getString(R.string.FACEBOOK_ID));
                List<String> permisos = Arrays.asList("public_profile", "email");
                ParseFacebookUtils.logIn(permisos, MainActivity.this, new LogInCallback() {
                    @Override
                    public void done(ParseUser parseUser, ParseException e) {
                        if (parseUser == null) {
                            Toast.makeText(getApplication(), "Nuevo", Toast.LENGTH_SHORT).show();
                            getData();
                        } else if (parseUser.isNew()) {
                            Toast.makeText(getApplication(), "Existe", Toast.LENGTH_SHORT).show();
                            getData();
                        } else {
                            Toast.makeText(getApplication(), "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtUsuario.getText().toString().equals("") && !txtClave.getText().toString().equals("")) {
                    ParseUser parseUser = new ParseUser();
                    parseUser.setUsername(txtUsuario.getText().toString());
                    parseUser.setPassword(txtClave.getText().toString());
                    parseUser.setEmail(txtUsuario.getText().toString() + "@test.com");
                    parseUser.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                //Todo OK

                            } else {
                                Toast.makeText(getApplicationContext(), "Error al registrarse " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext(), "Ingrese todos los datos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logInInBackground(txtUsuario.getText().toString(), txtClave.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser parseUser, ParseException e) {
                        if (parseUser != null) {
//TODO Ok
                            Intent intent = new Intent(MainActivity.this, DosActivity.class);
                            startActivity(intent);
                            //startActivity(new Intent(MainActivity.this,DosActivity.class));
                        } else {
//Registrar
                        }
                    }
                });
            }
        });

        ParseUser parseUser = ParseUser.getCurrentUser();
        if (parseUser != null)
            parseUser.logOut();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ParseFacebookUtils.finishAuthentication(requestCode, resultCode, data);
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
