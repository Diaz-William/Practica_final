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
    public int getUltimoDia()
    {
        return (dias.length);
    }

    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //METODOS 
    /*private void instanciarDias()
    {
        for (int i = 0; i < dias.length; i++) 
            dias[i] = new Dia(i+1);
    }//instanciarDias*/
    //--------------------------------------------------------------------------
    public void eventosDelMes() 
    {
        for (Dia dia : dias) {
            if (dia != null)
            {
                System.out.println("Dia " + dia.getNumDia());
                dia.infoEvento();
            }
        }
    }//eventosDelMes
    //--------------------------------------------------------------------------
    public void nuevoRecordatorioTarea(int eleccion, int anio) throws InterruptedException
    {
        int dia = 0;
        do {            
            dia = Entrada.leerEntero("\s\s\sIntroduzca el dia [1-" + getUltimoDia() + "] > ");
        } while (dia < 1 || dia > getUltimoDia());
        dias[dia-1] = new Dia(dia);
        dias[dia-1].horaRecordatorioTarea(eleccion, numMes, anio);
    }
    //--------------------------------------------------------------------------
    public void eliminarRecordatorioTarea(int eleccion) throws InterruptedException
    {
        int dia = 0;
        do {            
            dia = Entrada.leerEntero("\s\s\sIntroduzca el dia [1-" + getUltimoDia() + "] > ");
        } while (dia < 1 || dia > getUltimoDia());
        if (dias[dia-1] != null)
        {
            dias[dia-1].quitarRecordatorioTarea(eleccion);
        }
        else
        {
            System.out.println("No hay eventos el dia " + dia + " de " + nombreMes);
            Thread.sleep(3000);
        }
    }
    //--------------------------------------------------------------------------
    public void verEventos(int eleccion) throws InterruptedException
    {
        if (eleccion == 5 || eleccion == 7)
        {
            int dia = 0;
            do {            
                dia = Entrada.leerEntero("\s\s\sIntroduzca el dia [1-" + getUltimoDia() + "] > ");
            } while (dia < 1 || dia > getUltimoDia());
            if (dias[dia-1] != null)
            {
                if (eleccion == 7)
                {
                    dias[dia-1].infoEventoHora();
                }else
                {
                    dias[dia-1].infoEvento();
                }
            }
            else
            {
                System.out.println("No hay eventos el dia " + dia + " de " + nombreMes);
                Thread.sleep(3000);
            }
        }
        else if (eleccion == 6)
        {
            for (Dia dia : dias) {
                if (dia != null)
                {
                    dia.infoEvento();
                }
            }
        }
    }
    //--------------------------------------------------------------------------
}//Class