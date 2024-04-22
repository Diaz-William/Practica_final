package Agenda;

import java.util.Scanner;

public class Entrada {
    Scanner entrada = new Scanner(System.in);
    
    
    //METODOS
    public int leerEntero(String mensaje) {
        System.out.print(mensaje);
        return (entrada.nextInt());
    }//leerEntero
    //--------------------------------------------------------------------------
    public String leerCadena(String mensaje) {
        System.out.print(mensaje);
        return (entrada.nextLine());
    }//leerCadena
    //--------------------------------------------------------------------------
    public void limpiarBuffer() {
        entrada.nextLine();
    }
}//Class
