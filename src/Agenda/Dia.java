package Agenda;

public class Dia 
{
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //ATRIBUTOS
    private Hora horas[] = new Hora [48];
    private int numDia;

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
   
}
