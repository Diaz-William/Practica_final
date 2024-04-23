package Agenda;

//API
import java.time.LocalTime;
import java.util.ArrayList;

public class Hora
{
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //ATRIBUTOS
    private ArrayList <Evento> eventos = new ArrayList();
    private String hora; 
    
    //--------------------------------------------------------------------------
    //CONSTRUCTOR
    public Hora(String hora) {
        this.hora = hora;
    }
    
    
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
    public void recordatorio(LocalTime hora,boolean todoElDia)
    {
        //eventos.add(new Recordatorio);
        System.out.println("Recordatorio creado" + todoElDia);
    }
    public void tarea(LocalTime hora,boolean todoElDia)
    {
        //eventos.add(new Tarea);
        System.out.println("Tarea creada" + todoElDia);
    }
}
