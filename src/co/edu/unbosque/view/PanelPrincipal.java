package co.edu.unbosque.view;

import co.edu.unbosque.model.model.Usuario;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    public JButton hablar;
    public JButton caso;
    public JButton cerrar;
    public PanelPrincipal(Usuario a){
        setLayout(null);
        inicializar(a);
        setVisible(true);
    }

    public void inicializar(Usuario a) {
        setSize(450, 450);

        String texto = "";
        String texto2 = "";
        if(a.isCiudadano()){
            texto = "Bienvenido ciudadano "+a.getUsuario();
            texto2 = "Hablar con agente";
        }else{
            texto = "Bienvenido agente "+a.getUsuario();
            texto2 = "Hablar con ciudadano";
        }
        JLabel titulo = new JLabel(texto);
        titulo.setBounds(70,20,350,70);
        titulo.setFont(new Font("Arial",Font.BOLD,20));
        add(titulo);

        hablar = new JButton(texto2);
        hablar.setBounds(130,100,160,40);
        hablar.setActionCommand("HABLAR");
        add(hablar);

        caso = new JButton("Crear caso");
        caso.setActionCommand("CASO");
        caso.setBounds(130,200,160,40);
        add(caso);

        cerrar = new JButton("Cerrar Sesión");
        cerrar.setActionCommand("CERRAR");
        cerrar.setBounds(130,300,160,40);
        add(cerrar);
    }

}
