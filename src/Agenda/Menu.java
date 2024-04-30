
package Agenda;

//API
import java.awt.*;
import java.awt.event.*;

/**
 * Esta clase proporciona la interfaz principal del programa y gestiona los 
 * distintos menús y opciones disponibles para el usuario.
 */
public class Menu
{
    /**
     * Muestra el menú principal con las opciones para acceder a los distintos 
módulos del programa.
     */
    Principal principal;

    public Menu(Principal principal) throws AWTException, InterruptedException {
        this.principal = principal;
        menu();
    }//menu
    
//--------------------------------------------------------------------------
    private void menuPrincipal()
    {
        System.out.println("--MENÚ PRINCIPAL--");
        System.out.println("\s\s1)Menú de Eventos y Tareas");
        System.out.println("\s\s2)Menú de Lista de contactos");
        System.out.println("\s\s3)Menú para Imprimir los días de calendario de un mes");
        System.out.println("\s\s4)//Salir//");
        
    }//menuPrincipal
    
//--------------------------------------------------------------------------
    /**
     * Muestra el menú de eventos y tareas, permitiendo al usuario crear, 
borrar, imprimir y gestionar eventos.
     */
    private void menuEventos()
    {
        System.out.println("--MENÚ DE EVENTOS Y TAREAS--");
        System.out.println("\s\s1)Crear un evento recordatorio");
        System.out.println("\s\s2)Crear un evento tarea");
        System.out.println("\s\s3)Borrar un evento recordatorio");
        System.out.println("\s\s4)Borrar un evento tarea");
        System.out.println("\s\s5)Imprimir todos los eventos de un día determinado");
        System.out.println("\s\s6)Imprimir todos los eventos de un mes determinado");
        System.out.println("\s\s7)Imprimir un evento por mes, día y hora");
        System.out.println("\s\s8)Leer de un fichero todos los eventos de un año");
        System.out.println("\s\s9)Guardar de un fichero de texto todos los eventos de un año");
        System.out.println("\s\s10)Guardar en un fichero de texto todos los eventos de un mes");
        System.out.println("\s\s11)Guardar en un fichero de texto todos los eventos de un día");
        System.out.println("\s\s12)//Salir//");
    }//menuEventos
    
//--------------------------------------------------------------------------
    /**
     * Muestra el menú de gestión de contactos, permitiendo al usuario leer, 
crear, listar, buscar y guardar contactos.
     */
    private void menuContactos()
    {
        System.out.println("--MENÚ DE LISTA DE CONTACTOS");
        System.out.println("\s\s1)Leer contactos");
        System.out.println("\s\s2)Crear un contacto nuevo");
        System.out.println("\s\s3)Listar todos los contactos");
        System.out.println("\s\s4)Buscar un contacto");
        System.out.println("\s\s5)Guardar contactos");
        System.out.println("\s\s6)//Salir//");  
    }//menuContactos
    
//--------------------------------------------------------------------------
    /**
     * Muestra el menú para imprimir los días de un mes como un calendario.
     * @param mensaje El mensaje a mostrar en la parte superior del menú.
     */
    private void menuImprimirMes(String mensaje)
    {
        System.out.println(mensaje);
        System.out.println("\s\s\s\s1)ENERO");
        System.out.println("\s\s\s\s2)FEBRERO");
        System.out.println("\s\s\s\s3)MARZO");
        System.out.println("\s\s\s\s4)ABRIL");
        System.out.println("\s\s\s\s5)MAYO");
        System.out.println("\s\s\s\s6)JUNIO");
        System.out.println("\s\s\s\s7)JULIO");
        System.out.println("\s\s\s\s8)AGOSTO");
        System.out.println("\s\s\s\s9)SEPTIEMBRE");
        System.out.println("\s\s\s\s10)OCTUBRE");
        System.out.println("\s\s\s\s11)NOVIEMBRE");
        System.out.println("\s\s\s\s12)DICIEMBRE");
        System.out.println("\s\s\s\s13)//Salir//");
    }//menuImprimirMes
    
//--------------------------------------------------------------------------
    /**
     * Muestra el menú principal y gestiona las selecciones del usuario.
     * @throws AWTException Si ocurre un error al borrar la consola.
     * @throws InterruptedException Si ocurre un error mientras se espera la 
entrada del usuario.
     */
    private void menu() throws AWTException, InterruptedException {
        int respuesta = 0, limite = 4;
        while (respuesta != limite)
        {
            limpiar();
            menuPrincipal();
            respuesta = eleccion(respuesta,limite);
            switch (respuesta)
            {
                case 1:
                {
                    do {                        
                        limpiar();
                        menuEventos();
                        limite = 12;
                        respuesta = eleccion(respuesta,limite);
                        eleccionMenuEventos(respuesta);
                    } while (respuesta != limite);
                    break;
                }
                case 2:
                {
                    do {                        
                        limpiar();
                        menuContactos();
                        limite = 6;
                        respuesta = eleccion(respuesta,limite);
                        eleccionMenuContactos(respuesta);
                    } while (respuesta != limite);
                    break;
                }
                case 3:
                {
                    do {                        
                        limpiar();
                        menuImprimirMes("--MENÚ DE IMPRESIÓN DE UN CALENDARIO MENSUAL");
                        limite = 13;
                        respuesta = eleccion(respuesta,limite);
                        eleccionMenuMes(respuesta);
                    } while (respuesta != limite);
                    break;
                }
                default : 
                {
                    limpiar();
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
     * @throws InterruptedException Si ocurre un error mientras se espera la 
entrada del usuario.
     */
    private void eleccionMenuEventos(int respuesta) throws AWTException, 
InterruptedException
    {
        
        switch (respuesta)
        {
            case 1  -> principal.crearRecordatorioTarea(respuesta);
            case 2  -> principal.crearRecordatorioTarea(respuesta);
            case 3  -> principal.borrarRecordatorioTarea(respuesta);
            case 4  -> principal.borrarRecordatorioTarea(respuesta);
            case 5  -> principal.imprimirEventos(respuesta);
            case 6  -> principal.imprimirEventos(respuesta);
            case 7  -> principal.imprimirEventos(respuesta);
            /*case 8  -> principal.leerFicheros();*/
            case 9  -> principal.guardarFicheroAnio();
            /*case 10 -> principal.guardarFicheroMes();
            case 11 -> principal.guardarFicheroDia();*/
            default -> menu();
        }
    }//eleccionMenuEventos
    
//--------------------------------------------------------------------------
    /**
     * Gestiona la selección de opciones del menú de contactos.
     * @param respuesta La opción seleccionada por el usuario.
     * @throws AWTException Si ocurre un error al borrar la consola.
     * @throws InterruptedException Si ocurre un error mientras se espera la 
entrada del usuario.
     */
    private void eleccionMenuContactos(int respuesta) throws AWTException, 
InterruptedException
    {
        switch (respuesta)
        {
            /*case 1  -> principal.leerContactos();
            case 2  -> principal.crearContacto();
            case 3  -> principal.listarContactos();
            case 4  -> principal.buscarContacto();
            case 5  -> principal.guardarCotacto();*/
            default -> menu();
        }
    }//eleccionMenuContactos
    
//--------------------------------------------------------------------------
    /**
     * Gestiona la selección de opciones del menú y muestra el calendario del 
mes correspondiente.
     * @param respuesta La opción seleccionada por el usuario.
     * @throws AWTException Si ocurre un error al borrar la consola.
     * @throws InterruptedException Si ocurre un error mientras se espera la 
entrada del usuario.
     */
    private void eleccionMenuMes(int respuesta) throws AWTException, 
InterruptedException
    {
        switch (respuesta)
        {
            case 1,2,4,5,6,7,8,9,10,11,12:
                Calendario.mostrarCalendario(respuesta, principal.getAnio());
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
     * Limpia la pantalla de la consola.
     * @throws AWTException Si se produce un error al acceder al robot.
     * @throws InterruptedException Si ocurre un error mientras se pausa el 
programa.
     */
    public void limpiar() throws AWTException, InterruptedException
    {
        Robot limpiar = new Robot();
        limpiar.keyPress(KeyEvent.VK_CONTROL);
        limpiar.keyPress(KeyEvent.VK_L);
        limpiar.keyRelease(KeyEvent.VK_CONTROL);
        limpiar.keyRelease(KeyEvent.VK_L);
        Thread.sleep(500);
        
    }//limpiar
    
//--------------------------------------------------------------------------
}//Class
