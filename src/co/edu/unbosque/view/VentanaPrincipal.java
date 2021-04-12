package co.edu.unbosque.view;

import co.edu.unbosque.model.model.ChatUsuario;
import co.edu.unbosque.model.model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class VentanaPrincipal extends JFrame {
    public PanelInicio pInicio;
    public PanelRegistro pRegistro;
    public PanelPrincipal pPrincipal;
    public ChatUsuario chatUsuario;
    public PanelCaso pCaso;
    public VentanaPrincipal(){
        setTitle("Chat CIUDADANO 4 PATAS");
        setSize(450,450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        inicializar();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void inicializar(){
        pInicio = new PanelInicio();
        getContentPane().add(pInicio);

        pRegistro = new PanelRegistro();
        getContentPane().add(pRegistro);

        pCaso = new PanelCaso();
        getContentPane().add(pCaso);
        //pPrincipal = new PanelPrincipal(null);

    }

    public void panelSesionIniciada(Usuario a){
        pPrincipal = new PanelPrincipal(a);
        getContentPane().add(pPrincipal);
    }

    /*public void iniciarChat() throws IOException {
        var client = new ChatUsuario("192.168.2.20");
        client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.frame.setVisible(true);
        //getContentPane().add(client);
        client.run();
    }*/




}
