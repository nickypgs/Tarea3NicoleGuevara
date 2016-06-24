import javax.swing.Icon;
import javax.swing.ImageIcon;
/**
 * La clase Controlador se encarga de iniciar el programa.
 * 
 * @NicoleGuevara 
 * @23.06.2016.
 */
public class Controlador
{
    private Interfaz interfaz;
    private Experto experto;
    private int opcion;
    private final String MENSAJE_VENTANA = "Bienvenido; elija una opción para continuar.";
    private final String MENSAJE_LADO = "Digite el tamaño de lado \n(debe ser un numero entero)";    
    private final String MENSAJE_PORCENTAJE = "Digite el porcentaje de casillas vacias \n(Número decimal)";
    private final String TITULO_VENTANA = "Laberinto";
    private final String[] OPCIONES = {"Jugar","Instrucciones","Cerrar"};
    private final Icon ICONO = new ImageIcon(getClass().getResource("images/iconoDeNicole.jpg"));

    /**
     * Constructor de la clase Controlador.
     */
    public Controlador (){
        interfaz = new Interfaz();
        opcion = 0;
    }

    /**
     * Iniciar el juego, elegir entre 3 opciones: jugar, instrucciones o cerrar.
     */
    public void iniciar(){
        do {
            opcion = interfaz.mostrarMenu(MENSAJE_VENTANA,TITULO_VENTANA,ICONO,OPCIONES);
            switch (opcion)
            {
                case 0 : this.reiniciar();
                break;

                case 1 : experto.mostrarInstrucciones();
                break;
            }
        } while (opcion == 0 || opcion == 1);
    }

    /**
     * Reinicia el juego.
     */
    public void reiniciar()
    {
        int lado = interfaz.pedirInt(MENSAJE_LADO,TITULO_VENTANA);
        double porcentaje = interfaz.pedirDouble(MENSAJE_PORCENTAJE, TITULO_VENTANA);
        experto = new Experto(interfaz, lado , porcentaje);
    }

    /**
     * Inicia el programa.
     */
    public static void main(String[] parametros)
    {
        Controlador controlador;
        controlador = new Controlador();
        controlador.iniciar();
    }

}
