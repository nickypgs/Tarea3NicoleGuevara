import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
/**
 * La clase Interfaz se encarga de la interacción con el usuario por medio de la clase JOptionPane.
 * 
 * @NicoleGuevara 
 * @23.06.2016.
 */
public class Interfaz extends JOptionPane
{
    private Interfaz interfaz;
    /**
     * Mostrar el menú presente en la clase Controlador.
     */
    public int mostrarMenu(String MENSAJE_VENTANA, String TITULO_VENTANA, Icon ICONO, String[] OPCIONES){
        return this.showOptionDialog(null,MENSAJE_VENTANA,TITULO_VENTANA,1,1,ICONO,OPCIONES,OPCIONES[0]);
    }

    /**
     * Mostrar un mensaje. 
     */
    public void mostrarMensaje(String MENSAJE, String TITULO_VENTANA, Icon ICONO){
        interfaz.showMessageDialog(null,MENSAJE,TITULO_VENTANA,0,ICONO);
    }
    
    /**
     * Pide un numero entero al usuario
     */
    public int pedirInt(String MENSAJE, String TITULO_VENTANA){
        return Integer.parseInt(JOptionPane.showInputDialog(null,MENSAJE, TITULO_VENTANA, interfaz.PLAIN_MESSAGE));
    }
    
    /**
     * Pide un numero decimal al usuario
     */
    public double pedirDouble(String MENSAJE, String TITULO_VENTANA){
        return Double.parseDouble(JOptionPane.showInputDialog(null,MENSAJE, TITULO_VENTANA, interfaz.PLAIN_MESSAGE));
    }
}
