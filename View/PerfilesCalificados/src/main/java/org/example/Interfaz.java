package org.example;

import javax.swing.*;

public class Interfaz{

    private JFrame jFrame;
    private JPanel panel1;
    private JButton button1;


    Interfaz(){
        jFrame = new JFrame("Calificados");
        jFrame.setVisible(true);
        jFrame.setSize(500,400);
        jFrame.setContentPane(panel1);
    }



}
