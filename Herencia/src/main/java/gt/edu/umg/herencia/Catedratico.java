/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.herencia;

/**
 *
 * @author RSojuel
 */
public class Catedratico extends Persona {
    
    private int codigoCatedratico;

    public Catedratico(String primerNombre, String segundoNombre, int codigoCatedratico) {
        super(primerNombre, segundoNombre);
        this.codigoCatedratico = codigoCatedratico;
    }
    
    public void mostrarInfo() {
        System.out.println("Primer Nombre: " + getPrimerNombre());
        System.out.println("Segundo Nombre: " + getSegundoNombre());
        System.out.println("Codigo Catedratico: " + codigoCatedratico);
    }
}
