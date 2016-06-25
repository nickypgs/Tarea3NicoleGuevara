import java.util.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.lang.Character;
/**
 * La clase Experto es la encargada de crear el laberinto.
 * 
 * @NicoleGuevara
 * @23.06.2016
 */
public class Experto {
    private Interfaz interfaz;
    //Título de la ventana.
    private final String TITULO_VENTANA = "Laberinto";
    //Instrucciones del juego.
    private final String INSTRUCCIONES_JUEGO = "El juego consiste en encontrar el camino para llegar del ratón al queso.";
    //Generador de numeros Random;
    private Random generador;
    //Icono de las ventanas.
    private final Icon ICONO = new ImageIcon(getClass().getResource("images/iconoDeNicole.jpg"));
    //Matriz labertinto.
    private int [] [] laberinto;
    //Porcentaje de casillas vacias.
    private double porcentajeVacio;
    //Lado de la matriz.
    private int lado;
    //posicion inicial del raton
    private int filaInicial;
    private int columnaInicial;

    /**
     * Constructor de la clase Experto.
     */
    public Experto (Interfaz laInterfaz, int lado, double porcentajeVacio)  {
        interfaz = laInterfaz;
        this.lado = lado;
        this.porcentajeVacio = porcentajeVacio;        
        laberinto = new int [this.lado][this.lado];
        this.generador = new Random();
        inicializarLaberinto();
        ponerRaton();
        ponerVacios();
    }

    /**
     * Contructor de la clase Experto.
     */
    public Experto (int lado, double porcentajeVacio){
        this.lado = lado;
        this.porcentajeVacio = porcentajeVacio;        
        laberinto = new int [this.lado][this.lado];
        this.generador = new Random();
        inicializarLaberinto();
        ponerRaton();
        ponerVacios();
        encontrarSolucion();
    }

    /**
     * Muestra las instrcciones del juego.
     */ 
    public void mostrarInstrucciones(){
        interfaz.mostrarMensaje(INSTRUCCIONES_JUEGO,"Laberinto",ICONO);
    }

    /**
     * Se elije la posición del ratón y del queso al azar, teniendo en cuenta que deben estar en 
     * esquinas opuestas.
     */
    public void ponerRaton(){
        int esquina = generador.nextInt(4);
        switch(esquina){
            case 0:
            laberinto[0][0] = 1;
            filaInicial = columnaInicial = 0;
            laberinto[this.lado-1][this.lado-1] = 2;
            break;
            case 1:
            laberinto[0][this.lado-1] = 1;
            filaInicial =0;
            columnaInicial = this.lado-1;
            laberinto[this.lado-1][0] = 2;
            break;
            case 2:
            laberinto[this.lado-1][0] = 1;
            filaInicial = this.lado-1;
            columnaInicial = 0;
            laberinto[0][this.lado-1] = 2;
            break;
            default:
            laberinto[this.lado-1][this.lado-1] = 1;
            filaInicial = columnaInicial = this.lado-1;
            laberinto[0][0] = 2;
            break;
        }
    }

    /**
     * Retorna si una casilla del laberinto esta vacío.
     */
    public boolean esPared(int fila, int columna){
        boolean esPared = false;
        if(laberinto[fila][columna] == -1){
            esPared = true;
        }
        return esPared;
    }

    /**
     * Inicializa el laberinto con todas las casillas como pared.
     */
    public void inicializarLaberinto(){
        for(int fila = 0 ; fila < laberinto.length; fila++){
            for( int columna = 0; columna < laberinto[fila].length; columna++){
                laberinto[fila][columna] = -1;
            }
        }
    }

    /**
     * Coloca el porcentaje indicado por el usuario de casillas vacias.
     */
    public void ponerVacios(){
        double porcentajeActual = 0;
        int contador = 0;
        int fila = 0;
        int columna = 0;
        while(porcentajeActual < this.porcentajeVacio )
        {
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
    
    /**
     *Retorna si una posicion es valida en el laberinto 
    */
    public boolean esValida(int fila, int columna){
        boolean valida = false;
        if(fila < laberinto.length && columna < laberinto[fila].length && !esPared(fila,columna)){
            valida = true;
        }
        return valida;
    }
    
    /**
     * 
     */
    public void encontrarSolucion(){
        encontrarSolucion(filaInicial,columnaInicial,0);
    }
    
    /**
     * direccion 0 arriba, 1 derecha, 2, izquierda, 3 abajo
     */
    public int encontrarSolucion(int fila, int columna, int direccion){
        int resultado = -1;
        if( this.laberinto[fila][columna] == 2){
            resultado = 5;
            this.laberinto[fila][columna] = 5;
        }
        else{
            if(esValida(fila-1, columna)){
                resultado = encontrarSolucion(fila+1,columna,0);
            }else{
                if(esValida(fila,columna+1)){
                    resultado = encontrarSolucion(fila,columna+1,1);
                }else{
                    if(esValida(fila,columna-1)){
                        resultado = encontrarSolucion(fila,columna-1,2);
                    }else{
                        if(esValida(fila+1,columna)){
                            resultado = encontrarSolucion(fila+1,columna,3);
                        }
                    }
                } 
            }
        }
        return resultado;
    }
    
    
    /**
     * Muestra el laberinto.
     */
    public void comenzarJuego(){
        {
            String mat = ""; 
            for( int fila = 0; fila < laberinto.length; fila++ ) { 
                for( int columna = 0; columna < laberinto[0].length; columna++ ) { 
                    mat = mat + laberinto[fila][columna] + "    "; 
                } 
                mat = mat + "\n"; 
            }  
            interfaz.showMessageDialog(null, mat); 
        }
    }
}