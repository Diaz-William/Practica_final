package Agenda;

import java.time.LocalTime;


public class Dia 
{
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //ATRIBUTOS
    private Hora horas[] = new Hora [48];
    private int numDia;
    private LocalTime hora;
    private Entrada entrada = new Entrada();

    //--------------------------------------------------------------------------
    //CONSTRUCTOR

    public Dia(int numDia) {
        this.numDia = numDia;
        instanciarHoras();
    }
    
    
    //--------------------------------------------------------------------------
    //GETTERS & SETTERS 
    public int getNumDia() {
        return numDia;
    }

    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //METODOS    
    private void instanciarHoras()
    {
        for (int i = 0; i < horas.length; i++) {
            if (i%2 == 0) 
                horas[i] = (new Hora(i+":00"));
            else
                horas[i] = (new Hora(i+":30"));
        }
    }//instanciarHoras
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
    public void horaRecordatorio(int eleccion)
    {
        int h            = -1;
        int op           =  0;
        int opTipoEvento = -1;
        int posicion     =  0;
        
        System.out.println("\s\s\s1) El evento es a una hora concreta.");
        System.out.println("\s\s\s2) El evento es para todo el dia.");
        do
        {            
            opTipoEvento = entrada.leerEntero("\n\s\s\sElija una opcion > ");
        } while (opTipoEvento < 1 || opTipoEvento > 2);
        if (opTipoEvento == 1) 
        {
            do
            {            
                h = entrada.leerEntero("\s\s\sIntroduzca la hora [0-23] > ");
            } while (h < 0 || h > 23);
            System.out.println("\s\s\s1) " + h + ":00");
            System.out.println("\s\s\s2) " + h + ":30");
            op = 0;
            do
            {            
                op = entrada.leerEntero("\n\s\s\sElija una opcion > ");
            } while (op < 1 || op > 2);
            if (op == 1)
                hora = LocalTime.of(h, 00);
            else
                hora = LocalTime.of(h, 30);
            
            posicion = h * 2;
            if (hora.getMinute() == 30) 
                posicion += 1;
            
            if (eleccion == 1)
                horas[posicion].recordatorio(hora,false);
            else
                horas[posicion].tarea(hora,false);
        }
        else
        {
            if (eleccion == 1)
                horas[posicion].recordatorio(hora,true);
            else
                horas[posicion].tarea(hora,true);
        }


    }
}
