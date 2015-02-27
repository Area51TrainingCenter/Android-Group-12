package johannfjs.com.utils;

/**
 * Created by Johann on 27/02/2015.
 */
public class Constant {
    public static String DB_NAME = "sesion.db";
    public static int DB_VERSION = 1;

    public static String TB_PERSONA = "tb_persona";
    public static String C_id = "id";
    public static String C_nombre = "nombres";
    public static String C_apellidos = "apellidos";
    public static String C_genero = "genero";

    public static String CREATE_PERSONA = "CREATE TABLE " + TB_PERSONA + "(" + C_id + " integer primary key autoincrement," + C_nombre + " text," + C_apellidos + " text," + C_genero + " text)";
    public static String DROP_PERSONA = "DROP TABLE " + TB_PERSONA;

}
