package Agenda;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Principal 
{
    Entrada entrada = new Entrada();
    Menu menu = new Menu();
    ArrayList <Mes> meses = new ArrayList();
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
            respuesta = leerInt(respuesta,limite);
            switch (respuesta)
            {
                case 1:
                {
                    menu.limpiar();
                    menu.menuEventos();
                    limite = 12;
                    respuesta = leerInt(respuesta,limite);
                    eleccionMenuEventos(respuesta);
                    break;
                }
                case 2:
                {
                    menu.limpiar();
                    menu.menuContactos();
                    limite = 6;
                    respuesta = leerInt(respuesta,limite);
                    eleccionMenuContactos(respuesta);
                    break;
                }
                case 3:
                {
                    menu.limpiar();
                    menu.menuImprimirMes();
                    limite = 13;
                    respuesta = leerInt(respuesta,limite);
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
            case 1  -> crearRecordatorio();
            case 2  -> crearTarea();
            case 3  -> borrarRecordatorio();
            case 4  -> borrarTarea();
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
    private int leerInt(int respuesta, int limite)
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
    }//leerInt
    //--------------------------------------------------------------------------
    
    
}
