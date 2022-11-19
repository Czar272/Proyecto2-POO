import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Proyecto2.Archivo;
import Proyecto2.Perfil;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class PantallaEdicion extends JFrame {

    private JPanel contentPane;
    private JTextField FNombre;
    private JTextField FApellido;
    private JTextField FEdad;
    private JTextField FDescripcion;
    private JTextField FIntereses;
    private JTextField FImagen;
    private JButton Guardar;
    private ArrayList<Perfil> Arperf;
    private Perfil perf;

    public PantallaEdicion(ArrayList<Perfil> p) {
        Arperf = p;
        perf = Arperf.get(0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 498, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("Regresar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    PantallaPrincipal frame = new PantallaPrincipal();
                    frame.Refresh();
                    frame.setVisible(true);
                } catch (Exception e1) {
                    System.out.println("errorrr");
                    ;
                }
                dispose();
            }
        });
        btnNewButton.setBounds(10, 11, 89, 23);
        contentPane.add(btnNewButton);

        JLabel TNombre = new JLabel("Nombre:");
        TNombre.setBounds(10, 60, 57, 14);
        contentPane.add(TNombre);

        JLabel TApellido = new JLabel("Apellido:");
        TApellido.setBounds(10, 85, 57, 14);
        contentPane.add(TApellido);

        JLabel TEdad = new JLabel("Edad:");
        TEdad.setBounds(10, 110, 57, 14);
        contentPane.add(TEdad);

        JLabel TDescripcion = new JLabel("Descripcion:");
        TDescripcion.setBounds(10, 135, 89, 14);
        contentPane.add(TDescripcion);

        JLabel TIntereses = new JLabel("Intereses (separados por comas):");
        TIntereses.setBounds(10, 160, 212, 14);
        contentPane.add(TIntereses);

        JLabel TImagen = new JLabel("Imagen (URL):");
        TImagen.setBounds(10, 185, 80, 14);
        contentPane.add(TImagen);

        FNombre = new JTextField();
        FNombre.setBounds(232, 57, 217, 20);
        contentPane.add(FNombre);
        FNombre.setColumns(10);

        FApellido = new JTextField();
        FApellido.setBounds(232, 82, 217, 20);
        contentPane.add(FApellido);
        FApellido.setColumns(10);

        FEdad = new JTextField();
        FEdad.setBounds(232, 107, 217, 20);
        contentPane.add(FEdad);
        FEdad.setColumns(10);

        FDescripcion = new JTextField();
        FDescripcion.setBounds(232, 132, 217, 20);
        contentPane.add(FDescripcion);
        FDescripcion.setColumns(10);

        FIntereses = new JTextField();
        FIntereses.setBounds(232, 157, 217, 20);
        contentPane.add(FIntereses);
        FIntereses.setColumns(10);

        FImagen = new JTextField();
        FImagen.setBounds(232, 182, 217, 20);
        contentPane.add(FImagen);
        FImagen.setColumns(10);

        Guardar = new JButton("Guardar");
        Guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Guardar();
            }
        });
        Guardar.setBounds(360, 11, 89, 23);
        contentPane.add(Guardar);
    }

    public void Refresh() {
        FNombre.setText(perf.getNombre());
        FApellido.setText(perf.getApellido());
        FEdad.setText(perf.getEdad());
        FDescripcion.setText(perf.getDescripcion());
        FImagen.setText(perf.getImagen());
        String temp = "";
        for (int i = 0; i < perf.getIntereses().size(); i++) {
            if (i != perf.getIntereses().size() - 1) {
                temp = temp + perf.getIntereses().get(i) + ", ";
            } else {
                temp = temp + perf.getIntereses().get(i);
            }
        }
        FIntereses.setText(temp);
    }

    public void Guardar() {
        Arperf.get(0).setNombre(FNombre.getText());
        Arperf.get(0).setApellido(FApellido.getText());
        Arperf.get(0).setEdad(FEdad.getText());
        Arperf.get(0).setDescripcion(FDescripcion.getText());
        try {
            File f = new File(FImagen.getText());
            Arperf.get(0).setImagen(FImagen.getText());
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "URL no válido", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        Archivo ar = new Archivo();
        ar.Guardar(Arperf);

    }
}