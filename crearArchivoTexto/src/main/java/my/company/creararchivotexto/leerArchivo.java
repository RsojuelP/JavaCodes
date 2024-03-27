/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package my.company.creararchivotexto;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author RSojuel
 */
public class leerArchivo {

    private static Scanner entrada;

    public static void main(String[] args) {
        abrirArchivo();
        leerRegistros();
        cerrarArchivo();
    }
    
    // abre el archivo clientes.   txt
    public static void abrirArchivo() {
        try {
            entrada = new Scanner(Paths.get("clientes.txt"));
        } catch(IOException ioException){
            System.err.println("Error al abrir el archivo. Terminado.");
            System.exit(1);// termina el programa
        }
    }
    
    public static void leerRegistros() {
        System.out.printf("%-10s%-12s%-12s%10s%n", "Cuenta", "Primer Nombre", "Apellido", "Saldo");
        try {
            while (entrada.hasNext())// mientras haya mas que leer
            {
                System.out.printf("%-10d%-12s%-12s%10.2f%n", entrada.nextInt(), entrada.next(), entrada.next(), entrada.nextDouble());
            }
        } catch (NoSuchElementException elementException) {
            System.err.println("El archivo no esta bien formado. terminado.");
        } catch (IllegalStateException stateException) {
            System.err.println("Error al leer el archivo. Terminado");
        }
    }// fin del metodo leerRegistros
    
    public static void cerrarArchivo() {
        if (entrada != null) {
            entrada.close();
        }
    }
}
