package persistencia;

import java.io.*;

public class ArchivoPlano {
    // ATRIBUTOS
    private File archivo;
    private boolean modoEscritura;
    private String nombre;
    private String path;

    // CONSTRUCTOR
    public ArchivoPlano() {
    }

    // GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isModoEscritura() {
        return modoEscritura;
    }

    public void setModoEscritura(boolean modoEscritura) {
        this.modoEscritura = modoEscritura;
    }

    // MÉTODOS DE ARCHIVO
    public void open() throws IOException {
        archivo = new File(path, nombre);
        if (!archivo.exists()) {
            archivo.createNewFile();
        }
    }

    public String[] readerArchivo() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(archivo));
        StringBuilder contenido = new StringBuilder();
        String linea;
        
        while ((linea = reader.readLine()) != null) {
            contenido.append(linea).append("\n");
        }
        reader.close();
        
        String texto = contenido.toString().trim();
        if (texto.isEmpty()) {
            return new String[0];
        }
        return texto.split("\n");
    }

    public void writerArchivo(Object contenido) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, !modoEscritura));
        writer.write(contenido.toString());
        writer.close();
    }

    public void close() throws IOException {
        archivo = null;
    }
}