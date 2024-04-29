package Agenda;

//API
import java.awt.*;
import java.io.*;
import java.time.Year;
import java.util.*;
/**
 * Esta clase es el punto de entrada de la aplicaci�n de agenda.
 * Controla el flujo principal del programa, presentando men�s al usuario y
 * ejecutando las acciones correspondientes a cada opci�n seleccionada.
 */
public class Principal 
{
    
//--------------------------------------------------------------------------
    /**Un objeto de la clase Menu que se utiliza para mostrar los men�s de la 
aplicaci�n.*/
    private Menu menu;
    /**Un entero que representa el a�o de la agenda.*/
    private int anio;
    /**Un ArrayList que almacena objetos de la clase Mes para cada mes del 
a�o.*/
    private ArrayList <Mes> meses = new ArrayList();
    
//--------------------------------------------------------------------------
    public int getAnio() {
        return anio;
    }
    
//--------------------------------------------------------------------------
    /**
     * El m�todo main de la aplicaci�n de la agenda. Crea un nuevo objeto 
Principal
     * y llama al m�todo inicio.
     * @param args Los argumentos de la l�nea de comandos (no utilizados en 
este caso).
     * @throws AWTException Si ocurre un error al borrar la consola.
     * @throws InterruptedException Si ocurre un error mientras se espera la 
entrada del usuario.
     */
    public static void main(String[] args) throws AWTException, 
InterruptedException 
    {
        Principal principal = new Principal();
        principal.inicio(principal);
        
    }//main
    
//--------------------------------------------------------------------------
    /**
     * Inicializa la agenda.
     * @throws AWTException Si ocurre un error al borrar la consola.
     * @throws InterruptedException Si ocurre un error mientras se espera la 
entrada del usuario.
     */
    private void inicio(Principal principal) throws AWTException, 
InterruptedException {
        instanciarMeses();
        menu = new Menu(principal);
        
    }//inicio
    
//--------------------------------------------------------------------------
    /**
     * Crea e instancia los 12 objetos Mes para cada mes del a�o, 
almacen�ndolos en el ArrayList meses.
     */
    private void instanciarMeses()
    {
        anio = Entrada.leerEntero("Introduce el a�o > ");
        meses.add(new Mes("Enero", 31));
        boolean bisiesto = Year.of(anio).isLeap();
        if (bisiesto) 
            meses.add(new Mes("Febreo", 29));
        else 
            meses.add(new Mes("Febreo", 28));
        
        meses.add(new Mes("Marzo", 31));
        meses.add(new Mes("Abril", 30));
        meses.add(new Mes("Mayo", 31));
        meses.add(new Mes("Junio", 30));
        meses.add(new Mes("Julio", 31));
        meses.add(new Mes("Agosto", 31));
        meses.add(new Mes("Septiembre", 30));
        meses.add(new Mes("Octubre", 31));
        meses.add(new Mes("Noviembre", 30));
        meses.add(new Mes("Diciembre", 31));
    }
    
//--------------------------------------------------------------------------
    /**
     * Crea un nuevo recordatorio o tarea.
     * @param eleccion Un entero que indica el tipo de evento que se desea 
crear (1.Recordatorio, 2.Tarea).
     * @throws InterruptedException Si ocurre un error mientras se espera la 
entrada del usuario.
     */
    public void crearRecordatorioTarea(int eleccion) throws 
InterruptedException
    {
        int mes = 0;
        do {            
            mes = Entrada.leerEntero("\s\s\sIntroduzca el numero del mes [1-12] > ");
        } while (mes < 1 || mes > 12);
        mes -= 1;
        meses.get(mes).nuevoRecordatorioTarea(eleccion, anio);
    }
    
//--------------------------------------------------------------------------
    /**
     * Borra un recordatorio o tarea.
     * @param eleccion Un entero que indica el tipo de evento que se desea 
borrar (3.Recordatorio, 4.Tarea).
     * @throws InterruptedException Si ocurre un error mientras se espera la 
entrada del usuario.
     */
    public void borrarRecordatorioTarea(int eleccion) throws 
InterruptedException
    {
        int mes = 0;
        do {            
            mes = Entrada.leerEntero("\s\s\sIntroduzca el numero del mes [1-12] > ");
        } while (mes < 1 || mes > 12);
        mes -= 1;
        meses.get(mes).eliminarRecordatorioTarea(eleccion);
    }
    
//--------------------------------------------------------------------------
    /**
     * Muestra la informaci�n de eventos seg�n la opci�n seleccionada por el 
usuario.
     * @param eleccion Elecci�n para mostrar informaci�n (5. Eventos de un d�a, 
6. Eventos de un mes, 7. Evento espec�fico).
     * @throws InterruptedException Si ocurre un error mientras se espera la 
entrada del usuario.
     */
    public void imprimirEventos(int eleccion) throws InterruptedException
    {
        int mes = 0;
        do {
            mes = Entrada.leerEntero("\s\s\sIntroduzca el numero del mes [1-12] > ");
        } while (mes < 1 || mes > 12);
        mes -= 1;
        meses.get(mes).verEventos(eleccion);
    }
    
//--------------------------------------------------------------------------
}//Class