package negocio;

import java.util.ResourceBundle;

public class Persona {
    // ATRIBUTOS
    private String nombres;
    private String apellidos;
    private int codigo;

    // CONSTRUCTOR
    public Persona() {
    }

    // GETTERS Y SETTERS CON EXCEPCIONES
    
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres
     * @throws Exception se genera una excepción si el nombre es nulo
     */
    public void setNombres(String nombres) throws Exception {
        if (nombres.isEmpty()) {
            this.nombres = nombres;
        } else {
            throw new Exception(ControlPersonas.EXCEPCIONES
                    .getString("excepcion.persona.nombresnulos"));
        }
    }

    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos
     * @throws Exception
     */
    public void setApellidos(String apellidos) throws Exception {
        if (apellidos.isEmpty()) {
            this.apellidos = apellidos;
        } else {
            throw new Exception(ControlPersonas.EXCEPCIONES
                    .getString("excepcion.persona.apellidosnulos"));
        }
    }

    public int getCodigo() {
        return codigo;
    }

    /**
     * Asigna un código al persona
     * @param codigo el codigo to set
     * @throws Exception Arroja una excepción si el codigo es menor que cero
     */
    public void setCodigo(int codigo) throws Exception {
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception(ControlPersonas.EXCEPCIONES
                    .getString("excepcion.persona.errorcodigoinvalido"));
        }
    }

    @Override
    public String toString() {
        return nombres + " " + apellidos + " - Código: " + codigo;
    }
}