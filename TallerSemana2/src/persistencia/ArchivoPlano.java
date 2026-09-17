package persistencia;

import java.awt.*;
import java.io.File;
import javax.swing.*;

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
    	return "";
    	}
    
    public String getPath() { 
    	return ""; 
    	}
    
    public boolean isModoEscritura() { 
    	return false;
    	}
    
    public void setModoEscritura(boolean modoEscritura) {
    	
    }
    
    public void setNombre(String nombre) {
    	
    }
    
    public void setPath(String path) {
    	
    }
    
    // MÉTODOS
    public void open() {
    	
    }
    
    public String readerArchivo() { 
    	return ""; 
    	}
    
    public void writerArchivo(Object object) { 
    	
    }
	
}
