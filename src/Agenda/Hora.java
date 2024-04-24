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
            if (evento != null)
            {
                //evento.laChicha(evento)
            }
        }
    }//info
    //--------------------------------------------------------------------------
    public void recordatorio(int id, LocalDate fecha, LocalTime hora, boolean todoElDia)
    {
        if (todoElDia)
        {
            eventos.add(new Recordatorio(id, fecha, hora));
        }
        else
        {
            eventos.add(new Recordatorio(id, fecha, hora, true));
        }
    }
    public void tarea(int id, LocalDate fecha, LocalTime hora, boolean todoElDia)
    {
        if (todoElDia)
        {
            eventos.add(new Tarea(id, fecha, hora));
        }
        else
        {
            eventos.add(new Tarea(id, fecha, hora, true));
        }
    }
}
