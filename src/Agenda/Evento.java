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
    /**Una cadena de texto que describe el evento en detalle.*/
    private String explicacion;
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
    public Evento(int id, LocalDate fecha, LocalTime hora) {
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
    public Evento(int id, LocalDate fecha, LocalTime hora, boolean todoElDia) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.todoElDia = todoElDia;
        pedirInfo();
    }
    //--------------------------------------------------------------------------
    //GETTERS & SETTERS 
    public int getId()
    {
        return id;
    }
    //--------------------------------------------------------------------------
    public boolean isTodoElDia()
    {
        return todoElDia;
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
        nombre = Entrada.leerCadena("Introduce el nombre del evento > ");
        //Entrada.limpiarBuffer();
        explicacion = Entrada.leerCadena("Introduce una explcacion del evento > ");
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
      //*******************************//
     /**
      * En el ternario de hora comprobamos si tiene o no
      * En el ternario de todoElDia realizamos el mismo proceso
      */
    //*******************************//
        if (e  instanceof Recordatorio && e.isTodoElDia())
        {
            System.out.println("Recordatorio\s\s" + id + " " + nombre);
            System.out.println("\t\tFecha " + fecha + " " + (hora != null ? "Hora" : "") + (todoElDia ? "Todo el dia" : ""));
            System.out.println("\t\t" + explicacion);
        }
        
        if (e instanceof Tarea && e.isTodoElDia())
        {
            System.out.println("Tarea\s\s" + id + " " + nombre);
            System.out.println("\t\tFecha " + fecha + " " + (hora != null ? "Hora" : "") + (todoElDia ? "Todo el dia" : ""));
            System.out.println("\t\t" + explicacion);
        }
        //Entrada.esperarEnter();
    }
    //--------------------------------------------------------------------------
}//Class