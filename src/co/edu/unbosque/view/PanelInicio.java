package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelInicio extends JPanel {
    public JTextField campo1;
    public JTextField campo2;
    public JButton boton;
    public JButton registrarse;

    public PanelInicio(){
        setLayout(null);
        inicializar();
        setVisible(true);
    }

    public void inicializar(){
        setSize(450,450);
        setBackground(Color.white);

        JLabel titulo = new JLabel("CIUDADANO DE 4 PATAS");
        titulo.setBounds(80,50,350,70);
        titulo.setFont(new Font("Arial",Font.BOLD,25));
        add(titulo);

        JLabel texto1 = new JLabel("Usuario");
        texto1.setBounds(100,120,150,30);
        texto1.setFont(new Font("Arial",Font.BOLD,15));
        add(texto1);

        campo1 = new JTextField();
        campo1.setBounds(100,150,150,30);
        add(campo1);

        JLabel texto2 = new JLabel("Contrasenia");
        texto2.setBounds(100,220,150,30);
        texto2.setFont(new Font("Arial",Font.BOLD,15));
        add(texto2);

        campo2 = new JTextField();
        campo2.setBounds(100,250,150,30);
        add(campo2);

        boton = new JButton("Ingresar");
        boton.setActionCommand("INGRESAR");
        boton.setBounds(100,300,100,30);
        add(boton);

        registrarse = new JButton("Registrarse");
        registrarse.setActionCommand("REGISTRO");
        registrarse.setBounds(100,340,100,30);
        add(registrarse);



    }


}
