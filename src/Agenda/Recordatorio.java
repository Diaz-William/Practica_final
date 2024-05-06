package Agenda;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Esta clase hereda de la clase Evento y representa un evento de tipo recordatorio. 
 * Almacena información adicional sobre si el recordatorio es anual o no anual.
 */
public class Recordatorio extends Evento
{
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //ATRIBUTOS
    /**Un booleano que indica si el recordatorio es anual (true) o no anual (false).*/
    private boolean anual;
    //--------------------------------------------------------------------------
    //CONSTRUCTOR
    /**
     * Crea un nuevo recordatorio con los atributos especificados y solicita al usuario si es anual.
     * @param id El id del recordatorio.
     * @param fecha La fecha del recordatorio.
     * @param hora La hora del recordatorio.
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public Recordatorio(int id, LocalDate fecha, LocalTime hora) throws InterruptedException
    {
        super(id, fecha, hora);
        pedirAnual();
    }
    //--------------------------------------------------------------------------
    /**
     * Crea un nuevo recordatorio con los atributos especificados y el indicador de todo el día, y solicita al usuario si es anual.
     * @param id El id del recordatorio.
     * @param fecha La fecha del recordatorio.
     * @param hora La hora del recordatorio.
     * @param todoElDia Un booleano que indica si el recordatorio es para todo el día (true).
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public Recordatorio(int id, LocalDate fecha, LocalTime hora, boolean todoElDia) throws InterruptedException
    {
        super(id, fecha, hora, todoElDia);
        pedirAnual();
    }
    //--------------------------------------------------------------------------
    /**
     * Crea un nuevo recordatorio con los atributos especificados y el nombre, y el estado de anualidad del recordatorio.
     *
     * @param id El id del recordatorio.
     * @param fecha La fecha del recordatorio.
     * @param hora La hora del recordatorio.
     * @param nombre El nombre del recordatorio.
     * @param anual El estado de anualidad del recordatorio.
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public Recordatorio(int id, LocalDate fecha, LocalTime hora, String nombre, boolean anual) throws InterruptedException
    {
        super(id, fecha, hora, nombre);
        this.anual = anual;
    }
    //--------------------------------------------------------------------------
    /**
     * Crea un nuevo recordatorio con los atributos especificados y el nombre, y el estado de anualidad del recordatorio.
     *
     * @param id El id del recordatorio.
     * @param fecha La fecha del recordatorio.
     * @param todoElDia Un booleano que indica si el recordatorio es para todo el día (true).
     * @param nombre El nombre del recordatorio.
     * @param anual El estado de anualidad del recordatorio.
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public Recordatorio(int id, LocalDate fecha, boolean todoElDia, String nombre, boolean anual) throws InterruptedException
    {
        super(id, fecha, todoElDia, nombre);
        this.anual = anual;
    }
    //--------------------------------------------------------------------------
    //GETTERS & SETTERS 
    public boolean getAnual()
    {
        return anual;
    }
    
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //METODOS
    /**
     * Solicita al usuario si el recordatorio es anual o no anual y actualiza el atributo anual en consecuencia.
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    private void pedirAnual() throws InterruptedException
    {
        String res = Entrada.leerCadena("El Recordatorio es anual [s,si/n,no] > ");
        if (res.equalsIgnoreCase("s") || res.equalsIgnoreCase("si"))
        {
            anual = true;
            System.out.println("El recordatorio es anual");
        }
        else
        {
            anual = false;
            System.out.println("El recordatorio no es anual");
        }
        
        Thread.sleep(2000);//Esperar 2 segundos
    }
    //--------------------------------------------------------------------------
}//Class