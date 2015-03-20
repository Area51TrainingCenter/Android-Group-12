package johannfjs.com.sesion20;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import johannfjs.com.sqlite.Querys;

/**
 * Created by Johann on 18/03/2015.
 */
public class LauncherActivity extends Activity {
    FrameLayout frame;
    Integer contador = 0;
    Integer delay = 1000;
    Querys querys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        frame = (FrameLayout) findViewById(R.id.frame);
    }

    @Override
    protected void onResume() {
        super.onResume();
        querys = new Querys(LauncherActivity.this);
        contador = 0;
        frame.postDelayed(iniciar, delay);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        frame.removeCallbacks(iniciar);
    }

    public Runnable iniciar = new Runnable() {
        @Override
        public void run() {
            if (contador < 1) {
                frame.postDelayed(iniciar, delay);
                contador++;
            } else {
                Intent intent = null;
                if (querys.existeRegistro()) {
                    intent = new Intent(LauncherActivity.this, SecondActivity.class);
                } else {
                    intent = new Intent(LauncherActivity.this, MainActivity.class);
                }
                startActivity(intent);
                finish();
            }
        }
    };
}
