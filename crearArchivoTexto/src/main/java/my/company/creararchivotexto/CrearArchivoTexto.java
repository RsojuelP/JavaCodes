/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package my.company.creararchivotexto;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author RSojuel
 */
public class CrearArchivoTexto {

    private static Formatter salida; //envia texto a un archivo

    public static void main(String[] args) {
        abrirArchivo();
        leerRegistros();
        crearArchivo();
    }

    // abre el arcihhvo
    public static void abrirArchivo() {
        try {
            //usamos una ruta relativa
            salida = new Formatter("clientes.txt"); //abre el archivo
        } catch (SecurityException securityException) {
            System.err.println("Permiso de escritura denegado. Terminado.");
            System.exit(1);// termina el programa
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo. Terminado.");
            System.exit(1);// termina el programa
        }
    }

    //agregar registro al archivo
    public static void agregarRegistros1() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Para finalizar el ingreso teclee\"salir\"");
        System.out.println("Escriva numero de cuenta, nombre, apellido y saldo");

        while (!entrada.hasNext("salir")) // itera hasta encontrar el indicado de fin de archivo "salir"
        {
            try {
                salida.format("%d %s %s %.2f%n", entrada.nextInt());
            } catch (Exception e) {
            }
        }
    }
}