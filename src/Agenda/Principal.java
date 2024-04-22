package Agenda;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) 
    {
        int respuesta = 100;
        menuPrincipal();
        respuesta=leerInt(respuesta,4);
        menuEventos();
        respuesta=leerInt(respuesta,12);
        menuContactos();
        respuesta=leerInt(respuesta,6);
        menuImprimirMes();
        respuesta=leerInt(respuesta,13);
    }//main
    //--------------------------------------------------------------------------
    static void menuPrincipal()
    {
        System.out.println("--MENÚ PRINCIPAL--");
        System.out.println("\s\s1)Menú de Eventos y Tareas");
        System.out.println("\s\s2)Menú de Lista de contactos");
        System.out.println("\s\s3)Menú para Imprimir los días de calendario de un mes");
        System.out.println("\s\s4)//Salir//");
    }//menuPrincipal
    //--------------------------------------------------------------------------
    static void menuEventos()
    {
        System.out.println("--MENÚ DE EVENTOS Y TAREAS--");
        System.out.println("\s\s1)Crear un evento recordatorio");
        System.out.println("\s\s2)Crear un evento tarea");
        System.out.println("\s\s3)Borrar un evento recordatorio");
        System.out.println("\s\s4)Borrar un evento tarea");
        System.out.println("\s\s5)Imprimir todos los eventos de un día determinado");
        System.out.println("\s\s6)Imprimir todos los eventos de un mes determinado");
        System.out.println("\s\s7)Imprimir un evento por mes, día y hora");
        System.out.println("\s\s8)Leer de un fichero todos los eventos de un año");
        System.out.println("\s\s9)Guardar de un fichero de texto todos los eventos de un año");
        System.out.println("\s\s10)Guardar en un fichero de texto todos los eventos de un mes");
        System.out.println("\s\s11)Guardar en un fichero de texto todos los eventos de un día");
        System.out.println("\s\s12)//Salir//");
    }//menuEventos
    //--------------------------------------------------------------------------
    static void menuContactos()
    {
        System.out.println("--MENÚ DE LISTA DE CONTACTOS");
        System.out.println("\s\s1)Leer contactos");
        System.out.println("\s\s2)Crear un contacto nuevo");
        System.out.println("\s\s3)Listar todos los contactos");
        System.out.println("\s\s4)Buscar un contacto");
        System.out.println("\s\s5)Guardar contactos");
        System.out.println("\s\s6)//Salir//");  
    }//menuContactos
    //--------------------------------------------------------------------------
    static void menuImprimirMes()
    {
        System.out.println("--MENÚ DE IMPRESIÓN DE UN CALENDARIO MENSUAL ");
        System.out.println("\s\s\s\s1)ENERO");
        System.out.println("\s\s\s\s2)FEBRERO");
        System.out.println("\s\s\s\s3)MARZO");
        System.out.println("\s\s\s\s4)ABRIL");
        System.out.println("\s\s\s\s5)MAYO");
        System.out.println("\s\s\s\s6)JUNIO");
        System.out.println("\s\s\s\s7)JULIO");
        System.out.println("\s\s\s\s8)AGOSTO");
        System.out.println("\s\s\s\s9)SEPTIEMBRE");
        System.out.println("\s\s\s\s10)OCTUBRE");
        System.out.println("\s\s\s\s11)NOVIEMBRE");
        System.out.println("\s\s\s\s12)DICIEMBRE");
        System.out.println("\s\s\s\s13)//Salir//");
        
    }//menuImprimirMes
    //--------------------------------------------------------------------------
    private static int leerInt(int respuesta, int limite)
    {
        Scanner entrada = new Scanner(System.in);
        do {
            try
            {
                System.out.print("\n\s\s\sElija una opción > ");
                respuesta = entrada.nextInt();
                if (respuesta < 0 || respuesta > limite) 
                    System.out.println("OPCIÓN INVÁLIDA [1-"+ limite + "]");
            
            }catch (Exception e) {
                System.out.println("OPCIÓN INVÁLIDA [1-"+ limite + "]");
            }
            
        } while (respuesta <= 0 || respuesta > limite);
        return respuesta;
    }
}
