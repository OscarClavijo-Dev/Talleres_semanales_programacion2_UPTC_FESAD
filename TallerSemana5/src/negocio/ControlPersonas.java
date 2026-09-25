package negocio;

import persistencia.ArchivoPersona;
import java.util.ResourceBundle;

public class ControlPersonas {
    // CONSTANTES
    public static final int TOTAL_PERSONAS = 100;
    
    // Constante para el archivo de excepciones
    public static final ResourceBundle EXCEPCIONES = ResourceBundle.getBundle("GUI.excepciones_es");

    // ATRIBUTOS
    private ArchivoPersona archivoPersona;
    private Persona[] personas;
    private int secuenciaIngreso;
    private String separadorLineasArchivo;

    // CONSTRUCTOR
    public ControlPersonas() {
        personas = new Persona[TOTAL_PERSONAS];
        secuenciaIngreso = 0;
        separadorLineasArchivo = ";";
        archivoPersona = new ArchivoPersona();
    }

    // MÉTODOS PÚBLICOS
    
    public void add(Persona persona) {
        if (secuenciaIngreso < TOTAL_PERSONAS) {
            personas[secuenciaIngreso] = persona;
            secuenciaIngreso++;
        }
    }

    public Persona getPersona(int posicion) {
        if (posicion >= 0 && posicion < secuenciaIngreso) {
            return personas[posicion];
        }
        return null;
    }

    /**
     * arroja una excepción si se incumple algún valor
     * @throws NumberFormatException
     * arroja una excepción si el formato no es valido
     */
    public void writerArchivo(String path, String nombre, boolean modoEscritura) 
            throws NumberFormatException, Exception {
        
        archivoPersona.setPath(path);
        archivoPersona.setNombre(nombre);
        archivoPersona.setModoEscritura(modoEscritura);
        archivoPersona.open();
        
        StringBuilder contenido = new StringBuilder();
        for (int i = 0; i < secuenciaIngreso; i++) {
            if (personas[i] != null) {
                contenido.append(personas[i].getNombres())
                        .append(separadorLineasArchivo)
                        .append(personas[i].getApellidos())
                        .append(separadorLineasArchivo)
                        .append(personas[i].getCodigo())
                        .append("\n");
            }
        }
        
        archivoPersona.writerArchivo(contenido.toString());
        archivoPersona.close();
    }

    /**
     * @throws NumberFormatException
     * @throws Exception
     */
    public void readArchivo(String path, String nombre) 
            throws NumberFormatException, Exception {
        
        archivoPersona.setPath(path);
        archivoPersona.setNombre(nombre);
        archivoPersona.setModoEscritura(false);
        archivoPersona.open();
        
        String[] lineas = archivoPersona.readerArchivo();
        secuenciaIngreso = 0;
        
        for (String linea : lineas) {
            if (linea != null && !linea.isEmpty()) {
                // Segura la información de cada objeto en sus atributos.
                String[] datos = linea.split(separadorLineasArchivo);
                
                if (datos.length >= 3) {
                    Persona nuevaPersona = new Persona();
                    nuevaPersona.setNombres(datos[0]);
                    nuevaPersona.setApellidos(datos[1]);
                    nuevaPersona.setCodigo(Integer.parseInt(datos[2]));
                    add(nuevaPersona);
                }
            }
        }
        
        archivoPersona.close();
    }

    public int getSecuenciaIngreso() {
        return secuenciaIngreso;
    }

    public void setSecuenciaIngreso(int secuenciaIngreso) {
        this.secuenciaIngreso = secuenciaIngreso;
    }

    public String getSeparadorLineasArchivo() {
        return separadorLineasArchivo;
    }

    public void setSeparadorLineasArchivo(String separadorLineasArchivo) {
        this.separadorLineasArchivo = separadorLineasArchivo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ControlPersonas that = (ControlPersonas) obj;
        return secuenciaIngreso == that.secuenciaIngreso;
    }
}