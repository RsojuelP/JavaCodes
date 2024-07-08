/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.miumg.biblioteca;

/**
 *
 * @author EMPAQUE
 */
public class Libro {

    private String nombre;
    private String autor;
    private String isbn;
    private boolean prestado;

    public Libro(String nombre, String autor, String isbn) {
        this.nombre = nombre;
        this.autor = autor;
        this.isbn = isbn;
        this.prestado = false;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean estaPrestado() {
        return prestado;
    }

    public void prestar() {
        this.prestado = true;
    }
    
    public void devolver(){
        this.prestado = false;
    }
}
