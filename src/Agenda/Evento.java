package Agenda;

//API
import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Evento 
{
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //ATRIBUTOS
    private int id;
    private String nombre;
    private String explicacion;
    private LocalDate fecha;
    private LocalTime hora;
    private boolean todoElDia;

    //--------------------------------------------------------------------------
    //CONSTRUCTOR
    public Evento(String nombre, String explicacion, LocalDate fecha, LocalTime hora, boolean todoElDia) {
        this.nombre = nombre;
        this.explicacion = explicacion;
        this.fecha = fecha;
        this.hora = hora;
        this.todoElDia = todoElDia;
    }
    
    //--------------------------------------------------------------------------
    //GETTERS & SETTERS 


    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //METODOS
    //El metodo recibe un objeto Evento
      //*******************************//
     // ari tiene que hacer la chicha //
    //*******************************//


}
