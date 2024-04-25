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

    public Recordatorio(int id, LocalDate fecha, LocalTime hora) throws InterruptedException {
        super(id, fecha, hora);
        pedirAnual();
    }

    public Recordatorio(int id, LocalDate fecha, LocalTime hora, boolean todoElDia) throws InterruptedException {
        super(id, fecha, hora, todoElDia);
        pedirAnual();
    }
    //--------------------------------------------------------------------------
    //GETTERS & SETTERS 


    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //METODOS 
    private void pedirAnual() throws InterruptedException
    {
        String res = Entrada.leerCadena("El Recordatorio es anual [s,si] > ");
        if (res.equalsIgnoreCase("s") || res.equalsIgnoreCase("si"))
        {
            anual = true;
            System.out.println("El recordatorio es anual");
        }
        else
        {
            anual = false;
            System.out.println("El recordatorio no es anual");
        }
        Thread.sleep(3000);//Esperar 3 segundos
    }
    //--------------------------------------------------------------------------
}//Class