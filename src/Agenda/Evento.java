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
    private boolean todoElDia = false;

    //--------------------------------------------------------------------------
    //CONSTRUCTOR
    public Evento(int id, LocalDate fecha, LocalTime hora) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        pedirInfo();
    }
    
    public Evento(int id, LocalDate fecha, LocalTime hora, boolean todoElDia) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.todoElDia = todoElDia;
        pedirInfo();
    }
    //--------------------------------------------------------------------------
    //GETTERS & SETTERS 
    public int getId() {
        return id;
    }
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //METODOS
    
    private void pedirInfo ()
    {
        nombre = Entrada.leerCadena("Introduce el nombre del evento > ");
        Entrada.limpiarBuffer();
        explicacion = Entrada.leerCadena("Introduce una explcacion del evento > ");
    }//pedirInfo
    //--------------------------------------------------------------------------
    public void infoEvento(Evento e)
    {
       //El metodo recibe un objeto Evento
      //*******************************//
     // ari tiene que hacer la chicha //
    //*******************************//
        if (e  instanceof Recordatorio)
        {
            System.out.println("\"Recordatorio{\" + \"id=\" + id + \", nombre=\" + nombre + \", explicacion=\" + explicacion + \", fecha=\" + fecha + \", hora=\" + hora + \", todoElDia=\" + todoElDia + '}'");
        }
        else
        {
            System.out.println("\"Tarea{\" + \"id=\" + id + \", nombre=\" + nombre + \", explicacion=\" + explicacion + \", fecha=\" + fecha + \", hora=\" + hora + \", todoElDia=\" + todoElDia + '}'");
        }
    }
    //--------------------------------------------------------------------------

    /*@Override
    public String toString() {
        return "Evento{" + "id=" + id + ", nombre=" + nombre + ", explicacion=" + explicacion + ", fecha=" + fecha + ", hora=" + hora + ", todoElDia=" + todoElDia + '}';
    }*/
    
    
}//Class