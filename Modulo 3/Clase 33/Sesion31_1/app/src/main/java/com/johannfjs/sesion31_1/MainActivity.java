package com.johannfjs.sesion31_1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

import java.util.Arrays;


public class MainActivity extends ActionBarActivity {

    LoginButton btnLogin;
    CallbackManager callbackManager;
    TextView lblTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = (LoginButton) findViewById(R.id.btnLogin);
        lblTexto = (TextView) findViewById(R.id.lblTexto);
        callbackManager = CallbackManager.Factory.create();

        btnLogin.setReadPermissions(Arrays.asList("public_profile", "email", "user_likes"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnLogin.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(getApplicationContext(), "Loggeado", Toast.LENGTH_SHORT).show();
                cargarDatos();
            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), "Cancel", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException e) {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void cargarDatos() {
        GraphRequest request = GraphRequest.newMeRequest(
                AccessToken.getCurrentAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(
                            JSONObject object,
                            GraphResponse response) {
                        // Application code
                        Log.d("TAG", object.toString());
                        try {
                            if (object.length() > 0) {
                                lblTexto.setText(object.getString("name"));
                                /*
                                ParseUser parse=new Parse();
                                parse.setUsername(object.getString("email"));
                                parse.setPassword(object.getString("email")+object.getString("id"));
                                parse.setEmail(object.getString("email"));
                                parse.put("nombre",object.getString("name"));
                                parse.saveInBackground();
                                */

                                //http://graph.facebook.com/"+id+"/picture?type=large
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
        /*
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,link");
        request.setParameters(parameters);
        */
        request.executeAsync();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
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
