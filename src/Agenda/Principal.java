package Agenda;

//API
import java.awt.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.*;
/**
 * Esta clase es el punto de entrada de la aplicación de agenda.
 * Controla el flujo principal del programa, presentando menús al usuario y
 * ejecutando las acciones correspondientes a cada opción seleccionada.
 */
public class Principal 
{
    //--------------------------------------------------------------------------
    /**Un objeto de la clase Menu que se utiliza para mostrar los menús de la aplicación.*/
    private Menu menu;
    /**Un entero que representa el año de la agenda.*/
    private int anio;
    /**Un ArrayList que almacena objetos de la clase Mes para cada mes del año.*/
    private ArrayList <Mes> meses = new ArrayList();
    //--------------------------------------------------------------------------
    public int getAnio() {
        return anio;
    }
    //--------------------------------------------------------------------------
    /**
     * El método main de la aplicación de la agenda. Crea un nuevo objeto Principal
     * y llama al método inicio.
     * @param args Los argumentos de la línea de comandos (no utilizados en este caso).
     * @throws AWTException Si ocurre un error al borrar la consola.
     * @throws InterruptedException Si ocurre un error mientras se espera la entrada del usuario.
     */
    public static void main(String[] args) throws AWTException, InterruptedException 
    {
        Principal principal = new Principal();
        principal.inicio(principal);
    }//main
    //--------------------------------------------------------------------------
    /**
     * Inicializa la agenda.
     * @throws AWTException Si ocurre un error al borrar la consola.
     * @throws InterruptedException Si ocurre un error mientras se espera la entrada del usuario.
     */
    private void inicio(Principal principal) throws AWTException, InterruptedException {
        instanciarMeses();
        menu = new Menu(principal);
    }//inicio
    //--------------------------------------------------------------------------
    /**
     * Crea e instancia los 12 objetos Mes para cada mes del año, almacenándolos en el ArrayList meses.
     */
    private void instanciarMeses()
    {
        anio = Entrada.leerEntero("Introduce el año > ");
        meses.add(new Mes("Enero", 31));
        boolean bisiesto = Year.of(anio).isLeap();
        if (bisiesto) 
            meses.add(new Mes("Febreo", 29));
        else 
            meses.add(new Mes("Febreo", 28));
        
        meses.add(new Mes("Marzo", 31));
        meses.add(new Mes("Abril", 30));
        meses.add(new Mes("Mayo", 31));
        meses.add(new Mes("Junio", 30));
        meses.add(new Mes("Julio", 31));
        meses.add(new Mes("Agosto", 31));
        meses.add(new Mes("Septiembre", 30));
        meses.add(new Mes("Octubre", 31));
        meses.add(new Mes("Noviembre", 30));
        meses.add(new Mes("Diciembre", 31));
    }
    //--------------------------------------------------------------------------
    /**
     * Crea un nuevo recordatorio o tarea.
     * @param eleccion Un entero que indica el tipo de evento que se desea crear (1.Recordatorio, 2.Tarea).
     * @throws InterruptedException Si ocurre un error mientras se espera la entrada del usuario.
     */
    public void crearRecordatorioTarea(int eleccion) throws InterruptedException
    {
        int mes = 0;
        do {            
            mes = Entrada.leerEntero("\s\s\sIntroduzca el numero del mes [1-12] > ");
        } while (mes < 1 || mes > 12);
        mes -= 1;
        meses.get(mes).nuevoRecordatorioTarea(eleccion, anio);
    }
    //--------------------------------------------------------------------------
    /**
     * Borra un recordatorio o tarea.
     * @param eleccion Un entero que indica el tipo de evento que se desea borrar (3.Recordatorio, 4.Tarea).
     * @throws InterruptedException Si ocurre un error mientras se espera la entrada del usuario.
     */
    public void borrarRecordatorioTarea(int eleccion) throws InterruptedException
    {
        int mes = 0;
        do {            
            mes = Entrada.leerEntero("\s\s\sIntroduzca el numero del mes [1-12] > ");
        } while (mes < 1 || mes > 12);
        mes -= 1;
        meses.get(mes).eliminarRecordatorioTarea(eleccion);
    }
    //--------------------------------------------------------------------------
    /**
     * Muestra la información de eventos según la opción seleccionada por el usuario.
     * @param eleccion Elección para mostrar información (5. Eventos de un día, 6. Eventos de un mes, 7. Evento específico).
     * @throws InterruptedException Si ocurre un error mientras se espera la entrada del usuario.
     */
    public void imprimirEventos(int eleccion) throws InterruptedException
    {
        int mes = 0;
        do {
            mes = Entrada.leerEntero("\s\s\sIntroduzca el numero del mes [1-12] > ");
        } while (mes < 1 || mes > 12);
        mes -= 1;
        meses.get(mes).verEventos(eleccion);
    }
    //--------------------------------------------------------------------------
    public void leerFicheroAnio() throws InterruptedException
    {
        Entrada.limpiarBuffer();
        System.out.println("Si lees el fichero los eventos guardados seran borrados");
        String res = Entrada.leerCadena("¿Quieres continuar? [s,si/n,no] > ");
        
        if (res.equalsIgnoreCase("s") || res.equalsIgnoreCase("si"))
        {
            vaciarAgendaAnio();
            FileReader fr = null;
            String informacion = "";
            int cont = 0;

            try {
                fr = new FileReader("c:/ficheros/eventos.dat");
                BufferedReader entrada = new BufferedReader(fr);
                do {
                    informacion = entrada.readLine();
                    if (informacion != null)
                    {
                        guardarEventos(informacion);
                        cont++;
                    }
                } while (informacion != null);
                entrada.close();
            } 
            catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
            finally {
                try {
                    if (fr != null) {
                        fr.close();
                    }
                    System.out.println("Se han creado " + cont + " eventos.");
                    Entrada.esperarEnter();
                } catch (IOException e) {
                    System.out.println(e.getMessage());                                                               
                }
            }
        }
    }//leerFicheroAnio
    //--------------------------------------------------------------------------
    private void vaciarAgendaAnio()
    {
        for (int i = 0; i < meses.size(); i++)
        {
            meses.get(i).vaciarAgendaMes();
        }
    }
    //--------------------------------------------------------------------------
    private void guardarEventos(String informacion) throws InterruptedException
    {
        LocalDate fecha;
        LocalTime hora;
        String tipo;
        String nombre;
        boolean adicional = false;
        
        String infoEvento[] = informacion.split("\\|");
        fecha = LocalDate.parse(infoEvento[0]);
        hora = LocalTime.parse(infoEvento[1]);
        tipo = infoEvento[2];
        nombre = infoEvento[3];
        if (infoEvento[4].equalsIgnoreCase("anual") || infoEvento[4].equalsIgnoreCase("urgente"))
        {
            adicional = true;
        }
        int mes = fecha.getMonthValue();
        meses.get(mes-1).aniadirEventoMes(fecha, hora, tipo, nombre, adicional);
    }
    //--------------------------------------------------------------------------
    public void guardarFicheroAnio() throws InterruptedException
    {
        String nombreFichero ="agenda_" +  LocalDateTime.now().format(DateTimeFormatter.ofPattern("d-MM-YYYY_HH-mm-ss"))+ ".dat";        
        String ruta = "c:/ficheros/" + nombreFichero;
        FileWriter fw = null;
        try 
        {
            fw = new FileWriter(ruta,true);
            PrintWriter salida = new PrintWriter(fw);
            salida.println("AÑO : " + anio);
            for (Mes mes : meses) {
                salida.println("MES : " + mes);
                salida.println(mes.ficheroDia()) ;
            }
            salida.flush();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());                                                                   
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if (fw != null) 
                    fw.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());                                                               
            }
        }
    }
    //--------------------------------------------------------------------------
}//Class