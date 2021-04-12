package co.edu.unbosque.model.model;

import co.edu.unbosque.controller.Controller;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class ChatAgente {
    public static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        Controller c = new Controller("");
        Usuario aux = new Usuario("David","123");
        aux.setAgente(true);
        c.iniciarChat(aux);


    }
}
