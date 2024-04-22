package Agenda;

//API
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class Tarea extends Evento
{
    Menu menu = new Menu();

    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //ATRIBUTOS
    private boolean urgente;

    //--------------------------------------------------------------------------
    //CONSTRUCTOR

    public Tarea(String nombre, String explicacion, LocalDate fecha, LocalTime hora, boolean todoElDia) {
        super(nombre, explicacion, fecha, hora, todoElDia);
    }
    
    
    //--------------------------------------------------------------------------
    //GETTERS & SETTERS 


    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //METODOS
    public void crearTarea(Entrada entrada)
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
    }
}
