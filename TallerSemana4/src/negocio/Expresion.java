package negocio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expresion {

    // CONSTANTES PÚBLICAS
    
    /**
     * Constante de tipo de expresión tipo alfabética
     */
    public static final int TIPO_ALFABETICA = 0;
    
    /**
     * Constante de tipo de expresión tipo numérica
     */
    public static final int TIPO_NUMERO = 1;
    
    /**
     * Constante de tipo de expresión tipo alfanumérica
     */
    public static final int TIPO_ALFANUMERICA = 2;
    
    /**
     * Constante de tipo de expresión tipo correo
     */
    public static final int TIPO_CORREO = 3;
    
    /**
     * Constante de expresión regular alfabética
     */
    public static final String EXPRESION_ALFABETICA = "[a-zA-Z]+";
    
    /**
     * Constante de expresión regular alfanumérica
     */
    public static final String EXPRESION_ALFANUMERICA = "[a-zA-Z]+[0-9]+";
    
    /**
     * Constante de expresión regular de correo electrónico
     */
    public static final String EXPRESION_CORREO = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
    
    /**
     * Constante de expresión regular numérica
     */
    public static final String EXPRESION_NUMERO = "[0-9]+";

    // ATRIBUTO PRIVADO
    /**
     * Señala la expresión a evaluar.
     */
    private int tipo;

    // CONSTRUCTOR
    public Expresion() {
    }

    /**
     * Valida la cadena e indica si cumple con expresión regular
     * @param cadenaAValuar="" cadena a ser evaluada
     * @return veracidad. false sino cumple, true si cumple.
     */
    public boolean validarExpresion(String cadenaAValuar) {
        
        // variable temporal
        boolean veracidad = false;
        
        // Instrucción para las diferentes alternativas
        switch (tipo) {
            // si es de tipo alfabética
            case TIPO_ALFABETICA:
                // compara si la cadena entregada como parámetro
                // cumple con la expresión
                if (cadenaAValuar.matches(EXPRESION_ALFABETICA)) {
                    veracidad = true;
                }
                break;
                
            // si es de tipo numérica
            case TIPO_NUMERO:
                if (cadenaAValuar.matches(EXPRESION_NUMERO)) {
                    veracidad = true;
                }
                break;
                
            case TIPO_ALFANUMERICA:
                if (cadenaAValuar.matches(EXPRESION_ALFANUMERICA)) {
                    veracidad = true;
                }
                break;
                
            case TIPO_CORREO:
                if (cadenaAValuar.matches(EXPRESION_CORREO)) {
                    veracidad = true;
                }
                break;
        }
        
        return veracidad;
    }

    /**
     * Impone un tipo a evaluar
     * @param tipo. 0<= tipo <=3
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna el tipo actual a evaluar
     */
    public int getTipo() {
        return tipo;
    }
    
    /**
     * Método alternativo usando Pattern y Matcher (Imagen 6)
     * Valida la cadena e indica si cumple con expresión regular
     * @param expresionFija="" Patrón para evaluar
     * @param expresionEvaluar != "" cadena a ser evaluada
     * @return veracidad. false sino cumple, true si cumple.
     */
    public boolean evaluarExpresion(String expresionFija, String expresionEvaluar) {
        
        // variable temporal
        boolean respuesta = false;
        
        // Objeto de tipo Pattern se inicializa entregando como
        // parámetro el patrón de evaluación
        Pattern p = Pattern.compile(expresionFija);
        
        // La Clase Matcher evalúa si la cadena pertenece a la
        // expresión regular entregada como parámetro, retorna
        // un valor booleano.
        Matcher m = p.matcher(expresionEvaluar);
        
        if (m.find()) {
            respuesta = true;
        }
        
        return respuesta;
    }
}