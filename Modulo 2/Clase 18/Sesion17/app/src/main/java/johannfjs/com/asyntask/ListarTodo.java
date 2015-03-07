package johannfjs.com.asyntask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import johannfjs.com.libs.RESTClient;
import johannfjs.com.sesion17.MainActivity;

/**
 * Created by Johann on 02/03/2015.
 */
public class ListarTodo extends AsyncTask<String, Void, String> {
    Context context;
    ProgressDialog progressDialog;

    public ListarTodo(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Cargando Datos");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected String doInBackground(String... params) {
        String resultado = "";
        for (String url : params) {
            resultado = RESTClient.connectAndReturnResponse(url);
        }
        return resultado;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        progressDialog.dismiss();
        ((MainActivity) context).resultadoListarTodo(s);
    }
}
