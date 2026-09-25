package GUI;

import negocio.Persona;
import javax.swing.*;
import java.awt.*;

public class PanelInformacion extends JPanel {
    
    // ATRIBUTOS
    private JLabel labelNombres;
    private JLabel labelApellidos;
    private JLabel labelDocumento;
    private JLabel labelCodigo;
    private JTextField textNombres;
    private JTextField textApellidos;
    private JTextField textDocumento;
    private JTextField textCodigo;  // ✅ AGREGADO: Esta línea faltaba
    private JLabel numeroUsuarios;

    // CONSTRUCTOR
    public PanelInformacion() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setLayout(null);
        setBorder(BorderFactory.createTitledBorder("Información de la Persona"));
        setPreferredSize(new Dimension(400, 200));

        // Labels
        labelNombres = new JLabel("Nombres:");
        labelNombres.setBounds(20, 30, 80, 25);
        
        labelApellidos = new JLabel("Apellidos:");
        labelApellidos.setBounds(20, 65, 80, 25);
        
        labelDocumento = new JLabel("Documento:");
        labelDocumento.setBounds(20, 100, 80, 25);
        
        labelCodigo = new JLabel("Código:");
        labelCodigo.setBounds(20, 135, 80, 25);

        // TextFields
        textNombres = new JTextField();
        textNombres.setBounds(110, 30, 200, 25);
        
        textApellidos = new JTextField();
        textApellidos.setBounds(110, 65, 200, 25);
        
        textDocumento = new JTextField();
        textDocumento.setBounds(110, 100, 200, 25);
        
        textCodigo = new JTextField();  // ✅ AGREGADO: Inicialización
        textCodigo.setBounds(110, 135, 200, 25);

        // Label número de usuarios
        numeroUsuarios = new JLabel("Usuarios: 0");
        numeroUsuarios.setBounds(250, 170, 150, 25);

        // Agregar componentes al panel
        add(labelNombres);
        add(textNombres);
        add(labelApellidos);
        add(textApellidos);
        add(labelDocumento);
        add(textDocumento);
        add(labelCodigo);
        add(textCodigo);  // ✅ AGREGADO
        add(numeroUsuarios);
    }

    // GETTERS
    public String getNombres() {
        return textNombres.getText();
    }

    public String getApellidos() {
        return textApellidos.getText();
    }

    public String getDocumento() {
        return textDocumento.getText();
    }

    public String getCodigo() {  // ✅ CORREGIDO
        return textCodigo.getText();
    }

    // SETTERS
    public void setNombres(String nombres) {
        textNombres.setText(nombres);
    }

    public void setApellidos(String apellidos) {
        textApellidos.setText(apellidos);
    }

    public void setDocumento(String documento) {
        textDocumento.setText(documento);
    }

    public void setCodigo(String codigo) {  // ✅ CORREGIDO
        textCodigo.setText(codigo);
    }

    public void setNumeroUsuarios(int numero) {
        numeroUsuarios.setText("Usuarios: " + numero);
    }

    // MÉTODO para obtener la persona desde los campos
    public Persona getPersona() throws Exception {
        Persona persona = new Persona();
        
        // Los setters ya lanzan las excepciones
        persona.setNombres(getNombres());
        persona.setApellidos(getApellidos());
        persona.setCodigoFromString(getCodigo());
        
        return persona;
    }

    // MÉTODO para establecer los datos de una persona en los campos
    public void setPersona(Persona persona, int tamanoVector) {
        if (persona != null) {
            setNombres(persona.getNombres());
            setApellidos(persona.getApellidos());
            setCodigo(String.valueOf(persona.getCodigo()));
            setDocumento(""); // El documento no está en el modelo
        } else {
            limpiarCampos();
        }
        setNumeroUsuarios(tamanoVector);
    }

    // MÉTODO para limpiar campos
    public void limpiarCampos() {
        textNombres.setText("");
        textApellidos.setText("");
        textDocumento.setText("");
        textCodigo.setText("");  // ✅ CORREGIDO
    }
}