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
            //evento.laChicha(evento);
            evento.infoEvento(evento);
        }
    }//info
    //--------------------------------------------------------------------------
    public void infoRecordatorio()
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
    public void infoTarea()
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
    public void recordatorio(int id, LocalDate fecha, LocalTime hora) throws InterruptedException
    {
        eventos.add(new Recordatorio(id, fecha, hora));
    }
    public void tarea(int id, LocalDate fecha, LocalTime hora) throws InterruptedException
    {
        eventos.add(new Tarea(id, fecha, hora));
    }
    //--------------------------------------------------------------------------
}//Class