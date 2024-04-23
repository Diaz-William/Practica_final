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
    
    
    //--------------------------------------------------------------------------
    //GETTERS & SETTERS 
    public int getNumDia() {
        return numDia;
    }

    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //METODOS    
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
    public void horaRecordatorio()
    {
        int h = -1;
        do
        {            
            h = entrada.leerEntero("Introduce la hora [0-23] > ");
        } while (h < 0 || h > 23);
        System.out.println("1) " + h + ":00");
        System.out.println("2) " + h + ":30");
        int op = 0;
        do
        {            
            op = entrada.leerEntero("\nElije una opcion > ");
        } while (op < 1 || op > 2);
        if (op == 1)
        {
            hora = LocalTime.of(h, 00);
        }else
        {
            hora = LocalTime.of(h, 30);
        }
        int posicion = h * 2;
        if (hora.getMinute() == 30) {
            posicion += 1;
        }
        horas[posicion].recordatorio(hora);
    }
}
