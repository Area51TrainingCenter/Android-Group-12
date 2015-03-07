package johannfjs.com.sesion19;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.ArrayList;

import johannfjs.com.adapters.ListaAdapter;
import johannfjs.com.application.ConfigureApplication;
import johannfjs.com.models.Battle;
import johannfjs.com.models.Heroes;
import johannfjs.com.utils.Constant;


public class MainActivity extends ActionBarActivity {
    ArrayList<Battle> listaBattle;
    ListaAdapter adapter;
    TextView lblBattleTag;
    ListView lvLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvLista = (ListView) findViewById(R.id.lvLista);
        lblBattleTag = (TextView) findViewById(R.id.lblBattleTag);
    }

    @Override
    protected void onResume() {
        super.onResume();
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Cargando!!");
        progressDialog.setCancelable(false);
        progressDialog.show();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                Constant.URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Battle battle = new Battle();
                            battle.setBattleTag(response.getString("battleTag"));

                            ArrayList<Heroes> listaHeroes = new ArrayList<Heroes>();
                            for (int i = 0; i < response.getJSONArray("heroes").length(); i++) {
                                JSONObject jsonObject = response.getJSONArray("heroes").getJSONObject(i);
                                listaHeroes.add(new Heroes(
                                        jsonObject.getInt("paragonLevel"),
                                        jsonObject.getBoolean("seasonal"),
                                        jsonObject.getString("name"),
                                        jsonObject.getInt("id"),
                                        jsonObject.getInt("level"),
                                        jsonObject.getBoolean("hardcore"),
                                        jsonObject.getInt("gender"),
                                        jsonObject.getBoolean("dead"),
                                        jsonObject.getString("class"),
                                        jsonObject.getString("last-updated")
                                ));
                            }
                            battle.setHeroes(listaHeroes);
                            listaBattle.add(battle);
                            adapter = new ListaAdapter(getApplicationContext(), listaHeroes);
                            lvLista.setAdapter(adapter);
                            progressDialog.dismiss();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
            }
        });
        ConfigureApplication.getInstance().addToRequestQueue(jsonObjectRequest);
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
