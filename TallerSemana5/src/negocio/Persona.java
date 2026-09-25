package negocio;

import negocio.ControlPersonas;

public class Persona {
    // ATRIBUTOS
    private String nombres;
    private String apellidos;
    private int codigo;

    // CONSTRUCTOR
    public Persona() {
    }

    // GETTERS
    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getCodigo() {
        return codigo;
    }

    // SETTERS CON VALIDACIÓN CORRECTA
    
    /**
     * @param nombres
     * @throws Exception se genera una excepción si el nombre es nulo o vacío
     */
    public void setNombres(String nombres) throws Exception {
        if (nombres != null && !nombres.trim().isEmpty()) {
            this.nombres = nombres.trim();
        } else {
            throw new Exception(ControlPersonas.EXCEPCIONES
                    .getString("excepcion.persona.nombresnulos"));
        }
    }

    /**
     * @param apellidos
     * @throws Exception
     */
    public void setApellidos(String apellidos) throws Exception {
        if (apellidos != null && !apellidos.trim().isEmpty()) {
            this.apellidos = apellidos.trim();
        } else {
            throw new Exception(ControlPersonas.EXCEPCIONES
                    .getString("excepcion.persona.apellidosnulos"));
        }
    }

    /**
     * Asigna un código al persona
     * @param codigo el codigo to set
     * @throws Exception Arroja una excepción si el codigo es menor o igual a cero
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