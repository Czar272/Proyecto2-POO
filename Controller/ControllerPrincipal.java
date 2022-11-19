import Proyecto2.Archivo;
import Proyecto2.DatosActuales;
import Proyecto2.Perfil;
import Proyecto2.View.PantallaEdicion;

public class ControllerPrincipal {
    int indexActual = 1;
    public DatosActuales dat = new DatosActuales();
    private Archivo ar = new Archivo();

    public int getIndexActual() {
        return indexActual;
    }

    public void setIndexActual(int indexActual) {
        this.indexActual = indexActual;
    }

    public ControllerPrincipal() {
        ar.Leer();
        dat.ArPerfiles = ar.FormatAbrir();
    }

    public String[] infoActual() {
        String[] a = new String[5];
        a[0] = dat.ArPerfiles.get(indexActual).getNombre();
        a[1] = dat.ArPerfiles.get(indexActual).getApellido();
        a[2] = dat.ArPerfiles.get(indexActual).getEdad() + "";
        a[3] = dat.ArPerfiles.get(indexActual).getImagen();
        a[4] = dat.ArPerfiles.size() - 1 + "";
        return a;
    }

    public void visualizar() {
        try {
            PantallaVisualizar frame = new PantallaVisualizar(dat.ArPerfiles.get(indexActual));
            frame.Refresh();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void abrirCalificados() {
        try {
            PantallaCalificados frame = new PantallaCalificados(dat.ArPerfiles);
            frame.Refresh();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void abrirEdicion() {
        try {
            PantallaEdicion frame = new PantallaEdicion(dat.ArPerfiles);
            frame.Refresh();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void miPerfil() {
        try {
            PantallaVisualizar frame = new PantallaVisualizar(dat.ArPerfiles.get(0));
            frame.Refresh();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}