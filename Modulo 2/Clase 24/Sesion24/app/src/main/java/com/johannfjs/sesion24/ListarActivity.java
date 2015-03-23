package com.johannfjs.sesion24;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import com.johannfjs.adapters.ListarAdapter;
import com.johannfjs.models.Empresa;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johannfjs on 23/03/15.
 */
public class ListarActivity extends ActionBarActivity {
    ListView lvListado;
    ListarAdapter adapter;
    ArrayList<Empresa> listaEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        lvListado=(ListView)findViewById(R.id.lvListado);

        listaEmpresa=new ArrayList<Empresa>();
        List<ParseObject> list;
        ParseQuery<ParseObject> lista = new ParseQuery<ParseObject>("Empresa");
        try {
            list = lista.find();
            for (ParseObject obj : list) {
                listaEmpresa.add(new Empresa(
                        obj.getObjectId(),
                        obj.getString("nombre_empresa"),
                        obj.getString("ruc"),
                        obj.getCreatedAt(), obj.getUpdatedAt()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        adapter = new ListarAdapter(getApplicationContext(), listaEmpresa);
        lvListado.setAdapter(adapter);
    }
}
