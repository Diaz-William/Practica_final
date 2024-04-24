package Agenda;

//API
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class Tarea extends Evento
{
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //ATRIBUTOS
    private boolean urgente;

    //--------------------------------------------------------------------------
    //CONSTRUCTOR

    public Tarea(int id, LocalDate fecha, LocalTime hora) {
        super(id, fecha, hora);
        pedirUrgente();
    }

    public Tarea(int id, LocalDate fecha, LocalTime hora, boolean todoElDia) {
        super(id, fecha, hora, todoElDia);
        pedirUrgente();
    }
    //--------------------------------------------------------------------------
    //GETTERS & SETTERS 


    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //METODOS
    /*public void crearTarea(Entrada entrada)
    {
        LocalDate fechaEvento;
        System.out.println("Creando tarea...");
        do{
            fechaEvento = entrada.leerFecha("Elija un dia > ");
        }while (!comprobacionDia(dia));

        
    }//crarTarea
    //--------------------------------------------------------------------------
    private boolean comprobacionDia(int dia)
    {
        boolean comprobacion = false;
        if (dia >0 || dia <fecha.getMonth()) 

            comprobacion = true;
        return comprobacion;
    }*/
    private void pedirUrgente()
    {
        String res = Entrada.leerCadena("La Tarea es urgente [s,si] > ");
        if (res.equalsIgnoreCase("s") || res.equalsIgnoreCase("si"))
        {
            urgente = true;
        }
        else
        {
            urgente = false;
        }
    }
}
