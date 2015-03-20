package johannfjs.com.sesion20;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import johannfjs.com.sqlite.Querys;
import johannfjs.com.utils.InitViews;

/**
 * Created by Johann on 16/03/2015.
 */
public class SecondActivity extends ActionBarActivity {
    public View root;
    TextView lblTexto;
    Querys querys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        root = findViewById(android.R.id.content).getRootView();
        InitViews.whichClass(this);

        querys = new Querys(SecondActivity.this);
        String nombreCompleto = querys.obtenerNombreCompleto();
        lblTexto.setText(nombreCompleto);
    }
}
