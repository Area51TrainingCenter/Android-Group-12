package johannfjs.com.models;

/**
 * Created by Johann on 13/02/2015.
 */
public class Imagen {
    private int id;
    private String rutaImagen;

    public Imagen(int id, String rutaImagen) {
        this.id = id;
        this.rutaImagen = rutaImagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
}
