package org.example;

import javax.swing.*;

public class Interfaz {

    private JFrame jFrame;
    private JPanel panel1;
    private JScrollBar scrollBar1;
    private JComboBox comboBox1;
    private JButton button1;
    private JCheckBox aceptarCheckBox;
    private JCheckBox rechazarCheckBox;

    Interfaz(){
        jFrame = new JFrame("Visualizar Perfil");
        jFrame.setVisible(true);
        jFrame.setSize(600,400);
        jFrame.setContentPane(panel1);
    }



}