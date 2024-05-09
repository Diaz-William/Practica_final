package Agenda;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Esta clase representa un mes dentro de un a�o. Almacena informaci�n sobre 
 * el nombre del mes, el n�mero del mes y un array del objeto Dia del tama�o 
 * del n�mero de d�as que tiene el mes.
 */
public class Mes 
{
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //ATRIBUTOS
    /**Un array de objetos Dia que representa los d�as del mes.*/
    private Dia dias[];
    /**Un entero que representa el n�mero del mes (1 para enero, 12 para diciembre).*/
    private int numMes;
    /**Una cadena de texto que representa el nombre del mes.*/
    private String nombreMes;
    /**Una variable est�tica que se utiliza para generar el n�mero de mes siguiente de forma autom�tica.*/
    private static int siguienteMes = 1;
    
    //--------------------------------------------------------------------------
    /**
     * Crea un nuevo objeto Mes con el nombre y la cantidad de d�as especificados.
     * Inicializa el array dias y asigna el n�mero de mes.
     * @param nombreMes El nombre del mes.
     * @param cantidadDias El n�mero de d�as que tiene el mes.
     */
    //CONSTRUCTOR
    public Mes(String nombreMes, int cantidadDias) {
        this.nombreMes = nombreMes;
        this.dias = new Dia[cantidadDias];
        this.numMes = siguienteMes;
        siguienteMes++;
    }
        
    //--------------------------------------------------------------------------
    //GETTERS & SETTERS 

    /**
     * metodo para obtener el ultimo dia del mes o los dias que tiene el mismo.
     * @return dias.length la cantidad de dias que tiene el mes.
     */
    public int getUltimoDia()
    {
        return (dias.length);
    }
    //--------------------------------------------------------------------------

