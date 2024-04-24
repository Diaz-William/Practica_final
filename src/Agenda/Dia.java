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
        for (Hora hora : horas) {
            if (hora != null)
            {
                //hora.info
            }
        }
    }//infoEventos
    //--------------------------------------------------------------------------
    public void horaRecordatorioTarea(int eleccion, int numMes, int anio)
    {
        int h            = -1;
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
            do
            {            
                h = Entrada.leerEntero("\s\s\sIntroduzca la hora [0-23] > ");
            } while (h < 0 || h > 23);
            System.out.println("\s\s\s1) " + h + ":00");
            System.out.println("\s\s\s2) " + h + ":30");
            op = 0;
            do
            {            
                op = Entrada.leerEntero("\n\s\s\sElija una opcion > ");
            } while (op < 1 || op > 2);
            if (op == 1)
                hora = LocalTime.of(h, 00);
            else
                hora = LocalTime.of(h, 30);
            
            posicion = h * 2;
            if (hora.getMinute() == 30) 
                posicion += 1;
            
            horas[posicion] = new Hora();
            
            if (eleccion == 1)
                horas[posicion].recordatorio(idEvento, fecha, hora, false);
            else
                horas[posicion].tarea(idEvento, fecha, hora, false);
        }
        else
        {
            if (eleccion == 1)
                horas[posicion].recordatorio(idEvento, fecha, hora, true);
            else
                horas[posicion].tarea(idEvento, fecha, hora, true);
        }


    }
}
