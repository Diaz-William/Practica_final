package Agenda;

//API
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Hora
{
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //ATRIBUTOS
    private ArrayList <Evento> eventos = new ArrayList();
    
    //--------------------------------------------------------------------------
    //CONSTRUCTOR
    public Hora() {}
    
    
    //--------------------------------------------------------------------------
    //GETTERS & SETTERS 


    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //METODOS
    public void info()
    {
        for (Evento evento : eventos) {
            //evento.laChicha(evento)
        }
    }//info
    //--------------------------------------------------------------------------
    public void infoRecordatorio()
    {
        for (Evento evento : eventos) {
            if (evento instanceof Recordatorio)
            {
                //evento.laChicha(evento)
            }
        }
    }
    //--------------------------------------------------------------------------
    public void recordatorio(int id, LocalDate fecha, LocalTime hora)
    {
        eventos.add(new Recordatorio(id, fecha, hora));
    }
    public void tarea(int id, LocalDate fecha, LocalTime hora)
    {
        eventos.add(new Tarea(id, fecha, hora));
    }
}
