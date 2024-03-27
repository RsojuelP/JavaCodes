/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package my.company.creararchivotexto;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author RSojuel
 */
public class CrearArchivoTexto {

    private static Formatter salida; //envia texto a un archivo

    public static void main(String[] args) {
        abrirArchivo();
        agregarRegistros();
        cerrarArchivo();
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
    public static void agregarRegistros() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Para finalizar el ingreso teclee\"salir\"");
        System.out.println("Escriva numero de cuenta, nombre, apellido y saldo");

        while (!entrada.hasNext("salir")) // itera hasta encontrar el indicado de fin de archivo "salir"
        {
            try {// escrive el nuevo registroen el archibo; asume una entrada valida
                // se agrega el formato esperado para cada entrada 
                // %d=Entero en base decimal 
                // %s=Cadena de caracteres 
                // %.2f=Numero real con punto fijo, .2 indica que maneja 2 decimales
                salida.format("%d %s %s %.2f%n", entrada.nextInt(), entrada.next(), entrada.next(), entrada.nextDouble());
            } catch (FormatterClosedException formatterCloseException) {
                System.err.println("Error al escribir en el archivo. terminado");
                break;
            } catch (NoSuchElementException noSuchElemenetException) {
                System.err.println("Entrada invalida. Intente de nuevo");
                entrada.nextLine(); // descarta la entrada para intentar de nuevo
            }

            System.out.println("Ingrese un nuevo registro o teclee \"salir\" para finalizar el programa");
        }// fin del siclo
    }// fin del metodo agregarRegistros

    // cierra el archivo
    public static void cerrarArchivo() {
        if (salida != null) {
            salida.close();
        }
    }
}
