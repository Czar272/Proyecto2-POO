
import java.awt.EventQueue;
import java.util.ArrayList;

import Proyecto2.Perfil;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Ref;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class PantallaCalificados extends JFrame {

    private JPanel contentPane;
    JLabel Imagen;
    JLabel Titulo;
    JLabel Calificacion;
    JButton Regresar;
    JButton Avanzar;
    ArrayList<Perfil> ar = new ArrayList<Perfil>();
    String[] perfilActual;
    int index = 0;

    public PantallaCalificados(ArrayList<Perfil> a) {
        for (Perfil p : a) {
            if (p.getEstado() > 0 && p.getEstado() < 4) {
                ar.add(p);
            }
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 447, 374);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton MainRegresar = new JButton("Regresar");
        MainRegresar.addActionListener(new ActionListener() {
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
        MainRegresar.setBounds(10, 11, 89, 23);
        contentPane.add(MainRegresar);

        Regresar = new JButton("<");
        Regresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                index--;
                Refresh();
            }
        });
        Regresar.setBounds(10, 227, 53, 23);
        contentPane.add(Regresar);

        Avanzar = new JButton(">");
        Avanzar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                index++;
                Refresh();
            }
        });
        Avanzar.setBounds(371, 227, 53, 23);
        contentPane.add(Avanzar);

        Imagen = new JLabel("New label");
        Imagen.setBounds(51, 45, 329, 139);
        contentPane.add(Imagen);

        Titulo = new JLabel("New label");
        Titulo.setHorizontalAlignment(SwingConstants.CENTER);
        Titulo.setBounds(110, 195, 195, 14);
        contentPane.add(Titulo);

        JSeparator separator = new JSeparator();
        separator.setBounds(170, 285, 164, -19);
        contentPane.add(separator);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(20, 261, 404, 2);
        contentPane.add(separator_1);

        Calificacion = new JLabel("Te han aceptado o rechazado");
        Calificacion.setHorizontalAlignment(SwingConstants.CENTER);
        Calificacion.setBounds(51, 284, 329, 14);
        contentPane.add(Calificacion);
    }

    public void Refresh() {
        if (index == 0) {
            Regresar.setEnabled(false);
            Avanzar.setEnabled(true);
        } else if (index == (ar.size() - 1)) {
            Regresar.setEnabled(true);
            Avanzar.setEnabled(false);
        } else {
            Regresar.setEnabled(true);
            Avanzar.setEnabled(true);
        }
        Titulo.setText(ar.get(index).getNombre() + " " + ar.get(index).getApellido() + ", " + ar.get(index).getEdad());
        if (ar.get(index).getEstado() == 1) {
            // 1 ES QUE LO RECHAZARON
            Calificacion.setText("Has rechazado a este usuario! :/");
        } else {
            // 2 ES QUE LO ACEPTARON
            Calificacion.setText("Has aceptado a este usuario! :D");
        }
        // NO ESTÁ DICHO EXPLICITAMENTE PERO 0 ES QUE NO HA SIDO CALIFICADO
        BufferedImage myPicture = null;
        try {
            File f = new File(ar.get(index).getImagen());
            myPicture = ImageIO.read(f);
            Imagen.setIcon(new ImageIcon(myPicture));
        } catch (IOException e) {
            e.printStackTrace();
            Imagen.setText("Imagen no disponible");
        }
    }
}
