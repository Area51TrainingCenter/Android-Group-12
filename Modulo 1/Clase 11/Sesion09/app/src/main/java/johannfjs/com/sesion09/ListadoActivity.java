package johannfjs.com.sesion09;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import johannfjs.com.adapters.ListadoAdapter;
import johannfjs.com.utils.Constant;

/**
 * Created by Johann on 11/02/2015.
 */
public class ListadoActivity extends ActionBarActivity {
    ListadoAdapter adapter;
    ListView lvListado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        lvListado = (ListView) findViewById(R.id.lvListado);

        adapter = new ListadoAdapter(getApplicationContext(), Constant.LISTA_PERSONA);
        lvListado.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        lvListado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder dialogo = new AlertDialog.Builder(ListadoActivity.this);
                dialogo.setTitle("Opciones").setItems(R.array.opciones, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                Intent intent = new Intent(ListadoActivity.this, RegistroActivity.class);
                                intent.putExtra("KEY", (Constant.LISTA_PERSONA.get(position).getId() + 1));
                                startActivity(intent);
                                break;
                            case 1:
                                Constant.LISTA_PERSONA.remove(position);
                                adapter.notifyDataSetChanged();
                                if (Constant.LISTA_PERSONA.size() == 0) {
                                    Intent intent1 = new Intent(ListadoActivity.this, RegistroActivity.class);
                                    startActivity(intent1);
                                }
                                break;
                        }
                    }
                }).show();
            }
        });
    }
}
