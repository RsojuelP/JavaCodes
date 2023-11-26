/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.herencia;

/**
 *
 * @author RSojuel
 */
public class Persona extends Object {
    private String primerNombre;
    private String segundoNombre;
    public Persona() {
        
    }

    public Persona(String primerNombre, String segundoNombre) {
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }
    
    
}
