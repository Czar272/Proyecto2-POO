package org.example;

import javax.swing.*;

public class interfaz1 {

    private JFrame jFrame;
    private JPanel panel1;
    private JFormattedTextField nombreFormattedTextField;
    private JFormattedTextField apellidoFormattedTextField;
    private JFormattedTextField formattedTextField1;
    private JFormattedTextField formattedTextField2;
    private JFormattedTextField formattedTextField3;
    private JFormattedTextField formattedTextField4;
    private JScrollBar scrollBar1;
    private JComboBox comboBox1;
    private JButton button1;

    interfaz1(){
        jFrame = new JFrame("Editar Perfil");
        jFrame.setVisible(true);
        jFrame.setSize(500,400);
        jFrame.setContentPane(panel1);
    }



}
