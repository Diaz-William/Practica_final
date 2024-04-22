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
    private void menu() throws AWTException, InterruptedException {
        int respuesta = 0, limite = 4;
        menu.menuPrincipal();
        respuesta = leerInt(respuesta,limite);
        while (respuesta != limite)
        {
            switch (respuesta)
            {
                case 1:
                {
                    menu.limpiar();
                    menu.menuEventos();
                    limite = 12;
                    respuesta = leerInt(respuesta,limite);
                    break;
                }
                case 2:
                {
                    menu.limpiar();
                    menu.menuContactos();
                    limite = 6;
                    respuesta = leerInt(respuesta,limite);
                    break;
                }
                case 3:
                {
                    menu.limpiar();
                    menu.menuImprimirMes();
                    limite = 13;
                    respuesta = leerInt(respuesta,limite);
                    break;
                }
                default : 
                {
                    menu.limpiar();
                    break;
                }
            }
        }
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
