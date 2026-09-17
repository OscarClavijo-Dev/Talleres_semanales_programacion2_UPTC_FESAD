package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelExpresion extends JPanel {
    
    // ATRIBUTOS
    private JRadioButton[] opciones;
    private JTextField textExpresionEvaluar;

    // CONSTRUCTOR
    public PanelExpresion(Eventos evento) {
        // Indica el tipo de distribución
        setLayout(null);
        
        // Inicializa vector los botones de selección
        opciones = new JRadioButton[4];
        
        // Inicializa el texto
        textExpresionEvaluar = new JTextField();
        textExpresionEvaluar.setBounds(10, 10, 265, 30);
        
        // Agrupa los JRadioButton para que solo se pueda seleccionar uno
        ButtonGroup expresion = new ButtonGroup();

        // Inicializa los botones
        opciones[0] = new JRadioButton(evento.ALFABETICA);
        opciones[1] = new JRadioButton(evento.NUMERICA);
        opciones[2] = new JRadioButton(evento.ALFANUMERICA);
        opciones[3] = new JRadioButton(evento.CORREO);

        // Agrega los botones al grupo de selección
        expresion.add(opciones[0]);
        expresion.add(opciones[1]);
        expresion.add(opciones[2]);
        expresion.add(opciones[3]);

        // Ubica los botones al panel
        opciones[0].setBounds(40, 55, 100, 15);
        opciones[1].setBounds(160, 55, 100, 15);
        opciones[2].setBounds(40, 85, 120, 15);
        opciones[3].setBounds(160, 85, 100, 15);

        // Indica que este componente va a responder a eventos
        opciones[0].addActionListener(evento);
        opciones[1].addActionListener(evento);
        opciones[2].addActionListener(evento);
        opciones[3].addActionListener(evento);

        // Se asigna el comando que retornará si es seleccionado
        opciones[0].setActionCommand(evento.ALFABETICA);
        opciones[1].setActionCommand(evento.NUMERICA);
        opciones[2].setActionCommand(evento.ALFANUMERICA);
        opciones[3].setActionCommand(evento.CORREO);

        // Agregar componentes al panel
        add(textExpresionEvaluar);
        add(opciones[0]);
        add(opciones[1]);
        add(opciones[2]);
        add(opciones[3]);
    }

    // GETTERS
    public String getTextoEvaluar() {
        return textExpresionEvaluar.getText();
    }

    // SETTERS
    public void setTextoEvaluar(String texto) {
        textExpresionEvaluar.setText(texto);
    }
}