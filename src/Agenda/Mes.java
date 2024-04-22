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
    public Mes(int cantidadDias, String nombreMes) {
        this.dias = new Dia[cantidadDias];
        this.nombreMes = nombreMes;
        this.numMes = siguienteMes;
        siguienteMes++;
    }
        
    //--------------------------------------------------------------------------
    //GETTERS & SETTERS 


    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //METODOS     

}
