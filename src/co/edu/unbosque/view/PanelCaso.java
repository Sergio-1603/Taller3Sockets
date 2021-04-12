package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelCaso extends JPanel {
    public JTextField campos[];
    public JLabel textos[];
    public JButton crear;
    public PanelCaso(){
        campos = new JTextField[8];
        textos = new JLabel[8];
        setLayout(null);
        inicializar();
        setVisible(false);
    }
    public void inicializar(){
        setSize(450,450);
        String nombres[] = {"Especie","Tamanio","Localidad","Direccion","Nombre del reportante","Telefono","Email","Comentarios"};
        int y = 100;
        int y2 = 70;
        int x = 40;
        JLabel titulo = new JLabel("Crear Caso");
        titulo.setBounds(40,20,350,70);
        titulo.setFont(new Font("Arial",Font.BOLD,20));
        add(titulo);
        for(int i=0;i<8;i++){
            if(y>400){
                y=100;
                y2=70;
                x+=230;
            }
            campos[i] = new JTextField();
            textos[i] = new JLabel(nombres[i]);
            inicializarCampo(campos[i],x,y,150,30 );
            inicializarCampo(textos[i],x,y2,150,30);
            y2+=70;
            y+=70;
        }

        crear = new JButton("Crear");
        crear.setActionCommand("CREARC");
        inicializarCampo(crear,270,290,80,30);


    }

    public void reiniciar(){
        for(int i=0;i<8;i++){
            campos[i].setText("");
        }
    }

    public void inicializarCampo(Component comp, int x, int y, int X, int Y){
        comp.setBounds(x,y,X,Y);
        add(comp);
    }

    public JTextField devolverCampo(int i){
        return campos[i];
    }


}
