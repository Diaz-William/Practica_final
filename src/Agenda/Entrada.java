package Agenda;

//API
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;
/**
 * Esta clase proporciona métodos estáticos para leer datos del usuario desde la consola.
 */
public class Entrada {
    /**Un objeto Scanner para leer la entrada desde la consola.*/
    private static Scanner entrada = new Scanner(System.in);
    /**Una variable para almacenar un valor entero leído desde la consola.*/
    private static int num;
    /**Una variable para almacenar un valor de cadena leído desde la consola.*/
    private static String cadena;
    
    //METODOS
    //--------------------------------------------------------------------------
    /**
     * Lee un valor entero de la consola con el mensaje dado.
     * @param mensaje El mensaje a mostrar al usuario.
     * @return El valor entero leído desde la consola.
     */
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
    /**
     * Lee un valor de cadena de la consola con el mensaje dado.
     * @param mensaje El mensaje a mostrar al usuario.
     * @return El valor de la cadena leído desde la consola.
     */
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
    /**
     * Limpia el buffer de entrada para evitar problemas con lecturas posteriores.
     */
    public static void limpiarBuffer()
    {
        entrada.nextLine();
    }
    //--------------------------------------------------------------------------
    /**
    * Simula la pulsación de la tecla "Enter".
    * @throws AWTException Si se produce un error al acceder al robot.
    */
    public static void pulsarEnter() throws AWTException
    {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
    //--------------------------------------------------------------------------
    /**
     * Pausa el programa y solicita al usuario que pulse la tecla Enter para continuar.
     */
    public static void esperarEnter()
    {
        limpiarBuffer();
        System.out.print("\n\s\s\sPresiona enter para continuar...");
        String enter = entrada.nextLine();
    }
    //--------------------------------------------------------------------------
}//Class
