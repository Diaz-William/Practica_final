package Agenda;

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
    public void recordatorio(LocalTime hora)
    {
        eventos.add(new Recordatorio);
    }
}
