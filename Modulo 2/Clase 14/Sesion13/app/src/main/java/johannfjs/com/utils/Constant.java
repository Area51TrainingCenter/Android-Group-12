package johannfjs.com.utils;

/**
 * Created by Johann on 20/02/2015.
 */
public class Constant {
    public static int DB_VERSION = 1;
    public static String DB_NAME = "sesion13.db";

    public static String TB_PERSONA = "tb_persona";
    public static String C_ID = "id";
    public static String C_NOMBRE = "nombre";
    public static String C_APELLIDO_PATERNO = "apellidoPaterno";
    public static String C_APELLIDO_MATERNO = "apellidoMaterno";

    //CREATE TABLE tb_persona(ID INTEGER PRIMARY KEY AUTOINCREMENT,
    // nombre TEXT, apellidoPaterno TEXT, apellidoMaterno TEXT)
    public static String CREATE_TABLE_PERSONA = "CREATE TABLE " + TB_PERSONA +
            "(" + C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            C_NOMBRE + " TEXT," +
            C_APELLIDO_PATERNO + " TEXT," +
            C_APELLIDO_MATERNO + " TEXT)";

    //DROP TABLE tb_persona
    public static String DROP_TABLE_PERSONA = "DROP TABLE " + TB_PERSONA;
}
