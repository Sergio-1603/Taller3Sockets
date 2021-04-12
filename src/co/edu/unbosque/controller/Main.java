package co.edu.unbosque.controller;

import co.edu.unbosque.model.model.Usuario;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Controller c = new Controller();
        c.iniciarChat(new Usuario("Fabian","123"));
    }
}
