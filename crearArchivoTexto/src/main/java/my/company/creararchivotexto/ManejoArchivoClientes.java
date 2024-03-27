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
public class ManejoArchivoClientes {

    private static Scanner entrada; // Lee texto de un archivo

    public static void main(String[] args) {
        ManejoArchivoClientes menu = new ManejoArchivoClientes();
        menu.menuPrincipal();
    }

    public void menuPrincipal() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("------ Menu Prinipal ------");
            System.out.println("1) Ingresar Registro");
            System.out.println("2) Leer Registros");
            System.out.println("3) Actualizar Registros");
            System.out.println("4) Borrar registro");
            System.out.println("5) Salir del Programa");
            System.out.print("Ingrese una opcion: ");
            opcion = sc.nextInt();
            opcionMenuPrincipal(opcion);
        } while (opcion != 5);

    }

    public void opcionMenuPrincipal(int opcion) {
        switch (opcion) {
            case 1:
                agregarRegistros();
                break;
            case 2:
                leerRegistros();
                break;
            case 3:
                Scanner numeroCuenta = new Scanner(System.in);
                System.out.println("Ingrese el numero de cuenta a actualizar");
                int numero = numeroCuenta.nextInt();
                actualizarRegistro(numero);
                break;
            case 4:
                Scanner eliminarCuenta = new Scanner(System.in);
                System.out.println("Ingrese el numero de cuenta a eliminar");
                int eliminar = eliminarCuenta.nextInt();
                eliminarRegistro(eliminar);
                break;
            case 5:
                break;
            default:
                System.out.println("Opcion no valida, intente nuevamente");
        }
    }

    // Agrega registros al archivo
    public static void agregarRegistros() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Para finalizar el ingreso, escriba \"salir\"");
        System.out.println("Escriba número de cuenta, nombre, apellido y saldo");

        try (Formatter salida = new Formatter(new FileOutputStream("clientes.csv", true))) {
            while (!entrada.hasNext("salir")) {
                try {
                    // Escribe el nuevo registro en el archivo en formato CSV
                    salida.format("%d;%s;%s;%.2f%n", entrada.nextInt(), entrada.next(), entrada.next(), entrada.nextDouble());
                } catch (FormatterClosedException formatterCloseException) {
                    System.err.println("Error al escribir en el archivo. Terminado.");
                    break;
                } catch (NoSuchElementException noSuchElementException) {
                    System.err.println("Entrada inválida. Intente de nuevo.");
                    entrada.nextLine(); // Descarta la entrada para intentar de nuevo
                }

                System.out.println("Ingrese un nuevo registro o escriba \"salir\" para finalizar el programa");
            }
        } catch (SecurityException | FileNotFoundException e) {
            System.err.println("Error al abrir el archivo para escritura. Terminado.");
        }
    }

    // Actualiza un registro en el archivo
    public static void actualizarRegistro(int numeroCuenta) {
        List<String> lineas = leerArchivoComoLista("clientes.csv");
        for (int i = 0; i < lineas.size(); i++) {
            String[] campos = lineas.get(i).split(";");
            int cuenta = Integer.parseInt(campos[0]);
            if (cuenta == numeroCuenta) {
                // Aquí puedes realizar la actualización de los campos necesarios
                campos[1] = "NuevoNombre";
                campos[2] = "NuevoApellido";
                campos[3] = "1000.00";
                lineas.set(i, String.join(";", campos));
                break; // Sal del bucle una vez que se haya actualizado el registro
            }
        }
        escribirListaEnArchivo(lineas, "clientes.csv");
    }

    // Elimina un registro del archivo
    public static void eliminarRegistro(int numeroCuenta) {
        List<String> lineas = leerArchivoComoLista("clientes.csv");
        Iterator<String> iterator = lineas.iterator();
        while (iterator.hasNext()) {
            String linea = iterator.next();
            String[] campos = linea.split(";");
            int cuenta = Integer.parseInt(campos[0]);
            if (cuenta == numeroCuenta) {
                iterator.remove(); // Elimina la línea del registro del iterador
                break; // Sal del bucle una vez que se haya eliminado el registro
            }
        }
        escribirListaEnArchivo(lineas, "clientes.csv");
    }

    // Lee el archivo y lo devuelve como una lista de cadenas
    public static List<String> leerArchivoComoLista(String nombreArchivo) {
        List<String> lineas = new ArrayList<>();
        try {
            entrada = new Scanner(Paths.get(nombreArchivo));
            while (entrada.hasNextLine()) {
                lineas.add(entrada.nextLine());
            }
        } catch (IOException ioException) {
            System.err.println("Error al leer el archivo. Terminado.");
            System.exit(1); // Termina el programa
        } finally {
            if (entrada != null) {
                entrada.close();
            }
        }
        return lineas;
    }

    // Escribe una lista de cadenas en el archivo
    public static void escribirListaEnArchivo(List<String> lineas, String nombreArchivo) {
        try (PrintWriter salida = new PrintWriter(new FileWriter(nombreArchivo))) {
            for (String linea : lineas) {
                salida.println(linea);
            }
        } catch (IOException ioException) {
            System.err.println("Error al escribir en el archivo. Terminado.");
            System.exit(1); // Termina el programa
        }
    }

    // Lee registros del archivo y los muestra en la consola
    public static void leerRegistros() {
        System.out.printf("%-10s%-12s%-12s%10s%n", "Cuenta", "Primer Nombre", "Apellido", "Saldo");
        List<String> lineas = leerArchivoComoLista("clientes.csv");
        for (String linea : lineas) {
            String[] campos = linea.split(";");
            if (campos.length >= 4) { // Verifica que haya al menos 4 campos en la línea
                int cuenta = Integer.parseInt(campos[0]);
                String nombre = campos[1];
                String apellido = campos[2];
                double saldo = Double.parseDouble(campos[3]); // Tratar el saldo como double

                System.out.printf("%-10d%-12s%-12s%10.2f%n", cuenta, nombre, apellido, saldo);
            } else {
                System.err.println("Error: La línea no tiene el formato esperado: " + linea);
            }
        }
    }
}
