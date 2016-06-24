import java.util.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.lang.Character;
/**
 * Write a description of class Arbitro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Experto
{
    private Interfaz interfaz;
    private int intentos;
    private int cantidadDeHabitantes;
    private final String TITULO_VENTANA = "Adivine la cantidad de habitantes";
    private final String INSTRUCCIONES_JUEGO = "El juego consiste en adivinar la cantidad de habitantes introduciendo digitos";
    private String mensaje;

    //String SUS_INTENTOS = "Le quedan "+intentos+" oportunidades para adivinar";
    private final String NO_INTENTOS = "Se le han acabado las oportunidades";
    private final String MENSAJE_GANADOR = "Felicidades, ganó";
    private final String INTENTOS_REALIZADOS = "Los intentos realizados hasta el momento son: "+intentos+"";
    private final Icon ICONO = new ImageIcon(getClass().getResource("images/iconoDeNicole.jpg"));
    private final Icon ICONO_ROJO = new ImageIcon(getClass().getResource("images/iconoDeNicole.jpg"));
    private final Icon ICONO_VERDE = new ImageIcon(getClass().getResource("images/iconoDeNicole.jpg"));
    private final Icon ICONO_WARNING = new ImageIcon(getClass().getResource("images/iconoDeNicole.jpg"));
    private final Icon ICONO_INFO = new ImageIcon(getClass().getResource("images/iconoDeNicole.jpg"));
    String matrizGuardada;
    private String [] [] matriz;
    private int filas;
    private int columnas;
    public Experto (Interfaz laInterfaz)
    {
        interfaz = laInterfaz;
        filas = 3;
        columnas = 3;
        matriz = new String [filas][columnas];
    }

    public void mostrarInstrucciones()
    {
        interfaz.mostrarMensaje(INSTRUCCIONES_JUEGO,"Adivine la cantidad de habitantes. /nla cantidad de habitantes es: "+cantidadDeHabitantes+"",ICONO_INFO);
    }

    public void comenzarJuego()
    {
        {
            String mat = ""; 
            for( int fila = 0; fila < matriz.length; fila++ ) { 
                for( int columna = 0; columna < matriz[0].length; columna++ ) { 
                    mat = mat + matriz[fila][columna] + "    "; 
                } 
                mat = mat + "\n"; 
            } 
            interfaz.showMessageDialog(null, "La matriz es la siguiente"); 
            interfaz.showMessageDialog(null, mat); 
        }
    }
}
