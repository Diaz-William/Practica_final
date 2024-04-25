package Agenda;

//API
import java.util.Scanner;

public class Entrada {
    private static Scanner entrada = new Scanner(System.in);
    private static int num;
    private static String cadena;
    
    //METODOS
    public static int leerEntero(String mensaje)
    {
        num = 0;
        System.out.print(mensaje);
        try
        {
            num = entrada.nextInt();
        } catch (Exception e)
        {
            limpiarBuffer();
            num = leerEntero("\s\s\sError: Introduce un numero > ");
        }
        return num;
    }//leerEntero
    //--------------------------------------------------------------------------
    public static String leerCadena(String mensaje)
    {
        cadena = null;
        System.out.print(mensaje);
        try
        {
            cadena = entrada.nextLine();
        } catch (Exception e)
        {
            limpiarBuffer();
            cadena = leerCadena("\s\s\sError: Introduce una cadena > ");
        }
        return (cadena);
    }//leerCadena
    //--------------------------------------------------------------------------
    public static void limpiarBuffer()
    {
        entrada.nextLine();
    }
    //--------------------------------------------------------------------------
    public static void esperarEnter()
    {
        limpiarBuffer();
        System.out.println("\nPresiona enter para continuar...");
        String enter = entrada.nextLine();
    }
    //--------------------------------------------------------------------------
}//Class
