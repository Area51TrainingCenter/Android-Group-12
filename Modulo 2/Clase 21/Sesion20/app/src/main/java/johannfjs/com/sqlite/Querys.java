package johannfjs.com.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import johannfjs.com.utils.Constant;

/**
 * Created by Johann on 16/03/2015.
 */
public class Querys {
    Context context;
    ManageOpenHelper dbConexion;

    public Querys(Context context) {
        dbConexion = new ManageOpenHelper(context);
    }

    public void registrarPersona(String nombreCompleto) {
        SQLiteDatabase dbProcesos = dbConexion.getWritableDatabase();
        String sql = "INSERT INTO " + Constant.TB_PERSONA + "(" + Constant.C_NOMBRE_APELLIDO + ")VALUES('" + nombreCompleto + "')";
        dbProcesos.execSQL(sql);
    }

    public boolean existeRegistro() {
        SQLiteDatabase dbProcesos = dbConexion.getReadableDatabase();
        String sql = "SELECT * FROM " + Constant.TB_PERSONA;
        Cursor cursor = dbProcesos.rawQuery(sql, null);
        return cursor.getCount() > 0 ? true : false;
    }

    public String obtenerNombreCompleto() {
        SQLiteDatabase dbProcesos = dbConexion.getReadableDatabase();
        String sql = "SELECT * FROM " + Constant.TB_PERSONA;
        Cursor cursor = dbProcesos.rawQuery(sql, null);
        String nombreCompleto = "";
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    nombreCompleto = cursor.getString(cursor.getColumnIndex(Constant.C_NOMBRE_APELLIDO));
                } while (cursor.moveToNext());
            }
        }
        return nombreCompleto;
    }
}
