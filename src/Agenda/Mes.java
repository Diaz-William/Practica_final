package Agenda;

/**
 * Esta clase representa un mes dentro de un año. Almacena información sobre 
 * el nombre del mes, el número del mes y un array del objeto Dia del tamaño 
 * del número de días que tiene el mes.
 */
public class Mes 
{
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //ATRIBUTOS
    /**Un array de objetos Dia que representa los días del mes.*/
    private Dia dias[];
    /**Un entero que representa el número del mes (1 para enero, 12 para diciembre).*/
    private int numMes;
    /**Una cadena de texto que representa el nombre del mes.*/
    private String nombreMes;
    /**Una variable estática que se utiliza para generar el número de mes siguiente de forma automática.*/
    private static int siguienteMes = 1;
    
    //--------------------------------------------------------------------------
    /**
     * Crea un nuevo objeto Mes con el nombre y la cantidad de días especificados.
     * Inicializa el array dias y asigna el número de mes.
     * @param nombreMes El nombre del mes.
     * @param cantidadDias El número de días que tiene el mes.
     */
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
    //--------------------------------------------------------------------------
    /**
     * Muestra la información de todos los eventos del mes.
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public void eventosDelMes() throws InterruptedException 
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
    /**
     * Permite al usuario crear un nuevo recordatorio o tarea para un día específico del mes.
     * @param eleccion Un entero que indica el tipo de evento que se desea crear (1.Recordatorio, 2.Tarea).
     * @param anio Un entero que representa el año.
     * @throws InterruptedException Si ocurre un error de E/S.
     */
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
    /**
     * Permite al usuario eliminar un recordatorio o tarea para un día específico del mes.
     * @param eleccion Un entero que indica el tipo de evento que se desea borrar (1.Recordatorio, 2.Tarea).
     * @throws InterruptedException Si ocurre un error de E/S.
     */
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
    /**
     * Muestra la información de eventos según la opción seleccionada por el usuario (por día, por mes o por día y hora).
     * @param eleccion Elección para mostrar información (5. Eventos de un día, 6. Eventos de un mes, 7. Evento específico).
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public void verEventos(int eleccion) throws InterruptedException
    {
        boolean dentro = false;
        
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
                }
                else
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
            for (Dia dia : dias) 
            {
                if (dia != null)
                {
                    dia.infoEvento();
                }
            }
            if (!dentro)
            {
                System.out.println("No hay eventos en " + nombreMes);
                Thread.sleep(3000);
            }
        }
    }
    //--------------------------------------------------------------------------
}//Class