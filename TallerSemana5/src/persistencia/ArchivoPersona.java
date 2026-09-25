package persistencia;

public class ArchivoPersona extends ArchivoPlano {

    public ArchivoPersona() {
        super();
    }

    public String[] read(int codigo) throws Exception {
        String[] lineas = readerArchivo();
        String[] datosPersona = null;
        
        for (String linea : lineas) {
            if (linea != null && !linea.trim().isEmpty()) {
                String[] datos = linea.split(";");
                if (datos.length == 3) {
                    try {
                        int codigoPersona = Integer.parseInt(datos[2].trim());
                        if (codigoPersona == codigo) {
                            datosPersona = datos;
                            break;
                        }
                    } catch (NumberFormatException e) {
                        throw new Exception("Error al leer el código: " + e.getMessage());
                    }
                }
            }
        }
        
        return datosPersona;
    }

    public void writer(String datosPersona) throws Exception {
        try {
            writerArchivo(datosPersona);
        } catch (Exception e) {
            throw new Exception("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}