package com.johannfjs.sesion24;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseObject;


public class MainActivity extends ActionBarActivity {
    EditText txtRazonComercial, txtRuc;
    Button btnGrabar, btnListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtRazonComercial = (EditText) findViewById(R.id.txtRazonComercial);
        txtRuc = (EditText) findViewById(R.id.txtRuc);
        btnGrabar = (Button) findViewById(R.id.btnGrabar);
        btnListar = (Button) findViewById(R.id.btnListar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtRazonComercial.getText().toString().equals("") && !txtRuc.getText().toString().equals("")) {
                    ParseObject parseObject = new ParseObject("Empresa");
                    parseObject.put("nombre_empresa", txtRazonComercial.getText().toString());
                    parseObject.put("ruc", txtRuc.getText().toString());
                    parseObject.saveInBackground();
                }
            }
        });
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, ListarActivity.class);
                Bundle bundle =new Bundle();
                bundle.putString("hola","Holaaaaaaa");
                intent.putExtras(bundle);
                startActivity(intent);
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
