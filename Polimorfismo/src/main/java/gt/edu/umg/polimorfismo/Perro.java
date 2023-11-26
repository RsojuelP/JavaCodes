/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.polimorfismo;

/**
 *
 * @author RSojuel
 */
public class Perro extends Animal {
    
    @Override
    public void comer() {
        System.out.println("Perro come");
    }
    
    @Override
    public void dormir() {
        System.out.println("Perro Duerme");
    }
}
