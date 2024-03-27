/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package my.company.creararchivotexto;

import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 *
 * @author RSojuel
 */

public class ManejoArchivoTexto {

    private static Formatter salida; // Envía texto a un archivo
    private static Scanner entrada; // Lee texto de un archivo

    public static void main(String[] args) {
        // Llama a los métodos para manejar el archivo
        abrirArchivo();
        agregarRegistros();
        cerrarArchivo();
        // Llama a los métodos para leer el archivo
        abrirArchivoLectura();
        leerRegistros();
        cerrarArchivoLectura();
    }

    // Abre el archivo para escritura, en modo de anexar
    public static void abrirArchivo() {
        try {
            // Utilizamos una ruta relativa
            salida = new Formatter(new FileOutputStream("clientes.csv", true)); // Abre el archivo en modo de anexar
        } catch (SecurityException securityException) {
            System.err.println("Permiso de escritura denegado. Terminado.");
            System.exit(1); // Termina el programa
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo. Terminado.");
            System.exit(1); // Termina el programa
        }
    }

    // Agrega registros al archivo
    public static void agregarRegistros() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Para finalizar el ingreso, escriba \"salir\"");
        System.out.println("Escriba número de cuenta, nombre, apellido y saldo");

        while (!entrada.hasNext("salir")) {
            try {
                // Escribe el nuevo registro en el archivo en formato CSV
                salida.format("%d,%s,%s,%.2f%n", entrada.nextInt(), entrada.next(), entrada.next(), entrada.nextDouble());
            } catch (FormatterClosedException formatterCloseException) {
                System.err.println("Error al escribir en el archivo. Terminado.");
                break;
            } catch (NoSuchElementException noSuchElementException) {
                System.err.println("Entrada inválida. Intente de nuevo.");
                entrada.nextLine(); // Descarta la entrada para intentar de nuevo
            }

            System.out.println("Ingrese un nuevo registro o escriba \"salir\" para finalizar el programa");
        }
    }

    // Cierra el archivo de escritura
    public static void cerrarArchivo() {
        if (salida != null) {
            salida.close();
        }
    }

    // Abre el archivo para lectura
    public static void abrirArchivoLectura() {
        try {
            entrada = new Scanner(Paths.get("clientes.csv"));
        } catch (IOException ioException) {
            System.err.println("Error al abrir el archivo. Terminado.");
            System.exit(1); // Termina el programa
        }
    }

    // Lee registros del archivo
    public static void leerRegistros() {
        System.out.printf("%-10s%-12s%-12s%10s%n", "Cuenta", "Primer Nombre", "Apellido", "Saldo");
        try {
            while (entrada.hasNext()) {
                // Lee el registro del archivo en formato CSV
                String[] campos = entrada.nextLine().split(",");
                int cuenta = Integer.parseInt(campos[0]);
                String nombre = campos[1];
                String apellido = campos[2];
                double saldo = Double.parseDouble(campos[3]);

                System.out.printf("%-10d%-12s%-12s%10.2f%n", cuenta, nombre, apellido, saldo);
            }
        } catch (NoSuchElementException | IllegalStateException | NumberFormatException e) {
            System.err.println("Error al leer el archivo. Terminado.");
        }
    }

    // Cierra el archivo de lectura
    public static void cerrarArchivoLectura() {
        if (entrada != null) {
            entrada.close();
        }
    }
}
