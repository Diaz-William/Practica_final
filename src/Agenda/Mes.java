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
    private Entrada entrada = new Entrada();
    
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
    public int getUltimoDia()
    {
        return (dias.length);
    }

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
    //--------------------------------------------------------------------------
    public void recordatorioNuevo()
    {
        int dia = 0;
        do {            
            dia = entrada.leerEntero("Introduce el dia [1-" + getUltimoDia() + "] > ");
        } while (dia < 1 || dia > getUltimoDia());
        dia -= 1;
        dias[dia].horaRecordatorio();
    }
}
