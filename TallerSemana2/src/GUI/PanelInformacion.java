package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelInformacion extends JPanel {

    // ATRIBUTOS (del diagrama UML)
    private JLabel labelApellidos;
    private JLabel labelCodigo;
    private JLabel labelDocumento;
    private JLabel labelNombres;
    private JLabel numeroUsuarios;
    private JTextField textApellidos;
    private JTextField textDocumento;
    private JTextField textNombres;

    // CONSTRUCTOR
    public PanelInformacion() {
    	 // Usar GridLayout de 2 filas x 4 columnas
        setLayout(new GridLayout(2, 4, 10, 10));
        setBorder(new TitledBorder("Datos"));

        // Inicializar LABELS
        labelNombres = new JLabel("Nombres:");
        labelApellidos = new JLabel("Apellidos:");
        labelDocumento = new JLabel("Documento:");
        labelCodigo = new JLabel("Código:");
        numeroUsuarios = new JLabel("Número de Usuarios: 0");

        // Inicializar TEXT FIELDS
        textNombres = new JTextField("Escriba su Nombre");
        textApellidos = new JTextField();
        textDocumento = new JTextField();

        // Preseleccionar texto (código de la guía)
        textNombres.setSelectionEnd(20);

        // Agregar componentes en orden: fila 1 (Nombres, Apellidos), fila 2 (Documento, Usuarios)
        add(labelNombres);
        add(textNombres);
        add(labelApellidos);
        add(textApellidos);
        
        add(labelDocumento);
        add(textDocumento);
        add(labelCodigo);
        add(numeroUsuarios);

        

        // Seleccionar el texto del JTextField de nombres
        textNombres.selectAll();
    }

    // GETTERS
    public String getApellidos() {
        return textApellidos.getText();
    }

    public String getCodigo() {
        return labelCodigo.getText();
    }

    public String getNombres() {
        return textNombres.getText();
    }

    public String getnumeroUsuarios() {
        return numeroUsuarios.getText();
    }

    // SETTERS
    public void setApellidos(String apellidos) {
        textApellidos.setText(apellidos);
    }

    public void setCodigo(String codigo) {
        labelCodigo.setText(codigo);
    }

    public void setNombres(String nombres) {
        textNombres.setText(nombres);
    }

    public void setnumeroUsuarios(String numeroUsuarios) {
        this.numeroUsuarios.setText("Número de Usuarios: " + numeroUsuarios);
    }
    
    
    //METODOS
    
 // MÉTODO para desactivar campos cuando se abre en modo lectura
    public void setModoSoloLectura() {
        // Hacen que el campo de texto no pueda ser editado por usuario
        textApellidos.setEditable(false);
        textDocumento.setEditable(false);
        textNombres.setEditable(false);
    }
}