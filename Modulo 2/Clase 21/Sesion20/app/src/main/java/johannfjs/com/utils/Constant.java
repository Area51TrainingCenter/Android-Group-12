package johannfjs.com.utils;

/**
 * Created by Johann on 16/03/2015.
 */
public class Constant {
    public static int DB_VERSION = 1;
    public static String DB_NAME = "sesion21.db";

    public static String TB_PERSONA = "tb_persona";
    public static String C_NOMBRE_APELLIDO = "nombre_apellido";

    public static String CREATE_TABLE_PERSONA = "CREATE TABLE " + TB_PERSONA + "(" + C_NOMBRE_APELLIDO + " TEXT)";
    public static String DROP_TABLE_PERSONA = "DROP TABLE " + TB_PERSONA;
}
