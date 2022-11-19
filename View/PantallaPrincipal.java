
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Proyecto2.Perfil;

import javax.naming.ldap.Control;
import javax.security.auth.RefreshFailedException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class PantallaPrincipal extends JFrame {
    // Todos los elementos swing de la pantalla
    JButton Avanzar;
    JButton Regresar;
    JButton Rechazar;
    JButton Aceptar;
    JComboBox Configurar;
    JButton Imagen;
    JLabel Titulo;

    private JPanel contentPane;
    private ControllerPrincipal con = new ControllerPrincipal();

    public PantallaPrincipal() {
        // layouts absolutos obtenidos con Eclipse
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        Avanzar = new JButton(">");
        Avanzar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aumenta el index del perfil actual por 1 al ser presionado
                int n = con.getIndexActual();
                n++;
                con.setIndexActual(n);
                Refresh();
            }
        });
        Avanzar.setBounds(383, 227, 41, 23);
        contentPane.add(Avanzar);

        Regresar = new JButton("<");
        Regresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Reduce el index del perfil actual por 1 al ser presionado
                int n = con.getIndexActual();
                n--;
                con.setIndexActual(n);
                Refresh();
            }
        });
        Regresar.setBounds(10, 227, 41, 23);
        contentPane.add(Regresar);

        Rechazar = new JButton("Rechazar");
        Rechazar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                con.dat.ArPerfiles.get(con.getIndexActual()).setEstado(1);
            }
        });
        Rechazar.setBackground(Color.RED);
        Rechazar.setBounds(69, 227, 89, 23);
        contentPane.add(Rechazar);

        Aceptar = new JButton("Aceptar");
        Aceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                con.dat.ArPerfiles.get(con.getIndexActual()).setEstado(2);
            }
        });
        Aceptar.setBackground(Color.GREEN);
        Aceptar.setForeground(new Color(0, 0, 0));
        Aceptar.setBounds(289, 227, 89, 23);
        contentPane.add(Aceptar);

        Configurar = new JComboBox();
        Configurar.setBounds(311, 11, 113, 22);
        Configurar.addItem("Ver Calificados");
        Configurar.addItem("Ver mi Perfil");
        Configurar.addItem("Configurar Perfil");
        Configurar.setSelectedItem(null);
        Configurar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getID());
                System.out.println(Configurar.getSelectedItem());
                if (Configurar.getSelectedItem().equals("Ver Calificados")) {
                    // Se abrira la pestaña de calificados.
                    con.abrirCalificados();
                    dispose();
                } else if (Configurar.getSelectedItem().equals("Ver mi Perfil")) {
                    // Se abrira el perfil en el index 0 en el visualizador
                    con.miPerfil();
                    dispose();
                } else if (Configurar.getSelectedItem().equals("Configurar Perfil")) {
                    // Se abre la pantalla de edicion
                    con.abrirEdicion();
                    dispose();
                }
            }
        });
        contentPane.add(Configurar);

        Titulo = new JLabel("nombre completo y apellido");
        Titulo.setBounds(164, 200, 149, 14);
        contentPane.add(Titulo);

        Imagen = new JButton("");
        Imagen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //
                setVisible(false);
                con.visualizar();
                dispose();
            }
        });
        Imagen.setBounds(47, 45, 331, 144);
        contentPane.add(Imagen);
    }

    public void Refresh() {
        String[] a = con.infoActual();
        if (con.getIndexActual() > 1 && con.getIndexActual() < Integer.parseInt(a[4])) {
            Regresar.setEnabled(true);
            Avanzar.setEnabled(true);
        } else if (con.getIndexActual() == 1) {
            Regresar.setEnabled(false);
            Avanzar.setEnabled(true);
        } else if (con.getIndexActual() == Integer.parseInt(a[4])) {
            Avanzar.setEnabled(false);
            Regresar.setEnabled(true);
        }
        Titulo.setText(a[0] + " " + a[1] + ", " + a[2]);
        BufferedImage myPicture = null;
        try {
            File f = new File(a[3]);
            myPicture = ImageIO.read(f);
            Imagen.setIcon(new ImageIcon(myPicture));
        } catch (IOException e) {
            e.printStackTrace();
            Imagen.setText("Imagen no disponible");
        }

    }
}
