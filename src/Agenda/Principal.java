package Agenda;

//API
import java.awt.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
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
    private ArrayList<Contacto> contactos = new ArrayList();
    //--------------------------------------------------------------------------

    /**
     * metodo para obtener el año del cual se va a crear la agenda.
     * @return anio el año de la agenda.
     */
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
    /**
     * Lee los eventos guardados en un archivo y los carga en la agenda del año.
     * Si se lee el archivo, los eventos guardados serán borrados de la agenda actual.
     *
     * @throws InterruptedException Si ocurre un error de E/S.
     */
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
                    System.out.println("Se han guardado " + cont + " eventos.");
                    Thread.sleep(3000);//Esperar 3 segundos
                } catch (IOException e) {
                    System.out.println(e.getMessage());                                                               
                }
            }
        }
    }//leerFicheroAnio
    //--------------------------------------------------------------------------
    /**
     * Vacia la agenda del año, eliminando todos los eventos de todos los meses.
     */
    private void vaciarAgendaAnio()
    {
        for (int i = 0; i < meses.size(); i++)
        {
            meses.get(i).vaciarAgendaMes();
        }
    }
    //--------------------------------------------------------------------------
    /**
     * Guarda los eventos leídos desde un archivo en la agenda del año.
     *
     * @param informacion La información del evento leída desde el archivo.
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    private void guardarEventos(String informacion) throws InterruptedException
    {
        LocalDate fecha = null;
        LocalTime hora = null;
        String tipo = null;
        String nombre = null;
        boolean adicional = false;
        boolean todoElDia = false;
        
        String infoEvento[] = informacion.split("\\|");
        fecha = LocalDate.parse(infoEvento[0]);
        if (infoEvento[1].equalsIgnoreCase("DIA"))
        {
            todoElDia = true;
        }
        else
        {
            hora = LocalTime.parse(infoEvento[1]);
        }
        tipo = infoEvento[2];
        nombre = infoEvento[3];
        if (infoEvento[4].equalsIgnoreCase("anual") || infoEvento[4].equalsIgnoreCase("urgente"))
        {
            adicional = true;
        }
        int mes = fecha.getMonthValue();
        meses.get(mes-1).aniadirEventoMes(fecha, hora, tipo, nombre, adicional, todoElDia);
    }
    //--------------------------------------------------------------------------
    /**
     * Guarda los eventos de un mes o día específico, o de todos los meses en un archivo, según la opción seleccionada por el usuario.
     *
     * @param eleccion La opción seleccionada por el usuario.
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public void guardarFicheroAnio(int eleccion) throws InterruptedException
    {
        if (eleccion == 10 || eleccion == 11)
        {
            int mes = 0;
            do
            {
                mes = Entrada.leerEntero("\s\s\sIntroduzca el numero del mes [1-12] > ");
            } while (mes < 1 || mes > 12);
            mes -= 1;
            
            if (meses.get(mes).hayEventos())
            {
                meses.get(mes).guardarFicheroMes(eleccion);
            }
            else
            {
                System.out.println("No hay eventos en " + meses.get(mes).getNombreMes());
            }
        }
        else
        {
            int cont = 0;
            do {            
                for (Mes mes : meses) {
                    if (mes.hayEventos())
                    {
                        mes.guardarFicheroMes(eleccion);
                    }
                    cont++;
                }
            } while (cont < 12);
        }
        
        try {
            System.out.println("Se han guardado los eventos en el fichero");
            Thread.sleep(3000);//Esperar 3 segundos
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //--------------------------------------------------------------------------
    /**
     * Lee los contactos guardados en un archivo y los carga en la agenda de contactos.
     * Si se lee el archivo, los contactos guardados serán borrados de la agenda actual.
     *
     * @throws InterruptedException Si ocurre un error de E/S.
     */
    public void leerContactos() throws InterruptedException
    {
        Entrada.limpiarBuffer();
        System.out.println("Si lees el fichero los contactos guardados seran borrados");
        String res = Entrada.leerCadena("¿Quieres continuar? [s,si/n,no] > ");
        
        if (res.equalsIgnoreCase("s") || res.equalsIgnoreCase("si"))
        {
            eliminarContactos();
            FileReader fr = null;
            String informacion = "";
            int cont = 0;

            try {
                fr = new FileReader("c:/ficheros/contactos.dat");
                BufferedReader entrada = new BufferedReader(fr);
                do {
                    informacion = entrada.readLine();
                    if (informacion != null)
                    {
                        guardarContactos(informacion);
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
                    System.out.println("Se han guardado " + cont + " contactos.");
                    Thread.sleep(3000);//Esperar 3 segundos
                } catch (IOException e) {
                    System.out.println(e.getMessage());                                                               
                }
            }
        }
    }
    //--------------------------------------------------------------------------
    /**
     * Elimina todos los contactos de la agenda.
     */
    private void eliminarContactos()
    {
        for (int i = 0; i < contactos.size(); i++) 
        {
            contactos.remove(i);
        }
    }
    //--------------------------------------------------------------------------
    /**
     * Guarda un contacto en la agenda de contactos.
     *
     * @param informacion La información del contacto a guardar.
     */
    private void guardarContactos(String informacion)
    {
        String infoContacto[] = informacion.split("\\|");
        String apellido = infoContacto[0];
        String nombre = infoContacto[1];
        String correo = infoContacto[2];
        
        contactos.add(new Contacto(apellido, nombre, correo));
    }
    //--------------------------------------------------------------------------
    /**
     * Crea un nuevo contacto y lo añade a la agenda de contactos.
     */
    public void crearContacto()
    {
        String correo = null;
        Entrada.limpiarBuffer();
        String apellido = Entrada.leerCadena("Introduce el apellido > ");
        String nombre = Entrada.leerCadena("Introduce el nombre > ");
        do {            
            correo = Entrada.leerCadena("Introduce el correo [@] > ");
        } while (!correo.contains("@"));
        
        contactos.add(new Contacto(apellido, nombre, correo));
        
        try {
            System.out.println("Se ha creado el contacto.");
            Thread.sleep(3000);//Esperar 3 segundos
        } catch (Exception e) {
        }
    }
    //--------------------------------------------------------------------------
    /**
     * Muestra la información de todos los contactos en la agenda.
     */
    public void listarContactos()
    {
        for (Contacto c : contactos)
        {
            c.infoContacto();
        }
        Entrada.esperarEnter();
    }
    //--------------------------------------------------------------------------
    /**
     * Busca un contacto en la agenda de contactos por su nombre o apellido.
     */
    public void buscarContacto()
    {
        Entrada.limpiarBuffer();
        String info = Entrada.leerCadena("Introduce el nombre o el apellido > ");
        info = info.toLowerCase();
        String nombre = null;
        String apellido = null;
        boolean encontrado = false;
        
        for (Contacto c : contactos)
        {
            nombre = c.getNombre().toLowerCase();
            apellido = c.getApellido().toLowerCase();
            
            if (nombre.contains(info) || apellido.contains(info))
            {
                c.infoContacto();
                encontrado = true;
            }
        }
        
        if (!encontrado)
        {
            try {
                System.out.println("No hay un contacto que se llame o apellide " + info);
                Thread.sleep(3000);//Esperar 3 segundos
            } catch (Exception e) {
            }
        }
        else
        {
            Entrada.esperarEnter();
        }
    }
    //--------------------------------------------------------------------------
    /**
     * Guarda los contactos de la agenda en un archivo.
     */
    public void guardarFicheroContactos()
    {
        FileWriter fw = null;
        String info = null;
        
        Entrada.limpiarBuffer();
        System.out.println("Si guardas en el fichero los antiguos contactos seran borrados");
        String res = Entrada.leerCadena("¿Quieres continuar? [s,si/n,no] > ");
        
        if (res.equalsIgnoreCase("s") || res.equalsIgnoreCase("si"))
        {
            String rutaArchivo = "c:/ficheros/contactos.dat";
            Path archivo = Paths.get(rutaArchivo);
            
            try {
                Files.deleteIfExists(archivo);
            } catch (Exception e) {
                System.out.println("No se puedo borrar el archivo " + e.getMessage());
            }
            
            try 
            {
                fw = new FileWriter("c:/ficheros/contactos.dat",true);
                PrintWriter salida = new PrintWriter(fw);

                for (Contacto c : contactos)
                {
                    info = c.ficheroContacto();
                    if (info != null)
                    {
                        salida.println(info);
                        salida.flush();
                    }
                }
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
                    try {
                        System.out.println("Se ha guardo el archivo correctamente");
                        Thread.sleep(3000);//Esperar 3 segundos
                    } catch (Exception e) {
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());                                                               
                }
            }
        }
    }
    //--------------------------------------------------------------------------
}//Class