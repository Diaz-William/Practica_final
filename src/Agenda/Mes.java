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
        instanciarDias();
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
    private void instanciarDias()
    {
        for (int i = 0; i < dias.length; i++) 
            dias[i] = new Dia(i+1);
    }//instanciarDias
    //--------------------------------------------------------------------------
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
    public void recordatorioNuevo(int eleccion)
    {
        int dia = 0;
        do {            
            dia = entrada.leerEntero("\s\s\sIntroduzca el dia [1-" + getUltimoDia() + "] > ");
        } while (dia < 1 || dia > getUltimoDia());
        dia -= 1;
        dias[dia].horaRecordatorio(eleccion);
    }
}
