package Agenda;

//API
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Esta clase abstracta representa un evento genérico dentro de la agenda.
 * Define atributos y métodos comunes para todos los tipos de eventos (recordatorios y tareas).
 * Las clases concretas Recordatorio y Tarea heredan de esta clase abstracta 
 * para implementar sus características específicas.
 */
public abstract class Evento 
{
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //ATRIBUTOS
    /**Un entero que representa el identificador único del evento.*/
    private int id;
    /**Una cadena de texto que representa el nombre del evento.*/
    private String nombre;
    /**Un objeto LocalDate que representa la fecha del evento.*/
    private LocalDate fecha;
    /**Un objeto LocalTime que representa la hora del evento (o la hora de inicio si es todo el día).*/
    private LocalTime hora;
    /** Un booleano que indica si el evento se realiza durante todo el día (true) o a una hora específica (false).*/
    private boolean todoElDia = false;
    //--------------------------------------------------------------------------
    //CONSTRUCTOR
    /**
     * Crea un nuevo evento con los atributos especificados.
     * Solicita al usuario que introduzca el nombre y la descripción del evento.
     *
     * @param id El ID del evento.
     * @param fecha La fecha del evento.
     * @param hora La hora del evento.
     */
    public Evento(int id, LocalDate fecha, LocalTime hora)
    {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        pedirInfo();
    }
    //--------------------------------------------------------------------------
    /**
     * Crea un nuevo evento con los atributos especificados y el indicador de todo el día.
     * Solicita al usuario que introduzca el nombre y la descripción del evento.
     *
     * @param id El ID del evento.
     * @param fecha La fecha del evento.
     * @param hora La hora del evento.
     * @param todoElDia Un indicador de si el evento abarca todo el día.
     */
    public Evento(int id, LocalDate fecha, LocalTime hora, boolean todoElDia)
    {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.todoElDia = todoElDia;
        pedirInfo();
    }
    //--------------------------------------------------------------------------
    /**
     * Crea un nuevo evento con los atributos especificados.
     *
     * @param id El ID del evento.
     * @param fecha La fecha del evento.
     * @param hora La hora del evento.
     * @param nombre El nombre del evento.
     */
    public Evento(int id, LocalDate fecha, LocalTime hora, String nombre)
    {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.nombre = nombre;
    }
    //--------------------------------------------------------------------------
    /**
     * Crea un nuevo evento con los atributos especificados y el indicador de todo el día.
     *
     * @param id El ID del evento.
     * @param fecha La fecha del evento.
     * @param todoElDia Un indicador de si el evento abarca todo el día.
     * @param nombre El nombre del evento.
     */
    public Evento(int id, LocalDate fecha, boolean todoElDia, String nombre)
    {
        this.id = id;
        this.fecha = fecha;
        this.todoElDia = todoElDia;
        this.nombre = nombre;
    }
    //--------------------------------------------------------------------------
    //GETTERS & SETTERS 

    /**
     * metodo para obtener el ID del evento.
     * @return id el id del evento.
     */
    public int getId()
    {
        return id;
    }
    //--------------------------------------------------------------------------

    /**
     * metodo para obtener si el evento es para todo el día o no .
     * @return todoElDia booleano que indica si el evento es para todo el dia.
     */
    public boolean getTodoElDia()
    {
        return todoElDia;
    }
    //--------------------------------------------------------------------------

    /**
     * metodo para obtener el nombre del evento.
     * @return nombre el nombre del evento.
     */
    public String getNombre() {
        return nombre;
    }
    //--------------------------------------------------------------------------

    /**
     * metodo para obtener la fecha del evento.
     * @return fecha la fecha en la que seguarda el evento.
     */
    public LocalDate getFecha() {
        return fecha;
    }
    //--------------------------------------------------------------------------

    /**
     * metodo para obtener la hora del evento.
     * @return hora la hora en la que seguarda el evento.
     */
    public LocalTime getHora() {
        return hora;
    }
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //METODOS
    /**
     * Solicita al usuario que ingrese el nombre y la descripción del evento.
     */
    private void pedirInfo ()
    {
        Entrada.limpiarBuffer();
        nombre = Entrada.leerCadena("\s\s\sIntroduce el nombre del evento > ");
    }//pedirInfo
    //--------------------------------------------------------------------------
    /**
     * Muestra información detallada sobre el evento especificado.
     * Distingue entre recordatorios y tareas.
     *
     * @param e El evento.
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public void infoEvento(Evento e) throws InterruptedException
    {
       //El metodo recibe un objeto Evento

     /**
      * En el ternario de hora comprobamos si tiene o no
      * En el ternario de todoElDia realizamos el mismo proceso
      */
        if (e  instanceof Recordatorio)
        {
            System.out.println("\s\s\sRecordatorio\s\s" + id + "  " + nombre);
            System.out.println("\t\tFecha " + fecha + " " + (hora != null ? "Hora " + hora : "") + (todoElDia ? "Todo el dia" : "") + "\n");
        }
        if (e instanceof Tarea)
        {
            System.out.println("\s\s\sTarea\s\s" + id + "  " + nombre);
            System.out.println("\t\tFecha " + fecha + " " + (hora != null ? "Hora " + hora : "") + (todoElDia ? "Todo el dia" : "") + "\n");
        }
    }
    //--------------------------------------------------------------------------
}//Class