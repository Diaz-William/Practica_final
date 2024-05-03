package Agenda;

//API
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

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

    @Override
    public String toString() {return "Hora{" + "hora=" + hora + ", eventos=" + eventos + '}';
}
    
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
                    System.out.println("Se ha borrado el " + tipo + " con el id: " + idBorrar);
                    eventos.remove(i);
                }
            }
            else
            {
                if (eventos.get(i).getId() == idBorrar && eventos.get(i) instanceof Tarea)
                {
                    borrado = true;
                    System.out.println("Se ha borrado el " + tipo + " con el id: " + idBorrar);
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
    public String ficheroHora(String lineaFichero) throws InterruptedException
    {
        for (Evento evento : eventos) {
            if (evento instanceof Recordatorio)
            {
                //evento.laChicha(evento);
                lineaFichero = evento.ficheroEvento(evento, lineaFichero);
            }
            if (evento instanceof Tarea)
            {
                //evento.laChicha(evento);
                lineaFichero = evento.ficheroEvento(evento,lineaFichero);
            }
        }
        return lineaFichero;
    }
    //--------------------------------------------------------------------------
    public void aniadirEventoHora(LocalDate fecha, LocalTime hora, String tipo, String nombre, boolean adicional)
    {
        
    }
    //--------------------------------------------------------------------------
}//Class