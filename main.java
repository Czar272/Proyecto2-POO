import Proyecto2.Archivo;
import Proyecto2.DatosActuales;
import Proyecto2.Perfil;

public class main {
    public static void main(String[] args) {
        DatosActuales dat = new DatosActuales();
        Archivo ar = new Archivo();
        ar.Leer();
        dat.ArPerfiles = ar.FormatAbrir();
        for (Perfil p : dat.ArPerfiles) {
            System.out.println(p.getNombre());
        }
    }
}