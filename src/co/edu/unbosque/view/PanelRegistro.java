package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelRegistro extends JPanel {
    public JTextField campo1;
    public JTextField campo2;
    public JRadioButton ciudadano;
    public JRadioButton agente;
    public ButtonGroup grupo;
    public JButton registro;

    public PanelRegistro(){
        setLayout(null);
        inicializar();
        setVisible(false);
    }

    public void inicializar() {
        setSize(450, 450);
        setBackground(Color.white);

        JLabel titulo = new JLabel("Registro");
        titulo.setBounds(80,20,350,70);
        titulo.setFont(new Font("Arial",Font.BOLD,25));
        add(titulo);

        JLabel texto1 = new JLabel("Usuario");
        texto1.setBounds(80,90,150,30);
        texto1.setFont(new Font("Arial",Font.BOLD,15));
        add(texto1);

        campo1 = new JTextField();
        campo1.setBounds(80,120,150,30);
        add(campo1);

        JLabel texto2 = new JLabel("Contrasenia");
        texto2.setBounds(80,160,150,30);
        texto2.setFont(new Font("Arial",Font.BOLD,15));
        add(texto2);

        campo2 = new JTextField();
        campo2.setBounds(80,190,150,30);
        add(campo2);

        ciudadano = new JRadioButton("Ciudadano");
        ciudadano.setBounds(80,240,100,50);
        ciudadano.setSelected(true);
        add(ciudadano);

        agente = new JRadioButton("Agente");
        agente.setBounds(200,240,100,50);
        add(agente);

        grupo = new ButtonGroup();
        grupo.add(ciudadano);
        grupo.add(agente);

        registro = new JButton("Registrarse");
        registro.setActionCommand("REGISTRARSE");
        registro.setBounds(80,320,100,40);
        add(registro);
    }
}
