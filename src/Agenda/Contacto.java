package Agenda;

/**
 * Clase que representa un contacto en una agenda.
 */
public class Contacto
{
    /**El apellido del contacto.*/
    String apellido;
    /**El nombre del contacto.*/
    String nombre;
    /**El correo del contacto.*/
    String correo;
    
    //Constructor
    
    //--------------------------------------------------------------------------
    /**
     * Crea un nuevo contacto con el apellido, nombre y correo electrónico dados.
     * 
     * @param apellido El apellido del contacto.
     * @param nombre El nombre del contacto.
     * @param correo El correo del contacto.
     */
    public Contacto(String apellido, String nombre, String correo)
    {
        this.apellido = apellido;
        this.nombre = nombre;
        this.correo = correo;
    }
    //--------------------------------------------------------------------------
    
    //Getters & Setters
    
    //--------------------------------------------------------------------------

    /**
     * metodo para obtener el apellido del contacto.
     * @return apellido el apellido del contacto.
     */
    public String getApellido()
    {
        return apellido;
    }
    //--------------------------------------------------------------------------

    /**
     * metodo para obtener el nombre del contacto.
     * @return nombre el nombre del contacto.
     */
    public String getNombre()
    {
        return nombre;
    }
    //--------------------------------------------------------------------------

    /**
     * metodo para obtener el correo del contacto.
     * @return correo el correo del contacto.
     */
    public String getCorreo()
    {
        return correo;
    }
    //--------------------------------------------------------------------------
    
    //Metodos
    
    //--------------------------------------------------------------------------
    /**
     * Imprime la información del contacto por consola.
     */
    public void infoContacto()
    {
        System.out.println("\s\s\sApellido : " + apellido + "\n\s\s\sNombre   : " + nombre + "\n\s\s\sCorreo   : " + correo );
        System.out.println("---------------------------------------------------------------");
    }
    //--------------------------------------------------------------------------
    /**
     * Devuelve una cadena con la infomación del contacto en el formato "apellido|nombre|correo".
     * 
     * @return la información del contacto como cadena.
     */
    public String ficheroContacto()
    {
        String info = apellido + "|" + nombre + "|" + correo;
        return info;
    }
    //--------------------------------------------------------------------------
}//Class