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
    public String getApellido()
    {
        return apellido;
    }
    //--------------------------------------------------------------------------
    public String getNombre()
    {
        return nombre;
    }
    //--------------------------------------------------------------------------
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
        System.out.println("Contacto {apellido = " + apellido + ", nombre = " + nombre + ", correo = " + correo + "}");
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