    /**
     * metodo para obtener el mes del a�o.
     * @return nombreMes el nombre del mes.
     */
    public String getNombreMes()
    {
        return nombreMes;
    }
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //METODOS 
    //--------------------------------------------------------------------------
    /**
     * Muestra la informaci�n de todos los eventos del mes.
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public void eventosDelMes() throws InterruptedException 
    {
        for (Dia dia : dias) {
            if (dia != null)
            {
                System.out.println("Dia " + dia.getNumDia());
                dia.infoEvento();
            }
        }
    }//eventosDelMes
    //--------------------------------------------------------------------------
    /**
     * Permite al usuario crear un nuevo recordatorio o tarea para un d�a espec�fico del mes.
     * @param eleccion Un entero que indica el tipo de evento que se desea crear (1.Recordatorio, 2.Tarea).
     * @param anio Un entero que representa el a�o.
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public void nuevoRecordatorioTarea(int eleccion, int anio) throws InterruptedException
    {
        int dia = 0;
        do {            
            dia = Entrada.leerEntero("\s\s\sIntroduzca el dia [1-" + getUltimoDia() + "] > ");
        } while (dia < 1 || dia > getUltimoDia());
        if (dias[dia-1] == null)
        {
            dias[dia-1] = new Dia(dia);
            dias[dia-1].horaRecordatorioTarea(eleccion, numMes, anio);
        }
        else
        {
            dias[dia-1].horaRecordatorioTarea(eleccion, numMes, anio);
        }
    }
    //--------------------------------------------------------------------------
    /**
     * Permite al usuario eliminar un recordatorio o tarea para un d�a espec�fico del mes.
     * @param eleccion Un entero que indica el tipo de evento que se desea borrar (1.Recordatorio, 2.Tarea).
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public void eliminarRecordatorioTarea(int eleccion) throws InterruptedException
    {
        int dia = 0;
        do {            
            dia = Entrada.leerEntero("\s\s\sIntroduzca el dia [1-" + getUltimoDia() + "] > ");
        } while (dia < 1 || dia > getUltimoDia());
        if (dias[dia-1] != null)
        {
            dias[dia-1].quitarRecordatorioTarea(eleccion);
        }
        else
        {
            System.out.println("No hay eventos el dia " + dia + " de " + nombreMes);
            Thread.sleep(3000);
        }
    }
    //--------------------------------------------------------------------------
    /**
     * Muestra la informaci�n de eventos seg�n la opci�n seleccionada por el usuario (por d�a, por mes o por d�a y hora).
     * @param eleccion Elecci�n para mostrar informaci�n (5. Eventos de un d�a, 6. Eventos de un mes, 7. Evento espec�fico).
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public void verEventos(int eleccion) throws InterruptedException
    {
        boolean dentro = false;
        
        if (eleccion == 5 || eleccion == 7)
        {
            int dia = 0;
            do {            
                dia = Entrada.leerEntero("\s\s\sIntroduzca el dia [1-" + getUltimoDia() + "] > ");
            } while (dia < 1 || dia > getUltimoDia());
            if (dias[dia-1] != null)
            {
                if (eleccion == 7)
                {
                    dias[dia-1].infoEventoHora();
                }
                else
                {
                    dias[dia-1].infoEvento();
                }
            }
            else
            {
                System.out.println("No hay eventos el dia " + dia + " de " + nombreMes);
                Thread.sleep(3000);
            }
        }
        else if (eleccion == 6)
        {
            for (Dia dia : dias) 
            {
                if (dia != null)
                {
                    dia.infoEvento();
                    dentro = true;
                }
            }
            if (!dentro)
            {
                System.out.println("No hay eventos en " + nombreMes);
                Thread.sleep(3000);
            }
        }
    }
    //--------------------------------------------------------------------------
    /**
     * A�ade un nuevo evento (recordatorio o tarea) a la lista de eventos asociados a un d�a espec�fico del mes.
     *
     * @param fecha La fecha del evento.
     * @param hora La hora del evento.
     * @param tipo El tipo del evento (Tarea o Recordatorio).
     * @param nombre El nombre del evento.
     * @param adicional Indica si el evento es urgente o anul dependiendo si es una Tarea o Recordatorio.
     * @param todoElDia Indica si el evento ocupa todo el d�a.
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public void aniadirEventoMes(LocalDate fecha, LocalTime hora, String tipo, String nombre, boolean adicional, boolean todoElDia) throws InterruptedException
    {
        int dia = fecha.getDayOfMonth();
        
        if (dias[dia-1] == null)
        {
            dias[dia-1] = new Dia(dia);
            dias[dia-1].aniadorEventosDia(fecha, hora, tipo, nombre, adicional, todoElDia);
        }
        else
        {
            dias[dia-1].aniadorEventosDia(fecha, hora, tipo, nombre, adicional, todoElDia);
        }
    }
    //--------------------------------------------------------------------------
    /**
     * Vac�a la agendea del mes, eliminando todos los eventos.
     */
    public void vaciarAgendaMes()
    {
        for (int i = 0; i < dias.length; i++)
        {
            if (dias[i] != null)
            {
                dias[i].vaciarAgendaDia();
                dias[i] = null;
            }
        }
    }
    //--------------------------------------------------------------------------
    /**
     * Verifica si hay eventos registrados en el mes.
     *
     * @return true si hay eventos registrados, de lo contrario false.
     */
    public boolean hayEventos()
    {
        boolean hay = false;
        for (Dia dia : dias)
        {
            if (dia != null)
            {
                hay = true;
            }
        }
        return hay;
    }
    //--------------------------------------------------------------------------
    /**
     * Guarda los eventos del mes o los eventos del d�a en un archivo, seg�n la opci�n seleccionada por el usuario.
     *
     * @param eleccion La opci�n seleccionada por el usuario.
     */
    public void guardarFicheroMes(int eleccion)
    {
        if (eleccion == 11)
        {
            int dia = 0;
            do {            
                dia = Entrada.leerEntero("\s\s\sIntroduzca el dia [1-" + getUltimoDia() + "] > ");
            } while (dia < 1 || dia > getUltimoDia());
            
            if(dias[dia-1] != null)
            {
                dias[dia-1].guardarFicheroDia(eleccion, nombreMes);
            }
            else
            {
                System.out.println("No hay eventos el dia " + dia + " de " + nombreMes);
            }
        }
        else
        {
            for (Dia dia : dias)
            {
                if (dia != null)
                {
                    dia.guardarFicheroDia(eleccion, nombreMes);
                }
            }
        }
    }
    //--------------------------------------------------------------------------
}//Class