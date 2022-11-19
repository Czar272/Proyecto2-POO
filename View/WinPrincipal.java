import javax.swing.*;
import java.awt.BorderLayout;

public class WinPrincipal extends JFrame {
    private JPanel Panel = new JPanel();
    private JButton Aceptar = new JButton();
    private JButton Rechazar = new JButton();

    public WinPrincipal() {

        setVisible(true);
        setSize(500, 500);
        add(Panel, BorderLayout.CENTER);
        Panel.add(setupButtonsWithBox());
        // Panel.setLayout(new GridLayout(2, 13, 5, 5));
        // Panel.add(Aceptar);
        // Panel.add(Rechazar);
        // Aceptar.setText("Aceptar");
        // Aceptar.setBounds(200, 200, 50, 50);
        // Rechazar.setText("Rechazar");

        // Panel.setToolTipText("Hooola");
    }

    private JComponent setupButtonsWithBox() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Box b = Box.createHorizontalBox();
        b.add(Box.createHorizontalGlue());
        b.add(new JButton("Left Button"));
        b.add(Box.createVerticalStrut(30));
        b.add(new JButton("Center Button"));
        b.add(Box.createVerticalStrut(30));
        b.add(new JButton("Right Button"));
        b.add(Box.createHorizontalGlue());
        return b;
    }
}
