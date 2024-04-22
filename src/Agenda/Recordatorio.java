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
    public void crearTarea(Entrada entrada)
    {
        int dia,mes;
        String urge;
        System.out.println("Creando recordatorio...");
        do{
            dia = entrada.leerEntero("Elija un dia > ");
        }while (!comprobacionDia(dia));
        do{
            menu.menuImprimirMes("--Elección de meses");
            mes = entrada.leerEntero("Elija un mes > ");
        }while (true);
        urge= entrada.leerCadena("El recordatorio es anual [s/n]");
        if urge.equalsIgnoreCase("s")
            recordatorio(dia,mes)
    }//crearRecordatorio
    //--------------------------------------------------------------------------
    private boolean comprobacionDia(int dia)
    {
        boolean comprobacion = false;
        if (dia >0 || dia <fecha.getMonth()) 

            comprobacion = true;
        return comprobacion;
    }
}