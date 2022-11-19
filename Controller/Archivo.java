package Proyecto2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Proyecto2.Model.Perfil;

public class Archivo {
    private File file;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private FileWriter fileWriter;
    private PrintWriter printWriter;
    private String Contenido = "";

    public void Leer() {
        try {
            // Dentro de un Try, se asigna file al archivo que se encuentra en el directorio
            // local
            file = new File("Archivos\\Datos.txt");
            // Luego, FileReader y BufferedReader almacenan el archivo ya abierto
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
        } catch (Exception e) {
            // Catch requerido por el Try
            System.out.println(e);
        }
    }

    public void Guardar(ArrayList<Perfil> ar) {
        // El método guardar requiere de un ArrayList<Perfil> el cual es el que se
        // guardará en
        // el archivo .txt. Este se convierte de en texto con la función FormatCerrar
        Contenido = FormatCerrar(ar);
        try {
            // Dentro de un Try, se intenta abrir el directorio donde se encuentra el
            // archivo localmente
            fileWriter = new FileWriter("Archivos\\Datos.txt");
            // Print writer introduce el String contenido que tiene el ArrayList de perfiles
            // formateado
            // dentro del FileWriter
            printWriter = new PrintWriter(fileWriter);
            printWriter.println(Contenido);
            // Por último se cierra el archivo
            fileWriter.close();
        } catch (Exception e) {
            // Catch requerido por el Try
            System.out.println(e);
        }
    }

    public ArrayList<Perfil> FormatAbrir() {
        // Para formatear el arhivo al ser abierto, primero se instancia un arraylist de
        // perfil temporal
        // en este caso, se llama ar. También se crea una clase Perfil temporal llamada
        // temp.
        ArrayList<Perfil> ar = new ArrayList<Perfil>();
        Perfil temp;
        try {
            // Dentro de un try, cada linea del archivo que no esté vacía se le asigna al
            // String Contenido
            // dentro de un ciclo

            while ((Contenido = bufferedReader.readLine()) != null) {
                // Cada linea luego se separa por comas en una lista de Strings llamada Elemento
                String[] Elemento = Contenido.split(",");
                // Ya que el atributo intereses es una lista, sus elementos están separados por
                // : dentro del
                // espacio 5 de la lista Elemento, por lo que se separan nuevamente en la lista
                // ListIntereses
                System.out.println(Elemento.length);
                if (Elemento.length == 8) {
                    String[] ListIntereses = Elemento[5].split(":");
                    // Luego la lista de intereses es traducida de String[] a ArrayList<String> con
                    // un for
                    ArrayList<String> ArrayIntereses = new ArrayList<String>();
                    for (String st : ListIntereses) {
                        ArrayIntereses.add(st);
                    }
                    // Se instancia el perfil Temp y en su constructor se agregan los elementos
                    // previamente explicados
                    temp = new Perfil(Elemento[0], Elemento[1], Elemento[2], Elemento[3], Elemento[4], ArrayIntereses,
                            Integer.parseInt(Elemento[6]),
                            Integer.parseInt(Elemento[7]));
                    // Por ultimo, se agrega Temp al arraylist de perfiles que devolverá este método
                    ar.add(temp);
                }

            }
            // Catches requeridos por el Try
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ar;
    }

    public String FormatCerrar(ArrayList<Perfil> ArPerfiles) {
        // El formateo para cerrar el archivo requiere de un ArrayList de perfiles y lo
        // convierte en
        // un String, el cual se inicializa como texto.
        String texto = "";
        for (Perfil p : ArPerfiles) {
            // Primero, se convierten todos los elementos del arraylist intereses en un
            // mismo string
            // llamado intereses separados por :, este se reiniciará para cada perfil p
            String intereses = "";
            for (int i = 0; i < p.getIntereses().size(); i++) {
                if (i != p.getIntereses().size() - 1) {
                    intereses = intereses + p.getIntereses().get(i) + ":";
                } else {
                    // Se agregan : despues de cada intereses excepto el último
                    intereses = intereses + p.getIntereses().get(i);
                }
            }
            // Luego, al texto se le agrega cada atributo de p separado por coma y al final
            // se agrega un \r
            // para separar por lineas cada perfil
            texto = texto + p.getNombre() + "," + p.getApellido() + "," + p.getEdad() + "," + p.getDescripcion() + ","
                    + p.getImagen() + "," + intereses + "," + p.getEstado() + "," + p.getEstadoUsuario() + "\n";
        }
        return texto;
    }
}
