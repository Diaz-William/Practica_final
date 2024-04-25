package Agenda;

//API
import java.awt.*;
import java.io.*;
import java.time.Year;
import java.util.*;

/*TO DO:
    PRINCIPAL -> años, se puede comprobar con el ultimo dia del mes con local date y si es 28 o 29
    TAREA -> comprobar ultimo dia del mes en la comprobación 
    GENERAL -> pasar el try catch a entrada
    ENTRADA -> poner entrada de fecha

*/

public class Principal 
{
    //public enum TipoEvento {TAREA, RECORDATORIO}
    //--------------------------------------------------------------------------
    private Menu menu                       = new Menu();
    private int anio;
    private ArrayList <Mes> meses           = new ArrayList();
    //--------------------------------------------------------------------------
    public static void main(String[] args) throws AWTException, InterruptedException 
    {
        Principal principal = new Principal();

        principal.inicio();
        
    }//main
    //--------------------------------------------------------------------------
    private void inicio() throws AWTException, InterruptedException {
        instanciarMeses();
        menu();
    }//inicio
    //--------------------------------------------------------------------------
    private void instanciarMeses()
    {
        anio = Entrada.leerEntero("Introduce el año > ");
        meses.add(new Mes("Enero", 31));
        boolean bisiesto = Year.of(anio).isLeap();
        if (bisiesto) 
            meses.add(new Mes("Febreo", 29));
        else 
            meses.add(new Mes("Febreo", 28));
        
        meses.add(new Mes("Marzo", 31));
        meses.add(new Mes("Abril", 30));
        meses.add(new Mes("Mayo", 31));
        meses.add(new Mes("Junio", 30));
        meses.add(new Mes("Julio", 31));
        meses.add(new Mes("Agosto", 31));
        meses.add(new Mes("Septiembre", 30));
        meses.add(new Mes("Octubre", 31));
        meses.add(new Mes("Noviembre", 30));
        meses.add(new Mes("Diciembre", 31));
    }
    //--------------------------------------------------------------------------
    private void menu() throws AWTException, InterruptedException {
        int respuesta = 0, limite = 4;
        while (respuesta != limite)
        {
            menu.limpiar();
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
    private void eleccionMenuEventos(int respuesta) throws InterruptedException
    {
        switch (respuesta)
        {
            case 1  -> crearRecordatorioTarea(respuesta);
            case 2  -> crearRecordatorioTarea(respuesta);
            case 3  -> borrarRecordatorioTarea(respuesta);
            case 4  -> borrarRecordatorioTarea(respuesta);
            /*case 5  -> imprimirEventosDia();
            case 6  -> imprimirEventosMes();
            case 7  -> imprimirEventosMesDiaHora();
            case 8  -> leerFicheros();
            case 9  -> guardarFicheroAnio();
            case 10 -> guardarFicheroMes();
            case 11 -> guardarFicheroDia();*/
        }
    }//eleccionMenuEventos
    //--------------------------------------------------------------------------
    private void eleccionMenuContactos(int respuesta)
    {
        /*switch (respuesta)
        {
            case 1  -> leerContactos();
            case 2  -> crearContacto();
            case 3  -> listarContactos();
            case 4  -> buscarContacto();
            case 5  -> guardarCotacto();
        }*/
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
            respuesta = Entrada.leerEntero("\n\s\s\sElija una opción > ");
            if (respuesta < 1 || respuesta > limite) 
                System.out.print("\s\s\sOPCIÓN INVÁLIDA [1-"+ limite + "]");

        } while (respuesta <= 0 || respuesta > limite);
        return respuesta;
    }//eleccion
    //--------------------------------------------------------------------------
    private void crearRecordatorioTarea(int eleccion)
    {
        int mes = 0;
        do {            
            mes = Entrada.leerEntero("\s\s\sIntroduzca el numero del mes [1-12] > ");
        } while (mes < 1 || mes > 12);
        mes -= 1;
        meses.get(mes).nuevoRecordatorioTarea(eleccion, anio);
    }
    //--------------------------------------------------------------------------
    private void borrarRecordatorioTarea(int eleccion) throws InterruptedException
    {
        int mes = 0;
        do {            
            mes = Entrada.leerEntero("\s\s\sIntroduzca el numero del mes [1-12] > ");
        } while (mes < 1 || mes > 12);
        mes -= 1;
        meses.get(mes).eliminarRecordatorioTarea(eleccion);
    }
    //--------------------------------------------------------------------------
}//Class
