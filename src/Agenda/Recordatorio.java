package Agenda;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Esta clase hereda de la clase Evento y representa un evento de tipo recordatorio. 
 * Almacena información adicional sobre si el recordatorio es anual o no anual.
 */
public class Recordatorio extends Evento
{
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //ATRIBUTOS
    /**Un booleano que indica si el recordatorio es anual (true) o no anual (false).*/
    private boolean anual;

    //--------------------------------------------------------------------------
    //CONSTRUCTOR
    /**
     * Crea un nuevo recordatorio con los atributos especificados y solicita al usuario si es anual.
     * @param id El id del recordatorio.
     * @param fecha La fecha del recordatorio.
     * @param hora La hora del recordatorio.
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public Recordatorio(int id, LocalDate fecha, LocalTime hora) throws InterruptedException {
        super(id, fecha, hora);
        pedirAnual();
    }
    //--------------------------------------------------------------------------
    /**
     * Crea un nuevo recordatorio con los atributos especificados y el indicador de todo el día, y solicita al usuario si es anual.
     * @param id El id del recordatorio.
     * @param fecha La fecha del recordatorio.
     * @param hora La hora del recordatorio.
     * @param todoElDia Un booleano que indica si el recordatorio es para todo el día (true).
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public Recordatorio(int id, LocalDate fecha, LocalTime hora, boolean todoElDia) throws InterruptedException {
        super(id, fecha, hora, todoElDia);
        pedirAnual();
    }
    //--------------------------------------------------------------------------
    //GETTERS & SETTERS 


    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //METODOS
    /**
     * Solicita al usuario si el recordatorio es anual o no anual y actualiza el atributo anual en consecuencia.
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    private void pedirAnual() throws InterruptedException
    {
        String res = Entrada.leerCadena("El Recordatorio es anual [s,si/n,no] > ");
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