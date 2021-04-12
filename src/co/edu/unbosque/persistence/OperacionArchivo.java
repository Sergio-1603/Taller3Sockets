package co.edu.unbosque.persistence;
import co.edu.unbosque.model.model.Reporte;
import co.edu.unbosque.model.model.Usuario;
import com.csvreader.CsvWriter;

import java.io.*;
import java.util.ArrayList;

public class OperacionArchivo {
    private ObjectInputStream recuperar;
    private ObjectOutputStream escribir;

    public OperacionArchivo(){

    }

    public ArrayList<Usuario> obtener(){
        try  {
            recuperar = new ObjectInputStream(new FileInputStream("./Data/Ciudadanos.dat"));
            ArrayList<Usuario> aux = (ArrayList<Usuario>) recuperar.readObject();
            recuperar.close();
            return aux;
        }catch (EOFException e) {
            return null;
        }catch(IOException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public void escribir(ArrayList<Usuario> a) {
        try {
            ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("./Data/Ciudadanos.dat"));
            escribir.writeObject(a);
            escribir.close();

        } catch (Exception e) {
            System.out.println("Ocurrio una excepcion");
            e.printStackTrace();
            // TODO: handle exception
        }
    }
    public void writeCSV(ArrayList<Reporte> report, boolean bandera){
        try {
            CsvWriter writer = new CsvWriter(new FileWriter("./Data/ReporteCasos.csv", true),';');
            boolean comprobar = new File("./Data/ReporteCasos.csv").exists();
            if (!comprobar) {
                File archive = new File("./Data/ReporteCasos.csv");
                archive.delete();
                writer.write("Type case");
                writer.write("Species");
                writer.write("Size");
                writer.write("Location");
                writer.write("Address");
                writer.write("NameReport");
                writer.write("Cellphone");
                writer.write("Email");
                writer.write("Comentaries");
                writer.write("Date");
                writer.endRecord();
            }
            for(Reporte reporte : report){
                writer.write("");
                writer.write(reporte.getEspecie());
                writer.write(reporte.getTamanio());
                writer.write(reporte.getLocalidad());
                writer.write(reporte.getDireccion());
                writer.write(reporte.getNombreReporte());
                writer.write(reporte.getTelefono());
                writer.write(reporte.getEmail());
                writer.write(reporte.getComentarios());
                writer.write(reporte.getDate());
                writer.endRecord();
            }
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
