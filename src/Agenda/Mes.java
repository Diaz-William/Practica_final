package Agenda;

public class Mes 
{
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //ATRIBUTOS
    private Dia dias[];
    private int numMes;
    private String nombreMes;
    private static int siguienteMes = 1;
    
    //--------------------------------------------------------------------------
    //CONSTRUCTOR
    public Mes(String nombreMes, int cantidadDias) {
        this.nombreMes = nombreMes;
        this.dias = new Dia[cantidadDias];
        this.numMes = siguienteMes;
        siguienteMes++;
    }
        
    //--------------------------------------------------------------------------
    //GETTERS & SETTERS 


    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //METODOS     
    public void eventosDelMes() 
    {
        for (Dia dia : dias) {
            if (dia != null)
            {
                System.out.println("Dia " + dia.getNumDia());
                //dia.infoEvento
            }
        }
    }//eventosDelMes
}
