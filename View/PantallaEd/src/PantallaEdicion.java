import javax.swing.*;

public class PantallaEdicion extends JFrame {
    private JPanel Panel;
    private JButton BRegresar;
    private JTextField FNombre;
    private JTextField FApellido;
    private JTextField FEdad;
    private JTextField FDescripcion;
    private JTextField FIntereses;
    private JTextField FImagen;
    private JLabel TNombre;
    private JLabel TApellido;
    private JLabel TEdad;
    private JLabel TDescripcion;
    private JLabel TIntereses;
    private JLabel TImagen;

    public PantallaEdicion(){
        add(Panel);
        setSize(400,300);
    }
}
