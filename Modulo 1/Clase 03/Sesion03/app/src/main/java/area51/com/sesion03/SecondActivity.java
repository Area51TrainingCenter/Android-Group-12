package area51.com.sesion03;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Created by Johann on 28/01/2015.
 */
public class SecondActivity extends ActionBarActivity {
    TextView lblTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        lblTexto = (TextView) findViewById(R.id.lblTexto);
        lblTexto.setText(getIntent().getExtras().getString("TEXTO") + " - " + getIntent().getExtras().getString("TEXTO_DOS"));
    }
}
