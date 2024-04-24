package Agenda;

import java.time.LocalDate;
import java.time.LocalTime;

public class Recordatorio extends Evento
{
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //ATRIBUTOS
    private boolean anual;

    //--------------------------------------------------------------------------
    //CONSTRUCTOR

    public Recordatorio(int id, LocalDate fecha, LocalTime hora) {
        super(id, fecha, hora);
        pedirAnual();
    }

    public Recordatorio(int id, LocalDate fecha, LocalTime hora, boolean todoElDia) {
        super(id, fecha, hora, todoElDia);
        pedirAnual();
    }
    //--------------------------------------------------------------------------
    //GETTERS & SETTERS 


    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //METODOS 
    private void pedirAnual()
    {
        String res = Entrada.leerCadena("El Recordatorio es anual [s,si] > ");
        if (res.equalsIgnoreCase("s") || res.equalsIgnoreCase("si"))
        {
            anual = true;
        }
        else
        {
            anual = false;
        }
    }
}