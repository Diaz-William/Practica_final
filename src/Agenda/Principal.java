package Agenda;

//API
import java.awt.*;
import java.io.*;
import java.time.Year;
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
    private Menu menu                       = new Menu();
    /**Un entero que representa el año de la agenda.*/
    private int anio;
    /**Un ArrayList que almacena objetos de la clase Mes para cada mes del año.*/
    private ArrayList <Mes> meses           = new ArrayList();
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

        principal.inicio();
        
    }//main
    //--------------------------------------------------------------------------
    /**
     * Inicializa la agenda.
     * @throws AWTException Si ocurre un error al borrar la consola.
     * @throws InterruptedException Si ocurre un error mientras se espera la entrada del usuario.
     */
    private void inicio() throws AWTException, InterruptedException {
        instanciarMeses();
        menu();
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
     * Muestra el menú principal y gestiona las selecciones del usuario.
     * @throws AWTException Si ocurre un error al borrar la consola.
     * @throws InterruptedException Si ocurre un error mientras se espera la entrada del usuario.
     */
    private void menu() throws AWTException, InterruptedException {
        int respuesta = 0, limite = 4;
        while (respuesta != limite)
        {
            menu.limpiar();
            menu.menuPrincipal();
            respuesta = eleccion(respuesta,limite);
            switch (respuesta)
            {
                case 1:
                {
                    do {                        
                        menu.limpiar();
                        menu.menuEventos();
                        limite = 12;
                        respuesta = eleccion(respuesta,limite);
                        eleccionMenuEventos(respuesta);
                    } while (respuesta != limite);
                    break;
                }
                case 2:
                {
                    do {                        
                        menu.limpiar();
                        menu.menuContactos();
                        limite = 6;
                        respuesta = eleccion(respuesta,limite);
                        eleccionMenuContactos(respuesta);
                    } while (respuesta != limite);
                    break;
                }
                case 3:
                {
                    do {                        
                        menu.limpiar();
                        menu.menuImprimirMes("--MENÚ DE IMPRESIÓN DE UN CALENDARIO MENSUAL");
                        limite = 13;
                        respuesta = eleccion(respuesta,limite);
                        eleccionMenuMes(respuesta);
                    } while (respuesta != limite);
                    break;
                }
                default : 
                {
                    menu.limpiar();
                    System.out.println("¡Gracias!");
                    break;
                }
            }
        }
    }//menu
    //--------------------------------------------------------------------------
    /**
     * Gestiona la selección de opciones del menú de eventos.
     * @param respuesta La opción seleccionada por el usuario.
     * @throws AWTException Si ocurre un error al borrar la consola.
     * @throws InterruptedException Si ocurre un error mientras se espera la entrada del usuario.
     */
    private void eleccionMenuEventos(int respuesta) throws AWTException, InterruptedException
    {
        switch (respuesta)
        {
            case 1  -> crearRecordatorioTarea(respuesta);
            case 2  -> crearRecordatorioTarea(respuesta);
            case 3  -> borrarRecordatorioTarea(respuesta);
            case 4  -> borrarRecordatorioTarea(respuesta);
            case 5  -> imprimirEventos(respuesta);
            case 6  -> imprimirEventos(respuesta);
            case 7  -> imprimirEventos(respuesta);
            /*case 8  -> leerFicheros();
            case 9  -> guardarFicheroAnio();
            case 10 -> guardarFicheroMes();
            case 11 -> guardarFicheroDia();*/
            default -> menu();
        }
    }//eleccionMenuEventos
    //--------------------------------------------------------------------------
    /**
     * Gestiona la selección de opciones del menú de contactos.
     * @param respuesta La opción seleccionada por el usuario.
     * @throws AWTException Si ocurre un error al borrar la consola.
     * @throws InterruptedException Si ocurre un error mientras se espera la entrada del usuario.
     */
    private void eleccionMenuContactos(int respuesta) throws AWTException, InterruptedException
    {
        switch (respuesta)
        {
            /*case 1  -> leerContactos();
            case 2  -> crearContacto();
            case 3  -> listarContactos();
            case 4  -> buscarContacto();
            case 5  -> guardarCotacto();*/
            default -> menu();
        }
    }//eleccionMenuContactos
    //--------------------------------------------------------------------------
    /**
     * Gestiona la selección de opciones del menú y muestra el calendario del mes correspondiente.
     * @param respuesta La opción seleccionada por el usuario.
     * @throws AWTException Si ocurre un error al borrar la consola.
     * @throws InterruptedException Si ocurre un error mientras se espera la entrada del usuario.
     */
    private void eleccionMenuMes(int respuesta) throws AWTException, InterruptedException
    {
        switch (respuesta)
        {
            case 1,2,4,5,6,7,8,9,10,11,12:
                Calendario.mostrarCalendario(respuesta, anio);
                Entrada.esperarEnter();
                break;
            default:
                menu();
                break;
        }
        
        
    }//eleccionMenuMes
    //--------------------------------------------------------------------------
    /**
     * Solicita al usuario una opción y la valida.
     * @param respuesta La opción seleccionada por el usuario.
     * @param limite El límite de opciones permitidas.
     * @return La opción seleccionada por el usuario.
     */
    private int eleccion(int respuesta, int limite)
    {
        do {
            respuesta = Entrada.leerEntero("\n\s\s\sElija una opción > ");
            if (respuesta < 1 || respuesta > limite) 
                System.out.print("\s\s\sOPCIÓN INVÁLIDA [1-"+ limite + "]");

        } while (respuesta <= 0 || respuesta > limite);
        return respuesta;
    }//eleccion
    //--------------------------------------------------------------------------
    /**
     * Crea un nuevo recordatorio o tarea.
     * @param eleccion Un entero que indica el tipo de evento que se desea crear (1.Recordatorio, 2.Tarea).
     * @throws InterruptedException Si ocurre un error mientras se espera la entrada del usuario.
     */
    private void crearRecordatorioTarea(int eleccion) throws InterruptedException
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
    private void borrarRecordatorioTarea(int eleccion) throws InterruptedException
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
    private void imprimirEventos(int eleccion) throws InterruptedException
    {
        int mes = 0;
        do {
            mes = Entrada.leerEntero("\s\s\sIntroduzca el numero del mes [1-12] > ");
        } while (mes < 1 || mes > 12);
        mes -= 1;
        meses.get(mes).verEventos(eleccion);
    }
    //--------------------------------------------------------------------------
}//Class