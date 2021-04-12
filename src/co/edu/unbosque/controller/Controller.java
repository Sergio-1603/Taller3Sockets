package co.edu.unbosque.controller;

import co.edu.unbosque.model.model.ChatUsuario;
import co.edu.unbosque.model.model.Reporte;
import co.edu.unbosque.model.model.Usuario;
import co.edu.unbosque.persistence.OperacionArchivo;
import co.edu.unbosque.persistence.UsuarioDAO;
import co.edu.unbosque.view.VentanaPrincipal;
import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Controller implements ActionListener {
    VentanaPrincipal vista;
    UsuarioDAO usuarioDAO;
    ArrayList<Reporte> reportes = new ArrayList<>();
    OperacionArchivo archive = new OperacionArchivo();
    boolean bandera = true;
    public Controller(){
        usuarioDAO = new UsuarioDAO();
        vista = new VentanaPrincipal();
        Usuario ciuda = iniciarCiudadano();
        comprobarInicioSesion( ciuda);
        oyentesPPrincipal();
        oyentes();
    }

    public Controller(String a){
        usuarioDAO = new UsuarioDAO();
        vista = new VentanaPrincipal();
        Usuario agent = iniciarAgente();
        comprobarInicioSesion(agent);
        oyentesPPrincipal();
        oyentes();
    }

    public void iniciarChat(Usuario a) throws IOException {
        var client = new ChatUsuario("192.168.2.20",a);
        client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.frame.setVisible(true);
        client.run();



    }


    public void comprobarInicioSesion( Usuario a){
        if(usuarioDAO.sesionIniciada()==null){
            vista.pInicio.setVisible(true);
            vista.panelSesionIniciada(a);
            vista.pInicio.setVisible(false);
            //vista.pPrincipal.setVisible(false);
        }else{
            vista.panelSesionIniciada(usuarioDAO.sesionIniciada());
            oyentesPPrincipal();
            vista.pInicio.setVisible(false);

            vista.pPrincipal.setVisible(true);
        }



    }

    public void oyentesPPrincipal(){
        vista.pPrincipal.cerrar.addActionListener(this);
        vista.pPrincipal.caso.addActionListener(this);
        vista.pPrincipal.hablar.addActionListener(this);
    }

    public void oyentes(){
        vista.pInicio.registrarse.addActionListener(this);
        vista.pInicio.boton.addActionListener(this);
        vista.pRegistro.registro.addActionListener(this);
        vista.pCaso.crear.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e){
        String comand = e.getActionCommand();
        if(comand.equals("HABLAR")) {

          /*  if (usuarioDAO.sesionIniciada().isCiudadano()) {
                try {
                    iniciarChat();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }*/
        }else if(comand.equals("REGISTRO")){
            vista.pInicio.setVisible(false);
            vista.pRegistro.setVisible(true);
        }else if(comand.equals("REGISTRARSE")){
            Usuario aux = new Usuario(vista.pRegistro.campo1.getText(),vista.pRegistro.campo2.getText());
            aux.setInicioSesion(true);
            if(vista.pRegistro.ciudadano.isSelected()){
                aux.setCiudadano(true);
            }else{
                aux.setAgente(true);
            }
            vista.pRegistro.campo1.setText("");
            vista.pRegistro.campo2.setText("");
            usuarioDAO.agregarUsuario(aux);
            vista.pInicio.setVisible(false);
            vista.panelSesionIniciada(aux);
            oyentesPPrincipal();
            vista.pPrincipal.setVisible(true);
            vista.pRegistro.setVisible(false);
            JOptionPane.showConfirmDialog(null,"Registro exitoso");

        }else if(comand.equals("CERRAR")){
            vista.pPrincipal.setVisible(false);
            vista.pInicio.setVisible(true);
            Usuario usuario =usuarioDAO.sesionIniciada();
            usuarioDAO.cerrarSesion(usuario);
        }else if(comand.equals("INGRESAR")){
            String usuario = vista.pInicio.campo1.getText();
            String contra = vista.pInicio.campo2.getText();
            vista.pInicio.campo1.setText("");
            vista.pInicio.campo2.setText("");
            if(!usuarioDAO.comprobarInicioSesionCiudadano(usuario,contra)){
                JOptionPane.showConfirmDialog(null,"No se encontro el usuario");
            }else{
                usuarioDAO.iniciarSesion(usuarioDAO.devolverUsuario(usuario));
                vista.pInicio.setVisible(false);
                vista.panelSesionIniciada(usuarioDAO.sesionIniciada());
                oyentesPPrincipal();
                vista.pPrincipal.setVisible(true);
            }
        }else if(comand.equals("CASO")){
            vista.pPrincipal.setVisible(false);
            vista.pCaso.setVisible(true);
        }else if(comand.equals("CREARC")){
            JOptionPane.showConfirmDialog(null,"Caso creado");
            String especie, tamanio, localidad, direccion, nombrePersona, telefono, email, comentarios;
            especie = vista.pCaso.devolverCampo(0).getText();
            tamanio = vista.pCaso.devolverCampo(1).getText();
            localidad = vista.pCaso.devolverCampo(2).getText();
            direccion = vista.pCaso.devolverCampo(3).getText();
            nombrePersona = vista.pCaso.devolverCampo(4).getText();
            telefono = vista.pCaso.devolverCampo(5).getText();
            email= vista.pCaso.devolverCampo(6).getText();
            comentarios = vista.pCaso.devolverCampo(7).getText();
            LocalDateTime now = LocalDateTime.now();
            String date = now.toString();
            Reporte reporte = new Reporte(especie,tamanio,localidad,direccion,nombrePersona,telefono,email,comentarios, date);
            //Agregar reporte a un arrayList y hacerlo persistente
            reportes.add(reporte);
            archive.writeCSV(reportes, bandera);
            bandera = false;
            vista.pCaso.setVisible(false);
            vista.pPrincipal.setVisible(true);
            vista.pCaso.reiniciar();
        }
    }

    public Usuario iniciarCiudadano(){
        Usuario aux = new Usuario("Fabian","123");
        aux.setCiudadano(true);
       // aux.setInicioSesion(true);
       // usuarioDAO.agregarUsuario(aux);
        return aux;
    }

    public Usuario iniciarAgente(){
        Usuario aux = new Usuario("David","123");
        aux.setAgente(true);
        //aux.setInicioSesion(true);
      //  usuarioDAO.agregarUsuario(aux);
        return aux;
    }
}
