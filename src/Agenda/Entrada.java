package Agenda;

//API
import java.util.Scanner;

public class Entrada {
    Scanner entrada = new Scanner(System.in);
    int num;
    String cadena;
    
    //METODOS
    public int leerEntero(String mensaje)
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
    public String leerCadena(String mensaje)
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
    public void limpiarBuffer()
    {
        entrada.nextLine();
    }
}//Class
