package johannfjs.com.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import johannfjs.com.models.Persona;
import johannfjs.com.utils.Constant;

/**
 * Created by Johann on 27/02/2015.
 */
public class Querys {
    private ManageOpenHelper dbConexion;

    public Querys(Context context) {
        dbConexion = new ManageOpenHelper(context);
    }

    public void insertarPersona(String nombre, String apellidos, String genero) {
        SQLiteDatabase dbProcesos = dbConexion.getWritableDatabase();
        String sql = "INSERT INTO " + Constant.TB_PERSONA + "(" +
                Constant.C_nombre + "," +
                Constant.C_apellidos + "," +
                Constant.C_genero + ") VALUES('" +
                nombre + "','" + apellidos + "','" + genero + "')";
        dbProcesos.execSQL(sql);
    }

    public ArrayList<Persona> listarTodos() {
        ArrayList<Persona> listaPersona = new ArrayList<Persona>();
        SQLiteDatabase dbProcesos = dbConexion.getReadableDatabase();
        String sql = "SELECT * FROM " + Constant.TB_PERSONA;
        Cursor cursor = dbProcesos.rawQuery(sql, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    listaPersona.add(new Persona(listaPersona.size(),
                            cursor.getString(cursor.getColumnIndex(Constant.C_nombre)),
                            cursor.getString(cursor.getColumnIndex(Constant.C_apellidos)),
                            cursor.getString(cursor.getColumnIndex(Constant.C_genero))));
                } while (cursor.moveToNext());
            }
        }
        return listaPersona;
    }

    public void eliminarPersona(int id) {
        SQLiteDatabase dbProcesos = dbConexion.getWritableDatabase();
        String sql = "DELETE FROM " + Constant.TB_PERSONA + " WHERE " + Constant.C_id + "=" + id;
        dbProcesos.execSQL(sql);
    }

    public void actualizarPersona(int id, String nombre, String apellido, String genero) {
        SQLiteDatabase dbProcesos = dbConexion.getWritableDatabase();
        String sql = "UPDATE TABLE " + Constant.TB_PERSONA + " SET " +
                Constant.C_nombre + "='" + nombre + "'," +
                Constant.C_apellidos + "='" + apellido + "'," +
                Constant.C_genero + "='" + genero + "' WHERE " +
                Constant.C_id + "=" + id;
        dbProcesos.execSQL(sql);
    }
}
