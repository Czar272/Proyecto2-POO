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
        for (Perfil p : dat.ArPerfiles) {
            System.out.println(p.getNombre());
            System.out.println(p.getDescripcion());
            System.out.println("URL: " + p.getImagen());
            System.out.println("Intereses:");
            for (String st : p.getIntereses()) {
                System.out.println("    " + st);
            }
            System.out.println("");
        }
    }
}