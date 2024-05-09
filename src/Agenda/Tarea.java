package Agenda;

//API
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Esta clase hereda de la clase Evento y representa un evento de tipo tarea.
 * Almacena información adicional sobre si la tarea es urgente o no.
 */
public class Tarea extends Evento
{
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //ATRIBUTOS
    /**Un booleano que indica si la tarea es urgente (true) o no urgente (false).*/
    private boolean urgente;
    //--------------------------------------------------------------------------
    //CONSTRUCTOR
    /**
     * Crea una nueva tarea con los atributos especificados y solicita al usuario si es urgente.
     * @param id El id de la tarea.
     * @param fecha La fecha de la tarea.
     * @param hora La hora de la tarea.
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public Tarea(int id, LocalDate fecha, LocalTime hora) throws InterruptedException
    {
        super(id, fecha, hora);
        pedirUrgente();
    }
    //--------------------------------------------------------------------------
    /**
     * Crea una nueva tarea con los atributos especificados y el indicador de todo el día, y solicita al usuario si es urgente.
     * @param id El id de la tarea.
     * @param fecha La fecha de la tarea.
     * @param hora La hora de la tarea.
     * @param todoElDia Un booleano que indica si la tarea es para todo el día (true).
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public Tarea(int id, LocalDate fecha, LocalTime hora, boolean todoElDia) throws InterruptedException
    {
        super(id, fecha, hora, todoElDia);
        pedirUrgente();
    }
    //--------------------------------------------------------------------------
    /**
     * Crea una nueva tarea con los atributos especificados y el nombre, y el estado de urgencia de la tarea.
     *
     * @param id El id de la tarea.
     * @param fecha La fecha de la tarea.
     * @param hora La hora de la tarea.
     * @param nombre El nombre de la tarea.
     * @param urgente El estado de urgencia de la tarea.
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public Tarea(int id, LocalDate fecha, LocalTime hora, String nombre, boolean urgente) throws InterruptedException
    {
        super(id, fecha, hora, nombre);
        this.urgente = urgente;
    }
    //--------------------------------------------------------------------------
    /**
     * Crea una nueva tarea con los atributos especificados y el nombre, y el estado de urgencia de la tarea.
     *
     * @param id El id de la tarea.
     * @param fecha La fecha de la tarea.
     * @param todoElDia Un booleano que indica si la tarea es para todo el día (true).
     * @param nombre El nombre de la tarea.
     * @param urgente El estado de urgencia de la tarea.
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public Tarea(int id, LocalDate fecha, boolean todoElDia, String nombre, boolean urgente) throws InterruptedException
    {
        super(id, fecha, todoElDia, nombre);
        this.urgente = urgente;
    }
    //--------------------------------------------------------------------------
    //GETTERS & SETTERS 

    /**
     * metodo para obtener si la tarea es urgente o no.
     * @return urgente booleano que indica la urgencia de la tarea.
     */
    public boolean getUrgente()
    {
        return urgente;
    }

    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //METODOS
    /**
     * Solicita al usuario si la tarea es urgente o no urgente y actualiza el atributo urgente en consecuencia.
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    private void pedirUrgente() throws InterruptedException
    {
        String res = Entrada.leerCadena("La Tarea es urgente [s,si/n,no] > ");
        if (res.equalsIgnoreCase("s") || res.equalsIgnoreCase("si"))
        {
            urgente = true;
            System.out.println("La tarea es urgente");
        }
        else
        {
            urgente = false;
            System.out.println("La tarea no es urgente");
        }
        Thread.sleep(3000);//Esperar 3 segundos
    }
    //--------------------------------------------------------------------------
}//Class