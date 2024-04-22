package Agenda;

//API
import java.awt.*;
import java.io.*;
import java.util.*;
        /*TO DO:
            PRINCIPAL -> años, se puede comprobar con el ultimo dia del mes con local date y si es 28 o 29
            TAREA -> comprobar ultimo dia del mes en la comprobación 
            GENERAL -> pasar el try catch a entrada
            ENTRADA -> poner entrada de fecha
            
        */
public class Principal 
{
    Entrada entrada                 = new Entrada();
    Menu menu                       = new Menu();
    Recordatorio eventoRecordatorio = new Recordatorio();///////////////////////////////
    Tarea eventoTarea               = new Tarea();///////////////////////////////
    ArrayList <Mes> meses           = new ArrayList();
    //--------------------------------------------------------------------------
    public static void main(String[] args) throws AWTException, InterruptedException 
    {
        Principal principal = new Principal();

        principal.inicio();
        
    }//main
    //--------------------------------------------------------------------------
    private void inicio() throws AWTException, InterruptedException {
        menu();
    }//inicio
    //--------------------------------------------------------------------------
    private void menu() throws AWTException, InterruptedException {
        int respuesta = 0, limite = 4;
        while (respuesta != limite)
        {
            menu.menuPrincipal();
            respuesta = eleccion(respuesta,limite);
            switch (respuesta)
            {
                case 1:
                {
                    menu.limpiar();
                    menu.menuEventos();
                    limite = 12;
                    respuesta = eleccion(respuesta,limite);
                    eleccionMenuEventos(respuesta);
                    break;
                }
                case 2:
                {
                    menu.limpiar();
                    menu.menuContactos();
                    limite = 6;
                    respuesta = eleccion(respuesta,limite);
                    eleccionMenuContactos(respuesta);
                    break;
                }
                case 3:
                {
                    menu.limpiar();
                    menu.menuImprimirMes("--MENÚ DE IMPRESIÓN DE UN CALENDARIO MENSUAL");
                    limite = 13;
                    respuesta = eleccion(respuesta,limite);
                    eleccionMenuMes(respuesta);
                    break;
                }
                default : 
                {
                    menu.limpiar();
                    break;
                }
            }
        }
    }//menu
    //--------------------------------------------------------------------------
    private void eleccionMenuEventos(int respuesta)
    {
        switch (respuesta)
        {
            case 1  -> eventoRecordatorio.crearRecordatorio();
            case 2  -> eventoTarea.crearTarea(entrada);
            case 3  -> eventoRecordatorio.borrarRecordatorio();
            case 4  -> eventoTarea.borrarTarea();
            case 5  -> imprimirEventosDia();
            case 6  -> imprimirEventosMes();
            case 7  -> imprimirEventosMesDiaHora();
            case 8  -> leerFicheros();
            case 9  -> guardarFicheroAnio();
            case 10 -> guardarFicheroMes();
            case 11 -> guardarFicheroDia();
        }
    }//eleccionMenuEventos
    //--------------------------------------------------------------------------
    private void eleccionMenuContactos(int respuesta)
    {
        switch (respuesta)
        {
            case 1  -> leerContactos();
            case 2  -> crearContacto();
            case 3  -> listarContactos();
            case 4  -> buscarContacto();
            case 5  -> guardarCotacto();
        }
    }//eleccionMenuContactos
    //--------------------------------------------------------------------------
    private void eleccionMenuMes(int respuesta)
    {
        meses.get(respuesta-1).eventosDelMes();
    }//eleccionMenuMes
    //--------------------------------------------------------------------------
    private int eleccion(int respuesta, int limite)
    {
        do {
            try
            {
                respuesta = entrada.leerEntero("\n\s\s\sElija una opción > ");
                if (respuesta < 1 || respuesta > limite) 
                    System.out.println("OPCIÓN INVÁLIDA [1-"+ limite + "]");
            }catch (Exception e)
            {
                System.out.println("OPCIÓN INVÁLIDA [1-"+ limite + "]");
                entrada.limpiarBuffer();
                respuesta=0;
            }
            
        } while (respuesta <= 0 || respuesta > limite);
        return respuesta;
    }//eleccion
    //--------------------------------------------------------------------------
    
    
}
