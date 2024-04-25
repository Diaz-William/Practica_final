package Agenda;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;


public class Dia 
{
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //ATRIBUTOS
    private Hora horas[] = new Hora [48];
    private ArrayList <Evento> todoElDia = new ArrayList();
    private int numDia;
    private LocalTime hora;
    private static int idEvento = 1;

    //--------------------------------------------------------------------------
    //CONSTRUCTOR

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
    /*private void instanciarHoras()
    {
        for (int i = 0; i < horas.length; i++) {
            if (i%2 == 0) 
                horas[i] = (new Hora(i+":00"));
            else
                horas[i] = (new Hora(i+":30"));
        }
    }//instanciarHoras*/
    //--------------------------------------------------------------------------
    public void infoEvento()
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
    public void infoRecordatorios()
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
    public void infoTareas()
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
    public void infoEventoHora()
    {
        int posicion = 0;
        LocalTime hora = pedirHora();
        posicion = hora.getHour() * 2;
            if (hora.getMinute() == 30) 
                posicion += 1;
        horas[posicion].info();
    }
    //--------------------------------------------------------------------------
    public void horaRecordatorioTarea(int eleccion, int numMes, int anio) throws InterruptedException
    {
        //int h            = -1;
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
    private void eliminarPorId(int idBorrar, String tipo)
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
    }
    //--------------------------------------------------------------------------
    public void quitarRecordatorioTarea(int eleccion)
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