package Agenda;

//API
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Esta clase representa una hora específica dentro de un día. 
 * Se utiliza para almacenar y gestionar eventos (recordatorios y tareas) que ocurren en esa hora concreta.
 */
public class Hora
{
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //ATRIBUTOS
    /**Un objeto LocalTime que representa la hora del día.*/
    LocalTime hora;
    /**Una lista ArrayList de objetos Evento que almacena los eventos asociados a esta hora.*/
    private ArrayList <Evento> eventos = new ArrayList();
    //--------------------------------------------------------------------------
    //CONSTRUCTOR
    /**
     * Crea una nueva instancia de la clase Hora.
     */
    public Hora() {
    }
    //--------------------------------------------------------------------------
    //GETTERS & SETTERS 


    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //METODOS
    /**
     * Muestra información sobre todos los eventos asociados a esta hora.
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public void info() throws InterruptedException
    {
        for (Evento evento : eventos) {
            //evento.laChicha(evento);
            evento.infoEvento(evento);
        }
    }//info
    //--------------------------------------------------------------------------
    /**
     * Muestra información sobre todos los recordatorios asociados a esta hora.
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public void infoRecordatorio() throws InterruptedException
    {
        for (Evento evento : eventos) {
            if (evento instanceof Recordatorio)
            {
                //evento.laChicha(evento);
                evento.infoEvento(evento);
            }
        }
    }
    //--------------------------------------------------------------------------
    /**
     * Muestra información sobre todas las tareas asociadas a esta hora.
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public void infoTarea() throws InterruptedException
    {
        for (Evento evento : eventos) {
            if (evento instanceof Tarea)
            {
                //evento.laChicha(evento);
                evento.infoEvento(evento);
            }
        }
    }
    //--------------------------------------------------------------------------
    /**
     * Borra un evento existente (recordatorio o tarea) de la lista de eventos
     * asociados a esta hora en base a su identificador y tipo.
     * @param idBorrar El ID del evento a borrar.
     * @param tipo El tipo de evento a eliminar ("recordatorio" o "tarea").
     * @return Devuelve true si se elimina el evento, false en caso contrario.
     */
    public boolean borrarEvento(int idBorrar, String tipo)
    {
        boolean borrado = false;
        for (int i = 0; i < eventos.size(); i++)
        {
            if (tipo.equalsIgnoreCase("recordatorio"))
            {
                if (eventos.get(i).getId() == idBorrar && eventos.get(i) instanceof Recordatorio)
                {
                    borrado = true;
                    System.out.println("\s\s\sSe ha borrado el " + tipo + " con el id: " + idBorrar);
                    eventos.remove(i);
                }
            }
            else
            {
                if (eventos.get(i).getId() == idBorrar && eventos.get(i) instanceof Tarea)
                {
                    borrado = true;
                    System.out.println("\s\s\sSe ha borrado el " + tipo + " con el id: " + idBorrar);
                    eventos.remove(i);
                }
            }
        }
        
        return (borrado);
    }
    //--------------------------------------------------------------------------
    /**
     * Añade un nuevo recordatorio a la lista de eventos asociados a esta hora.
     * @param id El ID del recordatorio.
     * @param fecha La fecha del recordatorio.
     * @param hora La hora del recordatorio.
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public void recordatorio(int id, LocalDate fecha, LocalTime hora) throws InterruptedException
    {
        eventos.add(new Recordatorio(id, fecha, hora));
    }
    //--------------------------------------------------------------------------
    /**
     * Añade una nueva tarea a la lista de eventos asociados a esta hora.
     * @param id El ID de la tarea.
     * @param fecha La fecha de la tarea.
     * @param hora La hora de la tarea.
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public void tarea(int id, LocalDate fecha, LocalTime hora) throws InterruptedException
    {
        eventos.add(new Tarea(id, fecha, hora));
    }
    //--------------------------------------------------------------------------
    /**
     * Añade un nuevo evento (tarea o recordatorio) a la lista de eventos asociados a esta hora.
     *
     * @param id El ID del evento.
     * @param fecha La fecha del evento.
     * @param hora La hora del evento.
     * @param tipo El tipo de evento ("Tarea" o "Recordatorio").
     * @param nombre El nombre del evento.
     * @param adicional Un indicador adicional (urgencia o anualidad).
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public void aniadirEventoHora(int id, LocalDate fecha, LocalTime hora, String tipo, String nombre, boolean adicional) throws InterruptedException
    {
        if (tipo.equalsIgnoreCase("Tarea"))
        {
            eventos.add(new Tarea(id, fecha, hora, nombre, adicional));
        }
        else
        {
            eventos.add(new Recordatorio(id, fecha, hora, nombre, adicional));
        }
    }
    //--------------------------------------------------------------------------
    /**
     * Vacía la lista de eventos asociados a esta hora.
     */
    public void vaciarAgendaHora()
    {
        eventos.clear();
        /*for (int i = 0; i < eventos.size(); i++)
        {
            eventos.remove(i);
        }*/
    }
    //--------------------------------------------------------------------------
    /**
     * Guarda la información de los eventos asociados a esta hora en un archivo.
     * 
     * @param eleccion La opción seleccionada por el usuario.
     * @param nombreMes El nombre del mes.
     * @param dia El número del día.
     */
    public void guardarFicheroHora(int eleccion, String nombreMes, int dia)
    {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
        String info = null;
        for (Evento e : eventos) {
            if (e instanceof Tarea)
            {
                info = e.getFecha().format(formatoFecha) + "|" + e.getHora().format(formatoHora) + "|Tarea|" + e.getNombre() + "|" + (((Tarea)e).getUrgente() ? "Urgente" : "No urgente");
                GuardarEvento.guardarFichero(info, eleccion, nombreMes, dia);
            }
            else
            {
                info = e.getFecha().format(formatoFecha) + "|" + e.getHora().format(formatoHora) + "|Recordatorio|" + e.getNombre() + "|" + (((Recordatorio)e).getAnual() ? "Anual" : "No anual");
                GuardarEvento.guardarFichero(info, eleccion, nombreMes, dia);
            }
        }
    }
    //--------------------------------------------------------------------------
    /**
     * Verifica si hay eventos guardados.
     *
     * @return true si hay eventos registrados, de lo contrario false.
     */
    public boolean hayEventosHora()
    {
        boolean hay = false;
        for (Evento e : eventos) {
            if (e != null)
            {
                hay = true;
            }
        }
        return hay;
    }
    //--------------------------------------------------------------------------
}//Class