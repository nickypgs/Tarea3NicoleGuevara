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
    private Random generador;
    //String SUS_INTENTOS = "Le quedan "+intentos+" oportunidades para adivinar";
    private final String NO_INTENTOS = "Se le han acabado las oportunidades";
    private final String MENSAJE_GANADOR = "Felicidades, ganó";
    private final String INTENTOS_REALIZADOS = "Los intentos realizados hasta el momento son: "+intentos+"";
    private final Icon ICONO = new ImageIcon(getClass().getResource("images/iconoDeNicole.jpg"));
    private final Icon ICONO_ROJO = new ImageIcon(getClass().getResource("images/iconoDeNicole.jpg"));
    private final Icon ICONO_VERDE = new ImageIcon(getClass().getResource("images/iconoDeNicole.jpg"));
    private final Icon ICONO_WARNING = new ImageIcon(getClass().getResource("images/iconoDeNicole.jpg"));
    private final Icon ICONO_INFO = new ImageIcon(getClass().getResource("images/iconoDeNicole.jpg"));
    String laberintoGuardada;
    private int [] [] laberinto;
    private double porcentajeVacio;
    private int lado;
    
    public Experto (Interfaz laInterfaz, int lado, double porcentajeVacio){
        interfaz = laInterfaz;
        this.lado = lado;
        this.porcentajeVacio = porcentajeVacio;        
        laberinto = new int [this.lado][this.lado];
        this.generador = new Random();
        ponerRaton();
        inicializarLaberinto();
    }
    
    public Experto ( int lado, double porcentajeVacio){
        this.lado = lado;
        this.porcentajeVacio = porcentajeVacio;        
        laberinto = new int [this.lado][this.lado];
        this.generador = new Random();
        inicializarLaberinto();
        ponerRaton();
        ponerVacios();
    }

    public void mostrarInstrucciones()
    {
        interfaz.mostrarMensaje(INSTRUCCIONES_JUEGO,"Adivine la cantidad de habitantes. /nla cantidad de habitantes es: "+cantidadDeHabitantes+"",ICONO_INFO);
    }
    /**
     * Se elije la posicion del raton y del queso al azar, teniendo en cuenta que deben esta en 
     * esquinas opuestas
     */
    public void ponerRaton(){
        int esquina = generador.nextInt(4);
        switch(esquina){
            case 0:
                laberinto[0][0] = 1;
                laberinto[this.lado-1][this.lado-1] = 2;
                break;
            case 1:
                laberinto[0][this.lado-1] = 1;
                laberinto[this.lado-1][0] = 2;
                break;
            case 2:
                laberinto[this.lado-1][0] = 1;
                laberinto[0][this.lado-1] = 2;
                break;
            default:
                laberinto[this.lado-1][this.lado-1] = 1;
                laberinto[0][0] = 2;
                break;
        }
    }
    /**
     * Retorna si una casilla del laberinto esta vacio
     */
    public boolean esPared(int fila, int columna){
        boolean esPared = false;
        if(laberinto[fila][columna] == -1){
            esPared = true;
        }
        return esPared;
    }
    /**
     *Inicializa el laberinto con todas las casillas como pared
     */
    public void inicializarLaberinto(){
        for(int i = 0 ; i < laberinto.length; ++i){
            for( int j = 0; j < laberinto[i].length; ++j){
                laberinto[i][j] = -1;
            }
        }
    }
    
    /**
     * Coloca el porcentaje indicado por el usuario de casillas vacias
     */
    public void ponerVacios(){
        double porcentajeActual = 0;
        int contador = 0;
        int fila = 0;
        int columna = 0;
        while(porcentajeActual < this.porcentajeVacio ){
            fila = generador.nextInt(this.lado);
            columna = generador.nextInt(this.lado);
            if(esPared(fila,columna)){
                laberinto[fila][columna] = 0;
                contador++;
                porcentajeActual = ((contador*100)/(this.lado*this.lado)); 
            }
        }
        comenzarJuego();
    }
    
    public void comenzarJuego(){
        {
            String mat = ""; 
            for( int fila = 0; fila < laberinto.length; fila++ ) { 
                for( int columna = 0; columna < laberinto[0].length; columna++ ) { 
                    mat = mat + laberinto[fila][columna] + "    "; 
                } 
                mat = mat + "\n"; 
            } 
            interfaz.showMessageDialog(null, "La laberinto es la siguiente"); 
            interfaz.showMessageDialog(null, mat); 
        }
    }
}