import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
/**
 * Write a description of class Interfaz here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Interfaz extends JOptionPane
{
    private Interfaz interfaz;
    /**
     * Mostrar el menú presente en la clase Controlador.
     */
    public int mostrarMenu(String MENSAJE_VENTANA, String TITULO_VENTANA, Icon ICONO, String[] OPCIONES) 
    {
        return this.showOptionDialog(null,MENSAJE_VENTANA,TITULO_VENTANA,1,1,ICONO,OPCIONES,OPCIONES[0]);
    }

    /**
     * Mostrar un mensaje. 
     */
    public void mostrarMensaje(String MENSAJE, String TITULO_VENTANA, Icon ICONO)
    {
        interfaz.showMessageDialog(null,MENSAJE,TITULO_VENTANA,0,ICONO);
    }
    
    public void mostrarMensajeUsuario(String MENSAJE, String TITULO_VENTANA)
    {
        interfaz.showInputDialog(null,MENSAJE,TITULO_VENTANA,interfaz.PLAIN_MESSAGE);
    }
}
