package Agenda;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Principal 
{
    Entrada entrada = new Entrada();
    Menu menu = new Menu();
    //--------------------------------------------------------------------------
    public static void main(String[] args) throws AWTException, InterruptedException 
    {
        Principal principal = new Principal();
        principal.inicio();
        
    }//main
    //--------------------------------------------------------------------------
    public void inicio() throws AWTException, InterruptedException {
        int respuesta = 0;
        menu.menuPrincipal();
        respuesta = leerInt(respuesta,4);
        menu.limpiar();
        menu.menuEventos();
        respuesta = leerInt(respuesta,12);
        menu.limpiar();
        menu.menuContactos();
        respuesta = leerInt(respuesta,6);
        menu.limpiar();
        menu.menuImprimirMes();
        respuesta = leerInt(respuesta,13);
        menu.limpiar();
    }
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
    }
}
