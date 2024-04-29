package Agenda;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;

/**
 * Esta clase representa un día dentro de un calendario. Permite almacenar y gestionar eventos (recordatorios y tareas) para ese día específico.
 */

public class Dia 
{
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //ATRIBUTOS
    /**Un array de objetos Hora que representa las 48 horas del día (24 horas x 2 mitades).*/
    private Hora horas[] = new Hora [48];
    /**Una lista de objetos Evento que representa los eventos que se realizan durante todo el día.*/
    private ArrayList <Evento> todoElDia = new ArrayList();
    /**Un entero que representa el número del día dentro del mes.*/
    private int numDia;
    /**Un entero que se utiliza como identificador único para cada evento.*/
    private static int idEvento = 1;

    //--------------------------------------------------------------------------
    //CONSTRUCTOR
    /**
     * Crea un nuevo objeto Dia con el número de día especificado.
     * @param numDia El número del día.
     */
    public Dia(int numDia) {
        this.numDia = numDia;
    }
    
    
    //--------------------------------------------------------------------------
    //GETTERS & SETTERS 
    public int getNumDia() {
        return numDia;
    }

    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //METODOS
    //--------------------------------------------------------------------------
    /**
     * Muestra información sobre todos los eventos del día, tanto los que tienen una hora específica como los que se realizan durante todo el día.
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public void infoEvento() throws InterruptedException
    {
        for (Evento evento : todoElDia)
        {
            evento.infoEvento(evento);
        }
        for (Hora hora : horas)
        {
            if (hora != null)
            {
                hora.info();
            }
        }
        Entrada.limpiarBuffer();
        Entrada.esperarEnter();
    }//infoEventos
    //--------------------------------------------------------------------------
    /**
     * Muestra información sobre todos los recordatorios del día.
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public void infoRecordatorios() throws InterruptedException
    {
        for (Evento evento : todoElDia)
        {
            if (evento instanceof Recordatorio)
            {
                evento.infoEvento(evento);
            }
        }
        for (Hora hora : horas)
        {
            if (hora != null)
            {
                hora.infoRecordatorio();
            }
        }
    }
    //--------------------------------------------------------------------------
    /**
     * Muestra información sobre todas las tareas del día.
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public void infoTareas() throws InterruptedException
    {
        for (Evento evento : todoElDia)
        {
            if (evento instanceof Tarea)
            {
                evento.infoEvento(evento);
            }
        }
        for (Hora hora : horas)
        {
            if (hora != null)
            {
                hora.infoTarea();
            }
        }
    }
    //--------------------------------------------------------------------------
    /**
     * Muestra información sobre el evento que se realiza en una hora específica.
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public void infoEventoHora() throws InterruptedException
    {
        int posicion = 0;
        LocalTime hora = pedirHora();
        posicion = hora.getHour() * 2;
        if (hora.getMinute() == 30) 
            posicion += 1;
        if (horas[posicion] != null)
        {
            horas[posicion].info();
        }
        else
        {
            System.out.println("No hay eventos a las " + hora);
            Thread.sleep(3000);
        }
    }
    //--------------------------------------------------------------------------
    /**
     * Permite crear un nuevo recordatorio o una nueva tarea para una hora específica o para todo el día.
     * @param eleccion Un entero que indica el tipo de evento que se desea crear (1.Recordatorio, 2.Tarea).
     * @param numMes Un entero que representa el número del mes.
     * @param anio Un entero que representa el año.
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public void horaRecordatorioTarea(int eleccion, int numMes, int anio) throws InterruptedException
    {
        LocalTime hora   = null;
        int op           =  0;
        int opTipoEvento = -1;
        int posicion     =  0;
        LocalDate fecha = LocalDate.of(anio, numMes, numDia);
        
        System.out.println("\s\s\s1) El evento es a una hora concreta.");
        System.out.println("\s\s\s2) El evento es para todo el dia.");
        do
        {            
            opTipoEvento = Entrada.leerEntero("\n\s\s\sElija una opcion > ");
        } while (opTipoEvento < 1 || opTipoEvento > 2);
        if (opTipoEvento == 1) 
        {
            hora = pedirHora();
            
            posicion = hora.getHour() * 2;
            if (hora.getMinute() == 30) 
                posicion += 1;
            
            horas[posicion] = new Hora();
            
            if (eleccion == 1)
                horas[posicion].recordatorio(idEvento, fecha, hora);
            else
                horas[posicion].tarea(idEvento, fecha, hora);
        }
        else
        {
            if (eleccion == 1)
                todoElDia.add(new Recordatorio(idEvento, fecha, hora, true));
            else
                todoElDia.add(new Tarea(idEvento, fecha, hora, true));
        }
    }
    //--------------------------------------------------------------------------
    /**
     * Solicita al usuario que ingrese una hora y la devuelve.
     * @return La hora ingresada
     */
    private LocalTime pedirHora()
    {
        int h = 0, op = 0;
        LocalTime hora = null;
        do
        {            
            h = Entrada.leerEntero("\s\s\sIntroduzca la hora [0-23] > ");
        } while (h < 0 || h > 23);
        System.out.println("\s\s\s1) " + h + ":00");
        System.out.println("\s\s\s2) " + h + ":30");
        do
        {            
            op = Entrada.leerEntero("\n\s\s\sElija una opcion > ");
        } while (op < 1 || op > 2);
        if (op == 1)
            hora = LocalTime.of(h, 00);
        else
            hora = LocalTime.of(h, 30);
            
        return (hora);
    }
    //--------------------------------------------------------------------------
    /**
     * Elimina un evento (recordatorio o tarea) del día en base a su identificador.
     * @param idBorrar Identificador del evento (recordatorio o tarea) a borrar.
     * @param tipo Tipo del evento (recordatorio o tarea) a borrar.
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    private void eliminarPorId(int idBorrar, String tipo) throws InterruptedException
    {
        boolean borrado = false;
        for (int i = 0; i < todoElDia.size(); i++)
        {
            if (tipo.equalsIgnoreCase("recordatorio"))
            {
                if (todoElDia.get(i).getId() == idBorrar && todoElDia.get(i) instanceof Recordatorio)
                {
                    borrado = true;
                    System.out.println("Se ha borrado el " + tipo + " con el id: " + idBorrar);
                    todoElDia.remove(i);
                }
            }
            else
            {
                if (todoElDia.get(i).getId() == idBorrar && todoElDia.get(i) instanceof Tarea)
                {
                    borrado = true;
                    System.out.println("Se ha borrado el " + tipo + " con el id: " + idBorrar);
                    todoElDia.remove(i);
                }
            }
        }
        
        for (int i = 0; i < horas.length; i++) 
        {
            if (horas[i] != null)
            {
                borrado = horas[i].borrarEvento(idBorrar, tipo);
            }
            
        }
        
        if (!borrado)
        {
            System.out.println("No hay un evento " + tipo + " con el id " + idBorrar);
        }
        
        Thread.sleep(3000);
    }
    //--------------------------------------------------------------------------
    /**
     * Permite eliminar un recordatorio o una tarea existente.
     * @param eleccion Un entero que indica el tipo de evento que se desea crear (1.Recordatorio, 2.Tarea).
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public void quitarRecordatorioTarea(int eleccion) throws InterruptedException
    {
        int idBorrar = 0;
        if (eleccion == 3)
        {
            infoRecordatorios();
            idBorrar = Entrada.leerEntero("Introduce el id del recordatorio a borrar > ");
            eliminarPorId(idBorrar, "recordatorio");
        }
        else
        {
            infoTareas();
            idBorrar = Entrada.leerEntero("Introduce el id de la tarea a borrar > ");
            eliminarPorId(idBorrar, "tarea");
        }
    }
    //--------------------------------------------------------------------------
}//Class