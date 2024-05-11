package Agenda;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Esta clase representa un d�a dentro de un calendario. Permite almacenar y gestionar eventos (recordatorios y tareas) para ese d�a espec�fico.
 */
public class Dia
{
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //ATRIBUTOS
    /**Un array de objetos Hora que representa las 48 horas del d�a (24 horas x 2 mitades).*/
    private Hora horas[] = new Hora [48];
    /**Una lista de objetos Evento que representa los eventos que se realizan durante todo el d�a.*/
    private ArrayList <Evento> todoElDia = new ArrayList();
    /**Un entero que representa el n�mero del d�a dentro del mes.*/
    private int numDia;
    /**Un entero que se utiliza como identificador �nico para cada evento.*/
    private static int idEvento = 1;
    //--------------------------------------------------------------------------
    //CONSTRUCTOR
    /**
     * Crea un nuevo objeto Dia con el n�mero de d�a especificado.
     * @param numDia El n�mero del d�a.
     */
    public Dia(int numDia) {
        this.numDia = numDia;
    }
    //--------------------------------------------------------------------------
    //GETTERS & SETTERS 

    /**
     * metodo para obtener el dia del mes.
     * @return numDia el dia del mes.
     */
    public int getNumDia() {
        return numDia;
    }
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //METODOS
    //--------------------------------------------------------------------------
    /**
     * Muestra informaci�n sobre todos los eventos del d�a, tanto los que tienen una hora espec�fica como los que se realizan durante todo el d�a.
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
    }//infoEventos
    //--------------------------------------------------------------------------
    /**
     * Muestra informaci�n sobre todos los recordatorios del d�a.
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
     * Muestra informaci�n sobre todas las tareas del d�a.
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
     * Muestra informaci�n sobre el evento que se realiza en una hora espec�fica.
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
            System.out.println("\s\s\sNo hay eventos a las " + hora);
            Thread.sleep(2000);
        }
    }
    //--------------------------------------------------------------------------
    /**
     * Permite crear un nuevo recordatorio o una nueva tarea para una hora espec�fica o para todo el d�a.
     * @param eleccion Un entero que indica el tipo de evento que se desea crear (1.Recordatorio, 2.Tarea).
     * @param numMes Un entero que representa el n�mero del mes.
     * @param anio Un entero que representa el a�o.
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
            {
                posicion ++;
            }

            if (horas[posicion] == null)
            {
                horas[posicion] = new Hora();
            }
            if (eleccion == 1)
            {
                horas[posicion].recordatorio(idEvento, fecha, hora);
            }                
            else
            {
                horas[posicion].tarea(idEvento, fecha, hora);
            }
        }
        else
        {
            if (eleccion == 1)
                todoElDia.add(new Recordatorio(idEvento, fecha, hora, true));
            else
                todoElDia.add(new Tarea(idEvento, fecha, hora, true));
        }
        idEvento++;
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
     * Elimina un evento (recordatorio o tarea) del d�a o hora en base a su identificador.
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
                    System.out.println("\s\s\sSe ha borrado el " + tipo + " con el id: " + idBorrar);
                    todoElDia.remove(i);
                }
            }
            else
            {
                if (todoElDia.get(i).getId() == idBorrar && todoElDia.get(i) instanceof Tarea)
                {
                    borrado = true;
                    System.out.println("\s\s\sSe ha borrado el " + tipo + " con el id: " + idBorrar);
                    todoElDia.remove(i);
                }
            }
        }
        
        if (!borrado)
        {
            for (int i = 0; i < horas.length; i++) 
            {
                if (horas[i] != null)
                {
                    borrado = horas[i].borrarEvento(idBorrar, tipo);
                }

            }
            
            if (borrado)
            {
                for (int i = 0; i < horas.length; i++) 
                {
                    if (horas[i] != null)
                    {
                        if (!horas[i].hayEventosHora())
                        {
                            horas[i] = null;
                        }
                    }
                }
            }
        }
        
        if (!borrado)
        {
            System.out.println("\s\s\sNo hay un evento " + tipo + " con el id " + idBorrar);
        }
        
        Thread.sleep(2000);//Esperar 2 segundos.
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
            idBorrar = Entrada.leerEntero("\s\s\sIntroduce el id del recordatorio a borrar > ");
            eliminarPorId(idBorrar, "recordatorio");
        }
        else
        {
            infoTareas();
            idBorrar = Entrada.leerEntero("\s\s\sIntroduce el id de la tarea a borrar > ");
            eliminarPorId(idBorrar, "tarea");
        }
    }
    //--------------------------------------------------------------------------
    /**
     * Verifica si hay eventos registrados en el dia.
     *
     * @return true si hay eventos registrados, de lo contrario false.
     */
    public boolean hayEventosDia()
    {
        boolean hay = false;
        
        for (Evento evento : todoElDia)
        {
            if (evento != null)
            {
                hay = true;
            }
        }
        for (Hora hora : horas)
        {
            if (hora != null)
            {
                hay = true;
            }
        }
        
        return hay;
    }
    //--------------------------------------------------------------------------
    /**
     * A�ade un evento al d�a, ya sea una tarea o recordatorio, en una hora espec�fica o para todo el d�a.
     * @param fecha La fehca del evento.
     * @param hora La hora del evento.
     * @param tipo El tipo del evento (Tarea o Recordatorio).
     * @param nombre El nombre del evento.
     * @param adicional Indica si el evento es urgente o anul dependiendo si es una Tarea o Recordatorio.
     * @param todoElDia Indica si el evento es para todo el d�a.
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public void aniadorEventosDia(LocalDate fecha, LocalTime hora, String tipo, String nombre, boolean adicional, boolean todoElDia) throws InterruptedException
    {
        if (todoElDia)
        {
            if (tipo.equalsIgnoreCase("Tarea"))
            {
                this.todoElDia.add(new Recordatorio(idEvento, fecha, todoElDia, nombre, adicional));
            }
            else
            {
                this.todoElDia.add(new Tarea(idEvento, fecha, todoElDia, nombre, adicional));
            }
        }
        else
        {
            int posicion = hora.getHour() * 2 + (hora.getMinute() == 30 ? 1 : 0);
            if (horas[posicion] == null)
            {
                horas[posicion] = new Hora();
                horas[posicion].aniadirEventoHora(idEvento, fecha, hora, tipo, nombre, adicional);
            }
            else
            {
                horas[posicion].aniadirEventoHora(idEvento, fecha, hora, tipo, nombre, adicional);
            }
        }
        idEvento++;
    }
    //--------------------------------------------------------------------------
    /**
     * Vac�a la agenda del d�a, eliminando todos los eventos programados.
     */
    public void vaciarAgendaDia()
    {
        /*
        for (int i = 0; i < todoElDia.size(); i++)
        {
            todoElDia.remove(i);
        }*/
        todoElDia.clear();
        
        for (int i = 0; i < horas.length; i++)
        {
            if (horas[i] != null)
            {
                horas[i].vaciarAgendaHora();
                horas[i] = null;
            }
        }
    }
    //--------------------------------------------------------------------------
    /**
     * Guarda la informaci�n de los eventos del d�a en un fichero.
     * 
     * @param eleccion La opci�n seleccionada por el usuario.
     * @param nombreMes El nombre del mes.
     */
    public void guardarFicheroDia(int eleccion, String nombreMes)
    {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String info = null;
        
        for (Evento e : todoElDia)
        {
            if (e instanceof Tarea)
            {
                info = e.getFecha().format(formatoFecha) + "|DIA|Tarea|" + e.getNombre() + "|" + (((Tarea)e).getUrgente() ? "Urgente" : "No urgente");
                GuardarEvento.guardarFichero(info, eleccion, nombreMes, numDia);
            }
            else
            {
                info = e.getFecha().format(formatoFecha) + "|DIA|Recordatorio|" + e.getNombre() + "|" + (((Recordatorio)e).getAnual() ? "Anual" : "No anual");
                GuardarEvento.guardarFichero(info, eleccion, nombreMes, numDia);
            }
        }
        
        for (Hora hora : horas) {
            if (hora != null)
            {
                hora.guardarFicheroHora(eleccion, nombreMes, numDia);
            }
        }
    }
    //--------------------------------------------------------------------------
}//Class