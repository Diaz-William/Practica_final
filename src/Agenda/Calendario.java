package Agenda;

import java.util.GregorianCalendar;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * Esta clase genera y muestra un calendario para un mes y año específicos.
 */
public class Calendario
{
    /**
     * Genera y muestra un calendario para el mes y año especificados.
     * @param mes Un entero que representa el mes (1 para enero, 12 para diciembre).
     * @param anio Un entero que representa el mes (1 para enero, 12 para diciembre).
     */
    public static void mostrarCalendario(int mes, int anio)
    {
        /*int mes = 12; // Pon el mes que quieras
        int anio = 2024; // Pon el año que quieras*/

        // Crear un objeto GregorianCalendar para el primer día del mes
        GregorianCalendar fecha = new GregorianCalendar(anio, mes - 1, 1);
        // Crear un objeto GregorianCalendar para el primer día del siguiente mes
        GregorianCalendar fecha2 = new GregorianCalendar(anio, mes, 1);
        // Obtener el día de la semana del primer día del mes
        DayOfWeek primerDia = fecha.toZonedDateTime().getDayOfWeek();
        String nombrePrimerDia = primerDia.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        nombrePrimerDia = nombrePrimerDia.toUpperCase();

        // Imprimir encabezado de los días de la semana
        System.out.println("\nL\tM\tX\tJ\tV\tS\tD");

        // Imprimir espacios en blanco basados en el día de la semana en que comienza el mes
        switch (nombrePrimerDia) {
            case "MONDAY":
                break;
            case "TUESDAY":
                System.out.print("\t");
                break;
            case "WEDNESDAY":
                System.out.print("\t\t");
                break;
            case "THURSDAY":
                System.out.print("\t\t\t");
                break;
            case "FRIDAY":
                System.out.print("\t\t\t\t");
                break;
            case "SATURDAY":
                System.out.print("\t\t\t\t\t");
                break;
            case "SUNDAY":
                System.out.print("\t\t\t\t\t\t");
                break;
        }

        // Imprimir los días del mes
        while (!fecha.equals(fecha2)) {
            System.out.print(fecha.get(GregorianCalendar.DATE) + "\t"); // Imprimir el día actual
            // Si el día actual es domingo, imprimir una nueva línea
            if (fecha.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.SUNDAY)
                System.out.println();
            fecha.add(GregorianCalendar.DATE, 1); // Avanzar al siguiente día
        }
        System.out.println(""); // Agregar una línea en blanco al final para mayor claridad
    }//mostrarCalendario
}//Class