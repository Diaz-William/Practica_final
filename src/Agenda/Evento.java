package Agenda;

//API
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Esta clase abstracta representa un evento gen�rico dentro de la agenda.
 * Define atributos y m�todos comunes para todos los tipos de eventos (recordatorios y tareas).
 * Las clases concretas Recordatorio y Tarea heredan de esta clase abstracta 
 * para implementar sus caracter�sticas espec�ficas.
 */
public abstract class Evento 
{
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //ATRIBUTOS
    /**Un entero que representa el identificador �nico del evento.*/
    private int id;
    /**Una cadena de texto que representa el nombre del evento.*/
    private String nombre;
    /**Un objeto LocalDate que representa la fecha del evento.*/
    private LocalDate fecha;
    /**Un objeto LocalTime que representa la hora del evento (o la hora de inicio si es todo el d�a).*/
    private LocalTime hora;
    /** Un booleano que indica si el evento se realiza durante todo el d�a (true) o a una hora espec�fica (false).*/
    private boolean todoElDia = false;
    //--------------------------------------------------------------------------
    //CONSTRUCTOR
    /**
     * Crea un nuevo evento con los atributos especificados.
     * Solicita al usuario que introduzca el nombre y la descripci�n del evento.
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
     * Crea un nuevo evento con los atributos especificados y el indicador de todo el d�a.
     * Solicita al usuario que introduzca el nombre y la descripci�n del evento.
     *
     * @param id El ID del evento.
     * @param fecha La fecha del evento.
     * @param hora La hora del evento.
     * @param todoElDia Un indicador de si el evento abarca todo el d�a.
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
    public Evento(int id, LocalDate fecha, LocalTime hora, String nombre)
    {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.nombre = nombre;
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
    public String getNombre() {
        return nombre;
    }
    //--------------------------------------------------------------------------
    public LocalDate getFecha() {
        return fecha;
    }
    //--------------------------------------------------------------------------
    public LocalTime getHora() {
        return hora;
    }
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //METODOS
    /**
     * Solicita al usuario que ingrese el nombre y la descripci�n del evento.
     */
    private void pedirInfo ()
    {
        Entrada.limpiarBuffer();
        nombre = Entrada.leerCadena("Introduce el nombre del evento > ");
    }//pedirInfo
    //--------------------------------------------------------------------------
    /**
     * Muestra informaci�n detallada sobre el evento especificado.
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
            System.out.println("Recordatorio\s\s" + id + "  " + nombre);
            System.out.println("\t\tFecha " + fecha + " " + (hora != null ? "Hora " + hora : "") + (todoElDia ? "Todo el dia" : ""));
        }
        if (e instanceof Tarea)
        {
            System.out.println("Tarea\s\s" + id + "  " + nombre);
            System.out.println("\t\tFecha " + fecha + " " + (hora != null ? "Hora " + hora : "") + (todoElDia ? "Todo el dia" : ""));
        }
    }
    //--------------------------------------------------------------------------
    public String ficheroEvento(Evento e,String lineaFichero)
    {
        if (e  instanceof Recordatorio)
        {
            lineaFichero = (id +"|"+fecha+"|"+(hora != null ? "Hora" : "-")+"|"+nombre+"|"+(todoElDia ? "Todo el dia" : ""));
        }
        if (e instanceof Tarea)
        {
            lineaFichero = (id +"|"+fecha+"|"+(hora != null ? "Hora" : "-")+"|"+nombre+"|"+(todoElDia ? "Todo el dia" : ""));
        }
        return lineaFichero;
    }
    //--------------------------------------------------------------------------
    /*
    @Override
    public String toString() {
        return "Evento{" + "id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", hora=" + hora + ", todoElDia=" + todoElDia + '}';
    }
    */
}//Class