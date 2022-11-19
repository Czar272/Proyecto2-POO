import Proyecto2.Archivo;
import Proyecto2.DatosActuales;
import Proyecto2.Perfil;
import Proyecto2.View.PantallaEdicion;

public class main {
    public static void main(String[] args) {
        DatosActuales dat = new DatosActuales();
        Archivo ar = new Archivo();
        ar.Leer();
        dat.ArPerfiles = ar.FormatAbrir();
        try {
            PantallaPrincipal frame = new PantallaPrincipal();
            frame.Refresh();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("aaaaaaaaaaa");
    }
}