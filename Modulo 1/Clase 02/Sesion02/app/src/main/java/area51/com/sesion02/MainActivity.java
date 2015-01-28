package area51.com.sesion02;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    EditText txtTextoA;
    Button btnCargarA;
    TextView lblTextoIngresadoA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTextoA = (EditText) findViewById(R.id.txtTexto);
        btnCargarA = (Button) findViewById(R.id.btnCargar);
        lblTextoIngresadoA = (TextView) findViewById(R.id.lblTextoIngresado);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnCargarA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblTextoIngresadoA.setText(txtTextoA.getText().toString());
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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
            lblTextoIngresadoA.setText("Desde el Settings");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
