import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Proyecto2.Perfil;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class PantallaVisualizar extends JFrame {
    JButton Regresar;
    JLabel Titulo;
    JLabel Imagen;
    JButton Rechazar;
    JButton Aceptar;
    JLabel Descripcion;
    JLabel TIntereses;
    JLabel Intereses;

    private JPanel contentPane;
    private Perfil perf;

    public PantallaVisualizar(Perfil p) {
        perf = p;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 471);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        Regresar = new JButton("Regresar");
        Regresar.addActionListener(new ActionListener() {
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
        Regresar.setBounds(10, 11, 89, 23);
        contentPane.add(Regresar);

        Titulo = new JLabel("nombre apellido y edad");
        Titulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Titulo.setHorizontalAlignment(SwingConstants.CENTER);
        Titulo.setToolTipText("");
        Titulo.setBounds(92, 54, 231, 14);
        contentPane.add(Titulo);

        Imagen = new JLabel("");
        Imagen.setBounds(60, 79, 323, 139);
        contentPane.add(Imagen);

        Rechazar = new JButton("Rechazar");
        Rechazar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        Rechazar.setBackground(Color.RED);
        Rechazar.setBounds(60, 229, 89, 23);
        contentPane.add(Rechazar);

        Aceptar = new JButton("Aceptar");
        Aceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        Aceptar.setBackground(Color.GREEN);
        Aceptar.setBounds(294, 229, 89, 23);
        contentPane.add(Aceptar);

        Descripcion = new JLabel("Descripcion aqui");
        Descripcion.setHorizontalAlignment(SwingConstants.CENTER);
        Descripcion.setHorizontalTextPosition(SwingConstants.CENTER);
        Descripcion.setBounds(108, 267, 203, 44);
        contentPane.add(Descripcion);

        TIntereses = new JLabel("Intereses:");
        TIntereses.setBounds(60, 321, 98, 14);
        contentPane.add(TIntereses);

        Intereses = new JLabel("intereses aqui");
        Intereses.setBounds(75, 346, 203, 74);
        contentPane.add(Intereses);
        if (perf.getEstado() == 4) {
            Rechazar.setVisible(false);
            Aceptar.setVisible(false);
        }
    }

    public void Refresh() {
        // Cambia los datos presentados por el programa segun el perfil actual
        Titulo.setText(perf.getNombre() + " " + perf.getApellido() + ", " + perf.getEdad());
        Descripcion.setText(perf.getDescripcion());
        String temp = "<html>";
        // Para lograr hacer los breaks en los JLabels se solicitó el siguiente foro:
        // https://stackoverflow.com/questions/1090098/newline-in-jlabel
        for (String st : perf.getIntereses()) {
            temp = temp + st + "<br/>";
        }
        temp = temp + "</html>";
        Intereses.setText(temp);

        // Asignación de imagen:
        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File(perf.getImagen()));
            Imagen.setIcon(new ImageIcon(myPicture));
        } catch (IOException e) {
            e.printStackTrace();
            Imagen.setText("Imagen no disponible");
        }

    }

}
