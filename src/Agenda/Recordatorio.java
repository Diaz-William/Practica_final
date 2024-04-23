package Agenda;

import java.time.LocalDate;
import java.time.LocalTime;

public class Recordatorio extends Evento
{
    Menu menu = new Menu();
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //ATRIBUTOS
    private boolean anual;

    //--------------------------------------------------------------------------
    //CONSTRUCTOR

    public Recordatorio(String nombre, String explicacion, LocalDate fecha, LocalTime hora, boolean todoElDia) {
        super(nombre, explicacion, fecha, hora, todoElDia);
    }
    
    
    //--------------------------------------------------------------------------
    //GETTERS & SETTERS 


    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //METODOS 

}