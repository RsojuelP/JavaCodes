/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package gt.edu.umg.polimorfismo;

/**
 *
 * @author RSojuel
 */
public class Polimorfismo {

    public static void main(String[] args) {
        Animal animal = new Perro();
        
        animal.comer();
        animal.dormir();
        animal.atacar();
    }
}
