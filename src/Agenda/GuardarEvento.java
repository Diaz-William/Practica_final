package Agenda;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Esta clase proporciona métodos para guardar eventos en un archivo de agenda.
 */
public class GuardarEvento
{
    /**
     * Guarda un evento en un archivo de agenda.
     * 
     * @param evento Datos del evento a guardar.
     * @param eleccion Opción de elección del archivo de agenda (9. Año, 10. Mes, 11. Día).
     * @param nombreMes Nombre del mes.
     * @param dia Día del mes.
     */
    public static void guardarFichero(String evento, int eleccion, String nombreMes, int dia)
    {
        String nombreFichero = null;
        
        if (eleccion == 9)
        {
            nombreFichero ="agenda_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss")) + ".dat";
        }
        else if (eleccion == 10)
        {
            nombreFichero ="agenda_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss")) + "_" + nombreMes + ".dat";
        }
        else
        {
            nombreFichero ="agenda_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"))+ "_" + nombreMes + "-Dia-" + dia + ".dat";
        }
        
        //String ruta = "c:/ficheros/" + nombreFichero;
        String ruta = "./src/ficheros/" + nombreFichero;
        FileWriter fw = null;
        
        try 
        {
            fw = new FileWriter(ruta,true);
            PrintWriter salida = new PrintWriter(fw);
            if (evento != null)
            {
                salida.println(evento);
            }
            salida.flush();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());                                                                   
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if (fw != null) 
                    fw.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());                                                               
            }
        }
    }
}//Class